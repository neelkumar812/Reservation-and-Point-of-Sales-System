package com.cz2002.ss10;

import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;

import java.util.ArrayList;
import java.time.LocalTime;  
import java.util.*;

// should this class be renamed?
public class RestaurantApp {
    
	
	private ArrayList<MenuItem> menuItems;
	private ArrayList<PromoItem> promotionItems;
	private ArrayList<Reservation> reservations;
	private ArrayList<Staff> staffs;
	private ArrayList<RevenueReport> revenueReports;
	private LocalTime openingTime;
	private LocalTime closingTime;
	private ArrayList<Order> orders;
	Scanner sc = new Scanner(System.in);

	public void setPromotionItems(ArrayList<PromoItem> promotionItems) {
		this.promotionItems = promotionItems;
	}

	/**
	 * 
	 * @param operation
	 */
	public void handleMenu(int operation) {
		// TODO - implement RestaurantApp.handleMenu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param operation
	 */
	public void handleManagement(int operation) {
		// TODO - implement RestaurantApp.handleManagement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param operation
	 */
	public void handleService(int operation) {
		
		throw new UnsupportedOperationException();
	}

	//hello

}
