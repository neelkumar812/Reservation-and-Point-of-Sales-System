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
	private ArrayList<MenuItem> orderItems;
	private Boolean isPaid;

	/**
	 * 
	 * @param orderId
	 * @param 
	 */
	public Order(Staff staff, String membershipType, int tableNumber, int orderId, ArrayList<MenuItem> orderItems, Boolean isPaid) {
		this.staff = staff;
		this.membershipType = membershipType;
		this.tableNumber = tableNumber;
		this.createdAt = LocalDateTime.now();
		this.orderId = orderId;
		this.orderItems = orderItems;
		this.isPaid = isPaid;
	}

	public void printOrderInvoice() {
		// TODO - implement Order.printOrderInvoice
		throw new UnsupportedOperationException();
	}

	private double calculateTotal() {
		// TODO - implement Order.calculateTotal
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void addItem(MenuItem item) {
		// TODO - implement Order.addItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(MenuItem item) {
		// TODO - implement Order.removeItem
		throw new UnsupportedOperationException();
	}

	public void updatePaymentStatus(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public void getOrder() {
		// TODO - implement Order.getOrder
		throw new UnsupportedOperationException();
	}

}