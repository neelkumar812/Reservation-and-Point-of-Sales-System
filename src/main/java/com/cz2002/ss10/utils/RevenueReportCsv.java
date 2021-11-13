package com.cz2002.ss10.utils;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.food.*;

import java.lang.Integer;
import java.time.LocalDate;
import java.util.stream.*;
import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class RevenueReportCsv implements IExportCsv {
	private String durationAsString; 
	private String dateAsString; 
	private String totalRevenueAsString;
	public enum ReportDuration {
		DAY, MONTH, YEAR
	}

	public void exportOutputToCSV(String formattedCsvString, String filePath) throws IOException {
		try {
			File f = new File(filePath);
			FileWriter writer = new FileWriter(f, true);

			// add period and date
			writer.write("Period: " + this.durationAsString);
			writer.write(System.getProperty("line.separator"));
			writer.write("Date: " + this.dateAsString);
			writer.write(System.getProperty("line.separator"));

			// add headers
			String[] header = { "Item", "Item Type", "Quantity Sold", "Price" };
			writer.write(String.join(",", header));
			writer.write(System.getProperty("line.separator"));
			
			// add sale items
			writer.write(formattedCsvString);
			writer.write(System.getProperty("line.separator"));

			writer.write("Total Revenue: " + this.totalRevenueAsString);
			writer.write(System.getProperty("line.separator"));

			writer.close();
		} catch (IOException ioError) {
			throw new RuntimeException("Error encountered converting output to CSV", ioError);
		}

	}

	/**
	 * 
	 * @param report Prints summary of revenue by specified period
	 */
	public String formatReportToString(ArrayList<Order> orders, ReportDuration reportPeriod) {
		setDuration(reportPeriod);
		ArrayList<Order> ordersForDuration = new ArrayList<Order>();
		if (reportPeriod == ReportDuration.DAY) {
			// traverse through array for orders on today's date
			setDate(LocalDate.now());
			ordersForDuration = orders.stream()
					.filter(order -> order.getCreatedAt().toLocalDate().isAfter(LocalDate.now()))
					.collect(Collectors.toCollection(ArrayList::new));
		} else if (reportPeriod == ReportDuration.MONTH) {
			// traverse through array for orders for this month
			setDate(LocalDate.now().withDayOfMonth(1));
			ordersForDuration = orders.stream()
					.filter(order -> order.getCreatedAt().toLocalDate().isAfter(LocalDate.now().withDayOfMonth(1)))
					.collect(Collectors.toCollection(ArrayList::new));
		} else {
			// traverse through array for orders on this year
			setDate(LocalDate.now().withDayOfYear(1));
			ordersForDuration = orders.stream()
					.filter(order -> order.getCreatedAt().toLocalDate().isAfter(LocalDate.now().withDayOfYear(1)))
					.collect(Collectors.toCollection(ArrayList::new));
		}

		// organise different food items into their own rows
		HashMap<String, Integer> itemMap = new HashMap<String, Integer>();

		// index all available restaurant items into hash map
		int index = 0; 
		while (RestaurantApp.menuItems.size() > index) {
			itemMap.put(RestaurantApp.menuItems.get(index++).getName(), 0);
		}
		index = 0;
		while (RestaurantApp.promotionItems.size() > index) {
			itemMap.put(RestaurantApp.promotionItems.get(index++).getName(), 0);
		}
		Iterator<Order> iterator = orders.iterator();
		while (iterator.hasNext()){
			for (RestaurantItem orderItem : iterator.next().getOrderItems()){
				// update sale count for every item sold
				String key = orderItem.getName();
				itemMap.put(key, itemMap.get(key) + 1);
			}
		}
		
		// Get Hash Map of Item Name as key and Quantity Sold | Price | Item Type as array string
		HashMap<String, ArrayList<String>> itemStringMap = new HashMap<String, ArrayList<String>>();
		while (RestaurantApp.menuItems.size() > index) {
			String itemName = RestaurantApp.menuItems.get(index).getName();
			String price = String.valueOf(RestaurantApp.menuItems.get(index).getPrice());
			String itemType = RestaurantApp.menuItems.get(index++).getMenuItemType().toString();
			ArrayList<String> itemInfo = new ArrayList<String>();
			itemInfo.addAll(Arrays.asList(((Integer)itemMap.get(itemName)).toString(), price, itemType));
			itemStringMap.put(itemName, itemInfo);
		}
		index = 0;
		while (RestaurantApp.promotionItems.size() > index) {
			String itemName = RestaurantApp.promotionItems.get(index).getName();
			String price = String.valueOf(RestaurantApp.promotionItems.get(index++).getPrice());
			String itemType = "Promotion Item";
			ArrayList<String> itemInfo = new ArrayList<String>();
			itemInfo.addAll(Arrays.asList(((Integer)itemMap.get(itemName)).toString(), price, itemType));
			itemStringMap.put(itemName, itemInfo);
		}
	
		// calculate and set total revenue
		setTotalRevenue(orders.stream().map(order -> order.getSubtotal()).mapToDouble(total -> total).sum());

		// convert all orders to string
		String outputAsStrings = ordersForDuration.stream().map(order -> toRows(order))
				.collect(Collectors.joining(System.getProperty("line.separator"))); // OS dependent line separator

		return outputAsStrings;
	}
	private void setDuration(ReportDuration reportPeriod){
		this.durationAsString = reportPeriod.toString();
	}

	private void setTotalRevenue(double total){
		this.totalRevenueAsString = String.valueOf(total);
	}

	private void setDate(LocalDate reportDate) {
		this.dateAsString = reportDate.toString();
	}

	// convert menu items to individual sale items, item type, price
	// add total revenue
	private String toRows(Order order) {
		return Stream
				.of(((Integer) order.getOrderId()).toString(), ((Integer) order.getStaff().getStaffID()).toString(),
						order.getMembershipType(), ((Integer) order.getTableNumber()).toString(),
						String.valueOf(order.getSubtotal()), order.getCreatedAt().toString())
				.map(value -> value.replaceAll("\"", "\"\""))
				.map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
				.collect(Collectors.joining(","));
	}

}
