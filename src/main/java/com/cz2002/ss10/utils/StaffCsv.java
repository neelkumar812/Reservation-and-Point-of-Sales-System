package com.cz2002.ss10.utils;

import com.cz2002.ss10.objects.person.*;

import java.lang.Integer;
import java.time.LocalDate;
import java.util.stream.*;
import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class StaffCsv implements IExtractCsv, IExportCsv {

    @Override
    public Map<String, List<String>> extractInputFromCSV(String fileName) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void exportOutputToCSV(String formattedCsvString, String filePath) throws IOException {
		try{
		File f = new File(filePath);
		FileWriter writer = new FileWriter(f, true);
		String[] header = { "Staff Name", "Staff ID", "Gender", "Job Title" };
		writer.write(String.join(",",header));
		writer.write("\n");
		writer.write(System.getProperty("line.separator"));
		writer.close();
		}
		catch (IOException ioError) {
			throw new RuntimeException("Error encountered converting output to CSV", ioError);
		}
	
	}

	/**
	 * 
	 * @param staffList
	 */
	public ArrayList<Staff> insertStaffList(Map<String, List<String>> staffList) {
		// TODO - implement StaffCsv.insertStaffList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param staffList
	 */
	public String formatStaffToString(ArrayList<Staff> staffList) {
		String outputAsStrings = staffList.stream()
        .map(staff -> toRows(staff))
        .collect(Collectors.joining(System.getProperty("line.separator"))); // OS dependent line separator

		return outputAsStrings;
	}

	private String toRows(Staff staff) {
		return Stream.of(staff.getStaffName(), ((Integer)staff.getStaffID()).toString(), staff.getGender(), staff.getJobTitle())
				.map(value -> value.replaceAll("\"", "\"\""))
				.map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
				.collect(Collectors.joining(","));
	}
	}

}