package com.cz2002.ss10.objects.logistics;

import java.time.*;

public class Reservation {

	private int reservationId;	
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private int customerContact;
	private int tableNumber;
	private int dinerSize;
	private String customerName;
	
	
	/**
	 * 
	 * @param resId
	 * @param resDate
	 * @param resTime
	 * @param contactNumber
	 * @param name
	 * @param dinerSize
	 */
	public Reservation(int resId, LocalDate resDate, LocalTime resTime, int contactNumber, String name, int tableNumber, int dinerSize) {
		this.reservationId=resId;
		this.reservationDate=resDate;
		this.reservationTime=resTime;
		this.customerContact=contactNumber;
		this.dinerSize = dinerSize;
		this.tableNumber = tableNumber;
		this.customerName = name;
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

	 public void setReservationTime(LocalTime time){
        this.reservationTime = time;
    }

    public LocalTime getReservationTime(){
        return this.reservationTime;
    }

	public void setCustomerContact(int contactNumber){
        this.customerContact= contactNumber;
    }

	public int getCustomerContact(){
        return this.customerContact;
    }

	public String getCustomerName(){
		return this.customerName;
	}

	public void setCustomerName(String name){
		this.customerName = name;
	}
	public void setTableNumber(int tableNo){
        this.tableNumber= tableNo;
    }

	public int getTableNumber(){
        return this.tableNumber;
    }

	public void setDinerSize(int tableSize){
        this.dinerSize = tableSize;
    }

	public int getDinerSize(){
        return this.dinerSize;
    }

}