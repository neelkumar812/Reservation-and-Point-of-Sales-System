package com.cz2002.ss10.objects.logistics;

import java.time.*;

public class Reservation {
	public enum ReservationSession {AM,PM}

	private int reservationId;	//unique no.
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private ReservationSession sess;
	private int customerContact;	//assume customer contact number is unqiue
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
	public Reservation(LocalDate resDate, LocalTime resTime,char session, int contactNumber, String name, int dinerSize) {
		reservationId=contactNumber+10;
		reservationDate=resDate;
		reservationTime=resTime;
		this.sess = session;
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

	public void setCustomerName(String custName){
        this.customerName= custName;
    }

	public String getCustomerName(){
        return this.customerName;
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