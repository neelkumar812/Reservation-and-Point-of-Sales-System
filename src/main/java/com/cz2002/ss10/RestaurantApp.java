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
		String isMember;
        int flag = 0;
        



        int discount; //discount rate for members is 10%
        System.out.println("Welcome to the order creation page!");
        do{
            System.out.println("Is the customer a member? ");
            isMember = sc.next().toLowerCase();
            if(isMember == "yes"){
                flag = 0;
            }
            else if(isMember == "no"){
                flag = 0;
            }
            else{
                flag = 1;
                System.out.println("Please enter either 'yes' or 'no' only");
            }
        }while(flag != 1);
        do{
            System.out.println("Please enter table number");
            isMember = sc.next().toLowerCase();
            if(isMember == "yes"){
                flag = 0;
            }
            else if(isMember == "no"){
                flag = 0;
            }
            else{
                flag = 1;
                System.out.println("Please enter either 'yes' or 'no' only");
            }
        }while(flag != 1);
		throw new UnsupportedOperationException();
	}

	//hello

}
