package com.cz2002.ss10.objects.logistics;

import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import java.time.LocalDateTime;
import java.util.*;


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
		this.subtotal=0.00;

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
		Iterator<RestaurantItem> iterator = this.orderItems.iterator();
		while (iterator.hasNext()){	
				this.subtotal += iterator.next().getPrice();
		}
		return this.subtotal;
	}
	
	/**
	 * 
	 * @param item
	 */
	public void addItem(MenuItem item) {
		orderItems.add(item);
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(String itemName) {
		int index = 0,counter = 0; // avoid deleting duplicate order items
		Iterator<RestaurantItem> iterator = this.orderItems.iterator();
		while (iterator.hasNext() && counter == 0){
			if(iterator.next().getName() == itemName){
				this.orderItems.remove(index);
			}
			index++;
		}
	}

	public void updatePaymentStatus(Boolean isPaid) {
		this.isPaid = isPaid;
	}

}