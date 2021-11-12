package com.cz2002.ss10;

import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;

import java.util.ArrayList;
import java.time.LocalTime;  
import java.util.*;

// should this class be renamed?
public class RestaurantApp {
    
	private ArrayList<Table> tables;

    /**
     * The list of menuitems loaded into the program
     */	
	public ArrayList<MenuItem> menuItems;

	/**
     * The list of promoitems loaded into the program
     */
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
     * Initializes all of the necessary items of the application
     * Items include loading saved menu items etc
     */
    private static void init() {
        MenuItemCSVHelper menuItemCsv = MenuItemCSVHelper.getInstance();
        PromoCSVHelper promotionCsv = PromoCSVHelper.getInstance();

        try {
            System.out.println("Loading Menu Items from file...");
            menuItems = menuItemCsv.readFromCsv();
            System.out.println(menuItems.size() + " menu items loaded from file");

            System.out.println("Loading Promotions from file...");
            promotions = promotionCsv.readFromCsv();
            System.out.println(promotions.size() + " promotions loaded from file.");

 
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("[ERROR] Failed to read CSV from data folder. (" + e.getLocalizedMessage() + ")");
        }

        System.out.println("Initializing Program...");

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
