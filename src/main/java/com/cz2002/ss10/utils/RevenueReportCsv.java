package com.cz2002.ss10.utils;

import com.cz2002.ss10.objects.logistics.*;

import java.lang.Integer;
import java.time.LocalDate;
import java.util.stream.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class RevenueReportCsv implements IExportCsv {
	public enum ReportDuration {
		DAY, MONTH, YEAR
	}

	@Override
	public void exportOutputToCSV(String formattedCsvString, String filePath) throws IOException {
		try{
		FileWriter writer = new FileWriter(filePath);
		writer.write(formattedCsvString);
		writer.close();
		}
		catch (IOException ioError) {
			throw new RuntimeException("Error encountered converting output to CSV", ioError);
		}
		

	}

	/**
	 * 
	 * @param report
	 * Prints summary of revenue by specified period
	 */
	public String formatReportToString(ArrayList<Order> orders, ReportDuration reportPeriod) {
		ArrayList<Order> ordersForDuration = new ArrayList<Order>();
		if (reportPeriod == ReportDuration.DAY) {
			// traverse through array for orders on today's date
			ordersForDuration = orders.stream().filter(order -> order.getCreatedAt().toLocalDate().isAfter(LocalDate.now())).collect(Collectors.toCollection(ArrayList::new));
		}
		else if (reportPeriod == ReportDuration.MONTH) {
			// traverse through array for orders for this month
			ordersForDuration = orders.stream().filter(order -> order.getCreatedAt().toLocalDate().isAfter(LocalDate.now().withDayOfMonth(1))).collect(Collectors.toCollection(ArrayList::new));	
		}
		else {
			// traverse through array for orders on this year
			ordersForDuration = orders.stream().filter(order -> order.getCreatedAt().toLocalDate().isAfter(LocalDate.now().withDayOfYear(1))).collect(Collectors.toCollection(ArrayList::new));
		}
		
		// convert all orders to string
		String outputAsStrings = ordersForDuration.stream()
        .map(order -> toRows(order))
        .collect(Collectors.joining(System.getProperty("line.separator"))); // OS dependent line separator

		return outputAsStrings;
	}

	private String toRows(Order order) {
		return Stream.of(((Integer)order.getOrderId()).toString(), ((Integer)order.getStaff().getStaffID()).toString(), order.getMembershipType(), ((Integer)order.getTableNumber()).toString(), String.valueOf(order.getSubtotal()), order.getCreatedAt().toString())
				.map(value -> value.replaceAll("\"", "\"\""))
				.map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
				.collect(Collectors.joining(","));
	}

	}
