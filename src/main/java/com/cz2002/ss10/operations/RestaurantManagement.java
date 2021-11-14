package com.cz2002.ss10.operations;

import com.cz2002.ss10.RestaurantApp;

import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.utils.RevenueReportCsv;
import com.cz2002.ss10.utils.StaffCsv;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.utils.RevenueReportCsv.ReportDuration;

import java.lang.Integer;
import java.time.LocalDate;
import java.util.stream.*;
import java.util.*;
import java.io.IOException;

public class RestaurantManagement {

	/**
	 * Manually insertion of new staff
	 * 
	 * @param name
	 * @param gender
	 * @param employeeID
	 * @param jobTitle
	 */
	public static void addStaff(String name, char gender, int employeeID, String jobTitle) {
		RestaurantApp.staffs.add(new Staff(name, gender, employeeID, jobTitle));
	}

	/**
	 * Mass insertion of new staff
	 * 
	 * @param filePath
	 */
	public static void addStaff(String filePath) {
		try {
			StaffCsv staffCsvHelper = new StaffCsv();
			Map<String, List<String>> staffMap = staffCsvHelper.extractInputFromCSV(filePath);
			staffCsvHelper.insertStaffList(staffMap);
		} catch (Exception error) {
			System.out.println("Failed to insert new staff from CSV! " + error.toString());
		}
	}

	/**
	 * 
	 * @param orders
	 */
	public static void generateRevenueReport(ArrayList<Order> orders, ReportDuration reportPeriod, String filePath) {
		try {
			RevenueReportCsv revReportHelper = new RevenueReportCsv();
			revReportHelper.exportOutputToCSV(revReportHelper.formatReportToString(orders, reportPeriod), filePath);
		} catch (IOException error) {
			System.out.println("Failed I/O operation when exporting to CSV!\n " + error.toString());
		}
	}

	public static void generateRevenueReport(ArrayList<Order> orders, ReportDuration reportPeriod){
		ArrayList<Order> ordersForDuration = new ArrayList<Order>();
		LocalDate date = LocalDate.now();
		if (reportPeriod == ReportDuration.DAY) {
			// traverse through array for orders on today's date

			ordersForDuration = orders.stream()
					.filter(order -> order.getCreatedAt().toLocalDate().isAfter(LocalDate.now()))
					.collect(Collectors.toCollection(ArrayList::new));
		} else if (reportPeriod == ReportDuration.MONTH) {
			date = LocalDate.now().withDayOfMonth(1);
			// traverse through array for orders for this month
			ordersForDuration = orders.stream()
					.filter(order -> order.getCreatedAt().toLocalDate().isAfter(LocalDate.now().withDayOfMonth(1)))
					.collect(Collectors.toCollection(ArrayList::new));
		} else {
			date = LocalDate.now().withDayOfYear(1);
			// traverse through array for orders on this year
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
		Iterator<Order> iterator = ordersForDuration.iterator();
		while (iterator.hasNext()){
			for (RestaurantItem orderItem : iterator.next().getOrderItems()){
				// update sale count for every item sold
				String key = orderItem.getName();
				itemMap.put(key, itemMap.get(key) + 1);
			}
		}
		
		HashMap<String, ArrayList<String>> itemStringMap = new HashMap<String, ArrayList<String>>();
		while (RestaurantApp.menuItems.size() > index) {
			String itemName = RestaurantApp.menuItems.get(index).getName();
			String price = String.valueOf(RestaurantApp.menuItems.get(index).getPrice());
			String itemType = RestaurantApp.menuItems.get(index++).getMenuItemType().toString();
			ArrayList<String> itemInfo = new ArrayList<String>();
			itemInfo.addAll(Arrays.asList(itemName, ((Integer)itemMap.get(itemName)).toString(), price, itemType));
			itemStringMap.put(itemName, itemInfo);
		}
		index = 0;
		while (RestaurantApp.promotionItems.size() > index) {
			String itemName = RestaurantApp.promotionItems.get(index).getName();
			String price = String.valueOf(RestaurantApp.promotionItems.get(index++).getPrice());
			String itemType = "Promotion Item";
			ArrayList<String> itemInfo = new ArrayList<String>();
			itemInfo.addAll(Arrays.asList(itemName, ((Integer)itemMap.get(itemName)).toString(), price, itemType));
			itemStringMap.put(itemName, itemInfo);
		}


		System.out.println("Period:" + reportPeriod.toString());
		System.out.println("Date: " + date.toString());
		System.out.println("Item           ||       Item Type     ||     Quantity Sold     ||    Price    ");
		for (Map.Entry<String, ArrayList<String>> entry : itemStringMap.entrySet()) {
			ArrayList<String> itemInfo= entry.getValue();
			System.out.printf("%s %s %s %s %s\n",itemInfo.get(0), itemInfo.get(1),itemInfo.get(2),itemInfo.get(3),itemInfo.get(4));
		}

		// calculate and set total revenue
		double totalRevenue = ordersForDuration.stream().map(order -> order.getSubtotal()).mapToDouble(total -> total).sum();
		System.out.printf("Total Revenue %d\n", totalRevenue);
	}

	/**
	 * Iterate through staff list and return true if removed
	 * 
	 * @param employeeID
	 */
	public static boolean removeStaff(int employeeID) {
		// find index in staff list

		// remove staff by index
		Iterator<Staff> iter = RestaurantApp.staffs.iterator();
		while (iter.hasNext()) {
			if (((Integer) iter.next().getStaffID()).equals(employeeID)) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

}