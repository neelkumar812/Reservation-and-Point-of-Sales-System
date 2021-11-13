package com.cz2002.ss10.utils;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.person.*;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.lang.Integer;
import java.util.stream.*;
import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StaffCsv implements IExtractCsv, IExportCsv {

	public Map<String, List<String>> extractInputFromCSV(String filePath) {
		Map<String, List<String>> staffItemMap = new HashMap<String, List<String>>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> r = reader.readAll(); // nested lists of lists
			r.forEach(staffItem -> staffItemMap.put(staffItem[0],getStaffInfoAsList(staffItem)));

			return staffItemMap;
		}
		catch (FileNotFoundException error) {
			throw new RuntimeException("File not found at specified file path!", error);
		}
		catch (IOException error) {
			throw new RuntimeException("Bad input obtained!", error);
		}
		catch (CsvException error) {
			throw new RuntimeException("Error encountered converting from CSV!", error);
		}

	}

	private List<String> getStaffInfoAsList(String[] staffItem) {
		List<String> staffInfo = new ArrayList<String>();
		staffInfo.addAll(Arrays.asList(staffItem[1], staffItem[2], staffItem[3]));
		return staffInfo;
	}

	public void exportOutputToCSV(String formattedCsvString, String filePath) throws IOException {
		try {
			File f = new File(filePath);
			FileWriter writer = new FileWriter(f, true);
			String[] header = { "Staff Name", "Staff ID", "Gender", "Job Title" };
			writer.write(String.join(",", header));
			writer.write("\n");
			writer.write(System.getProperty("line.separator"));
			writer.close();
		} catch (IOException ioError) {
			throw new RuntimeException("Error encountered converting output to CSV", ioError);
		}

	}

	/**
	 * 
	 * @param staffList
	 */
	public void insertStaffList(Map<String, List<String>> staffList) {
		for (Map.Entry<String, List<String>> entry : staffList.entrySet()) {
			// get staff info
			List<String> staffInfo = entry.getValue();

			// add StaffItem object to StaffItems ArrayList in RestaurantApp
			RestaurantApp.staffs.add(new Staff(entry.getKey(), staffInfo.get(0).charAt(0), (int)Integer.valueOf(staffInfo.get(1)), staffInfo.get(2)));
		}
	}

	/**
	 * 
	 * @param staffList
	 */
	public String formatStaffToString(ArrayList<Staff> staffList) {
		String outputAsStrings = staffList.stream().map(staff -> toRows(staff))
				.collect(Collectors.joining(System.getProperty("line.separator"))); // OS dependent line separator

		return outputAsStrings;
	}

	private String toRows(Staff staff) {
		return Stream
				.of(staff.getStaffName(), ((Integer) staff.getStaffID()).toString(), staff.getGender(),
						staff.getJobTitle())
				.map(value -> value.replaceAll("\"", "\"\""))
				.map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
				.collect(Collectors.joining(","));
	}
}
