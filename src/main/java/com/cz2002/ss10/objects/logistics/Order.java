package com.cz2002.ss10.objects.logistics;

import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import java.time.LocalDateTime;
import java.util.*;
import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.operations.RestaurantService;

public class Order {

	
	private Staff staff;
	private Boolean isMember;
	private int tableNumber;
	private LocalDateTime createdAt;
	private int orderId;
	private ArrayList<RestaurantItem> orderItems;
	private Boolean isPaid;
	private LocalDateTime paidAt;
	private double subtotal;
	


    /**
     * Enums for type of order item
     */
    public enum OrderType {TYPE_MENU, TYPE_PROMO}

	/**
     * @param staff
     * @param isMember
     * @param tableNumber
     * @param orderId
     * @param orderItems
     */
	public Order(Staff staff, Boolean isMember, int tableNumber, int orderId, ArrayList<RestaurantItem> orderItems) {
		this.staff = staff;
		this.isMember = isMember;
		this.tableNumber = tableNumber;
		this.createdAt = LocalDateTime.now();
		this.orderId = orderId;
		this.orderItems = orderItems;
		this.isPaid = false; // yet to be paid
		paidAt = null; // yet to be paid

	}

	public void markAsPaid() {
		isPaid = true;
		paidAt = LocalDateTime.now();
		
	}
	public Staff getStaff() {
		return staff;
	}
	public ArrayList<RestaurantItem> getOrderItems() {
		return orderItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public Boolean getMembershipType() {
		return isMember;
	}

	public double getSubtotal() {
		return getSubtotal();
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public Boolean getIsPaid() {
		return isPaid;
	}

	public LocalDateTime getPaidAt(){
		return paidAt;
	}

	public double calculateSubtotal() {
		//
		double subtotal = 0;
		double temp, curTotal, gst, finalTotal, serviceChrg, current = 0;
		this.orderItems.forEach((n) -> {
			subtotal += n.getPrice();
		});
		this.subtotal = finalTotal;
		return subtotal;
	}
	
	/**
	 * 
	 * @param item
	 */
	public void addItem(MenuItem item) {
		throw new UnsupportedOperationException();
		orderItems.add(item);
		System.out.println("Item has been added");
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(MenuItem item) {
		// TODO - implement Order.removeItem
		this.orderItems.forEach((n) -> {
			if (orderItems.get(n) == item)
				orderItems.remove(n);
			break;
		});
	}

	public void updatePaymentStatus(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	//What is this function achieving??
	public void getOrder() {
		throw new UnsupportedOperationException();
		this.orderItems.forEach((n) -> {
			subtotal += n.getPrice();
		});

	}
	/*
	 * public String[] forCsv() { String[] data = new String[8]; data[0] =
	 * this.orderId + ""; StringBuilder buil = new StringBuilder(); for (OrderItem n
	 * : this.orderItems) { buil.append(n.toCompiledString()).append(","); } data[1]
	 * = buil.toString().replaceAll(", $", ""); data[2] = this.staff + ""; data[3] =
	 * this.isMember + ""; data[4] = this.tableNumber + ""; data[5] =
	 * this.createdAt + ""; data[6] = this.orderItems + ""; data[7] = this.isPaid+
	 * ""; return data; }
	 */

}