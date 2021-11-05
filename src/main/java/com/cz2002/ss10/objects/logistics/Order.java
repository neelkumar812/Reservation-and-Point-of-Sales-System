package com.cz2002.ss10.objects.logistics;

import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import java.time.LocalTime;
import java.util.*;

public class Order {

	private Staff staff;
	private String membershipType;
	private int tableNumber;
	private LocalTime createdAt;
	private int orderId;
	private ArrayList<MenuItem> orderItems;
	private Boolean isPaid;

	/**
	 * 
	 * @param orderId
	 */
	public Order(int orderId) {
		// TODO - implement Order.Order
		throw new UnsupportedOperationException();
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

	public void updatePaymentStatus() {
		// TODO - implement Order.updatePaymentStatus
		throw new UnsupportedOperationException();
	}

	public void getOrder() {
		// TODO - implement Order.getOrder
		throw new UnsupportedOperationException();
	}

}