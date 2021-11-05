package com.cz2002.ss10;

import java.util.ArrayList;
import java.time.LocalTime;  
import java.util.*;

// should this class be renamed?
public class RestaurantApp {
    
	private ArrayList<Table> tables;
	private ArrayList<MenuItem> menuItems;
	private ArrayList<PromoItem> promotionItems;
	private ArrayList<Reservation> reservations;
	private ArrayList<Staff> staffList;
	private ArrayList<RevenueReport> revenueReportList;
	private LocalTime openingTime;
	private LocalTime closingTime;
	private ArrayList<OrderInvoice> orderInvoices;

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
		// TODO - implement RestaurantApp.handleService
		throw new UnsupportedOperationException();
	}

}
