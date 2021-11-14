package com.cz2002.ss10.operations;

import com.cz2002.ss10.RestaurantApp;

import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.utils.RevenueReportCsv;
import com.cz2002.ss10.utils.StaffCsv;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.utils.RevenueReportCsv.ReportDuration;

import java.io.IOException;
import java.lang.Exception;
import java.util.*;

public class RestaurantManagement {

	/**
	 * Manually insertion of new staff
	 * 
	 * @param name
	 * @param gender
	 * @param employeeID
	 * @param jobTitle
	 */
	public void addStaff(String name, char gender, int employeeID, String jobTitle) {
		RestaurantApp.staffs.add(new Staff(name, gender, employeeID, jobTitle));
	}

	/**
	 * Mass insertion of new staff
	 * 
	 * @param filePath
	 */
	public void addStaff(String filePath) {
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
	public void generateRevenueReport(ArrayList<Order> orders, ReportDuration reportPeriod, String filePath) {
		try {
			RevenueReportCsv revReportHelper = new RevenueReportCsv();
			revReportHelper.exportOutputToCSV(revReportHelper.formatReportToString(orders, reportPeriod), filePath);
		} catch (IOException error) {
			System.out.println("Failed I/O operation when exporting to CSV!\n " + error.toString());
		}
	}

	/**
	 * Iterate through staff list and return true if removed
	 * 
	 * @param employeeID
	 */
	public boolean removeStaff(int employeeID) {
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