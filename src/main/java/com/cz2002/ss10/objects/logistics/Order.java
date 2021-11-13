package com.cz2002.ss10.objects.logistics;

import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import java.time.LocalDateTime;
import java.util.*;

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
	 * 
	 * @param orderId
	 * @param
	 */
	public Order(Staff staff, String membershipType, int tableNumber, int orderId,
			ArrayList<RestaurantItem> orderItems) {
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
		// TODO - mark isPaid as Paid
		isPaid = true;
		paidAt = LocalDateTime.now();
		this.getTable().freeState(tableNumber); // should be handled one level higher in settlePayment
		System.out.println("Order paid and table is now available");
	}

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

	public double calculateSubtotal() {
		// TODO - implement Order.calculateTotal
		double subtotal = 0;
		this.orderItems.forEach((n) -> {
			subtotal += n.getPrice();
		});
		this.subtotal = subtotal;
		return subtotal;
	}

	public void printOrderInvoice() {
		// TODO - implement Order.printOrderInvoice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void addItem(MenuItem item) {
		// TODO - implement Order.addItem
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

	public void getOrder() {
		// TODO - implement Order.getOrder
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