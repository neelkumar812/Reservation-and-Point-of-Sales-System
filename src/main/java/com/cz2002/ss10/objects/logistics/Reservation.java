package com.cz2002.ss10.objects.logistics;

import java.time.*;

public class Reservation {

	private int reservationId;
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private int customerContact;
	private int tableNumber;
	private String customerName;
	private int dinerSize;
	
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

	public LocalDate getReservationDate(){
        return this.reservationDate;
    }

    public LocalDate getReservationTime(){
        return this.reservationTime;
    }

	public int getCustomerContact(){
        return this.customerContact;
    }

	public int getTableNumber(){
        return this.tableNumber;
    }

	public int getDinerSize(){
        return this.dinerSize;
    }

	public void cancelReservation() {
<<<<<<< HEAD
		// TODO - implement Reservation.cancelReservation
		this.reservationDate = null;
		this.reservationTime= null;
	    this.tableNumber = -1;
		this.dinerSize= -1;
		this.customerContact = -1;
		
		System.out.println("Reservation for "+ this.customerName + "is cancelled (Reservation ID: "+ this.reservationId+")");

		this.reservationId = -1;
		this.customerName= null;
		
	}

}