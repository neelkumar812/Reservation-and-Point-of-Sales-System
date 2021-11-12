package com.cz2002.ss10.objects.logistics;

import java.time.*;

/**
 * ReveneuReport Class
 *
 * @author Neel Kumar 
 * @version 1.0
 * @since 2021-11-09
 */

public class RevenueReport {

	public enum ReportDuration {
		DAY, MONTH, YEAR
	}

	private ReportDuration period;
	private LocalDate date;
	private double revenue;
	private double profit;
	private double cost;

	public void printReport() {
		System.out.println("========= Revenue Report =========");
		System.out.println("Date: " + date);
		System.out.println("Period: " + period);
		System.out.println("Revenue: " + revenue);
		System.out.println("Profit: " + profit);
		System.out.println("Cost: " + cost);
		System.out.println("==================================");
		throw new UnsupportedOperationException();
	}

}