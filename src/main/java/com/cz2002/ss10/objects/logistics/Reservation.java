package com.cz2002.ss10.objects.logistics;

import java.time.*;

public class Reservation {

	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private int tableNumber;
	private int dinerSize;
	private String customerName;
	private int customerContact;
	private int reservationId;

	/**
	 * 
	 * @param resId
	 * @param resDate
	 * @param resTime
	 * @param contactNumber
	 * @param name
	 * @param dinerSize
	 */
	public Reservation(int resId, LocalDate resDate, LocalTime resTime, int contactNumber, String name, int dinerSize) {
		// TODO - implement Reservation.Reservation
		throw new UnsupportedOperationException();
	}

	public void cancelReservation() {
		// TODO - implement Reservation.cancelReservation
		throw new UnsupportedOperationException();
	}

}