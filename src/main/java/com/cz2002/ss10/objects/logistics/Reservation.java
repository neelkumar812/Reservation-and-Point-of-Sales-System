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
		reservationId=resId;
		reservationDate=resDate;
		reservationTime=resTime;
		customerContact=contactNumber;
		customerName=name;
		this.dinerSize = dinerSize;
	}

    public int getReservationId(){
        return this.reservationId;
    }

    public int getTableNumber(){
        return this.tableNumber;
    }

	public void cancelReservation() {
		this.reservationDate = null;
		this.reservationTime= null;
	    this.tableNumber = -1;
		this.dinerSize= -1;
		this.customerName= null;
		this.customerContact = -1;
		this.reservationId = -1;
}