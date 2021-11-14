package com.cz2002.ss10.objects.logistics;

import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import java.time.LocalDateTime;
import java.util.*;
import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.operations.RestaurantService;

public class Order {

	
	private Staff staff;
	private String membershipType;
	private int tableNumber;
	private LocalDateTime createdAt;
	private int orderId;
	private ArrayList<RestaurantItem> orderItems;
	private Boolean isPaid;
	private LocalDateTime paidAt;
	private double subtotal;
	

	/**
     * @param staff
     * @param membershipType
     * @param tableNumber
     * @param orderId
     * @param orderItems
     */
	public Order(Staff staff, String membershipType, int tableNumber, int orderId, ArrayList<RestaurantItem> orderItems) {
		this.staff = staff;
		this.membershipType = membershipType;
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
		//How do I make tables(tableNumber).setOccupuncy(false);
		RestaurantApp.tables.get(tableNumber-1).setOccupancy(false);
		System.out.println("Order paid and table is now available");
	}
	public Staff getStaff() {
		return staff;
	}
	public ArrayList<RestaurantItem> getOrderItems() {
		return this.orderItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getMembershipType() {
		return membershipType;
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

	public int orderId() {
		return orderId;
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
		this.orderItems.forEach((n) -> {
			subtotal += n.getPrice();
		});
		this.subtotal = subtotal;
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
	 * this.membershipType + ""; data[4] = this.tableNumber + ""; data[5] =
	 * this.createdAt + ""; data[6] = this.orderItems + ""; data[7] = this.isPaid+
	 * ""; return data; }
	 */

}