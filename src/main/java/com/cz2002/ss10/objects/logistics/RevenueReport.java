package com.cz2002.ss10.objects.logistics;

import java.time.*;

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
		// TODO - implement RevenueReport.printReport
		throw new UnsupportedOperationException();
	}

}