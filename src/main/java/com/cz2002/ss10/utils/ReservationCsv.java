package com.cz2002.ss10.utils;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.logistics.*;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.time.LocalDate;
import java.io.FileReader;

public class ReservationCsv implements IExtractCsv {

    public Map<String, List<String>> extractInputFromCSV(String filePath) {
		Map<String, List<String>> reservationMap = new HashMap<String, List<String>>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> r = reader.readAll(); // nested lists of lists
			r.forEach(reservation -> reservationMap.put(reservation[0],getReservationInfoAsList(reservation)));

			return reservationMap;
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

	private List<String> getReservationInfoAsList(String[] reservationItem) {
		List<String> reservationInfo = new ArrayList<String>();
		reservationInfo.addAll(Arrays.asList(reservationItem[1], reservationItem[2], reservationItem[3], reservationItem[4], reservationItem[5]));
		return reservationInfo;
	}

	/**
	 * 
	 * @param reservationList
	 */
	public void insertReservationList(Map<String, List<String>> reservationList) {
		for (Map.Entry<String, List<String>> entry : reservationList.entrySet()) {
			// get reservation info
			List<String> reservationInfo = entry.getValue();

			// add Reservation object to Reservation ArrayList in RestaurantApp
			RestaurantApp.reservations.add(new Reservation((int)Integer.parseInt(entry.getKey()), LocalDate.parse(reservationInfo.get(0)), LocalTime.parse(reservationInfo.get(1)), (int)Integer.valueOf(reservationInfo.get(2)), reservationInfo.get(3), (int)Integer.valueOf(reservationInfo.get(4))));
		}
	}

}