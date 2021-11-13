package com.cz2002.ss10.objects.logistics;

import java.time.*;

public class Reservation {

	private int reservationId;	//unique no.
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

	public void setReservationId(int resId){
        this.reservationId=resId;
    }

    public int getReservationId(){
        return this.reservationId;
    }

	public void setReservationDate(LocalDate resDate){
        this.reservationDate = resDate;
    }

	public LocalDate getReservationDate(){
        return this.reservationDate;
    }

	 public void setReservationTime(LocalDate time){
        this.reservationTime = time;
    }

    public LocalDate getReservationTime(){
        return this.reservationTime;
    }

	public void setCustomerContact(String name){
        this.customerContact=name;
    }

	public int getCustomerContact(){
        return this.customerContact;
    }

	public void setTableNumber(int tableNo){
        this.tableNumber= tableNo;
    }

	public int getTableNumber(){
        return this.tableNumber;
    }

	public void setDinerSize(int size){
        this.dinerSize = size;
    }

	public int getDinerSize(){
        return this.dinerSize;
    }

	public void cancelReservation() {
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