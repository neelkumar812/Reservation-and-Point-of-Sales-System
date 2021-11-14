package com.cz2002.ss10;

import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.operations.RestaurantService;
import com.cz2002.ss10.operations.RestaurantManagement;
import com.cz2002.ss10.ui.OrderUI;
import com.cz2002.ss10.ui.RevenueReportUI;
import com.cz2002.ss10.ui.StaffUI;
import com.cz2002.ss10.utils.RevenueReportCsv.ReportDuration;

import java.util.ArrayList;
import java.time.LocalTime;
import java.util.*;

/**
 * OrderUI Class
 *
 * @author Neel Kumar, Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

public class RestaurantApp {

	public static final int TABLESEATCAP = 25;
	public static ArrayList<Table> tables;

	/**
	 * The list of menuitems loaded into the program
	 */
	static public ArrayList<MenuItem> menuItems;

	/**
	 * The list of promoitems loaded into the program
	 */
	static public ArrayList<PromoItem> promotionItems;
	static public ArrayList<Reservation> reservations;
	static public ArrayList<Staff> staffs;
	static public LocalTime openingTime;
	static public LocalTime closingTime;
	static public ArrayList<Order> orders;
	Scanner sc = new Scanner(System.in);

	public void setPromotionItems(ArrayList<PromoItem> promotionItems) {
		this.promotionItems = promotionItems;
	}

	// Method for initializing all the tables in the restaurant
	// Return the Arraylist of tables that are sorted in ASSCENDING ORDER OF
	// CAPACITY
	// 25 total tables, 5 per capacity type
	// for example the first 5 are two seaters, next 5 are 4 seaters and so on and
	// so forth
	public static ArrayList<Table> initializeTables() {
		Table[] tableList = new Table[TABLESEATCAP];

		for (int i = 0; i < TABLESEATCAP; i++) {
			if (i < 5)
				tableList[i] = new Table(2, i + 1, false);
			else if (i < 10 && i > 4)
				tableList[i] = new Table(4, i + 1, false);
			else if (i < 15 && i > 9)
				tableList[i] = new Table(6, i + 1, false);
			else if (i < 20 && i > 14)
				tableList[i] = new Table(8, i + 1, false);
			else if (i > 19)
				tableList[i] = new Table(10, i + 1, false);
		}
		for (int i = 0; i < TABLESEATCAP; i++) {
			tables.add(tableList[i]);
		}
		return tables;
	}

	// Main Menu UI NOT COMPLETE
	public static void main(String[] Args) {

		System.out.println("Initializing all tables as empty to begin with");
		initializeTables();
		System.out.println(TABLESEATCAP + " tables loaded");
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("=====================================================");
			System.out.println("Welcome to the main menu. What would you like to do? ");
			System.out.println("                  1. Handle Menu                     ");
			System.out.println("                  2. Handle Management               ");
			System.out.println("                  3. Handle Service                  ");
			System.out.println("                  0. Exit Application                 ");
			System.out.println("=====================================================");

			choice = sc.nextInt();

			switch (choice) {
			case 1: // calls handle menu UI
				RestaurantApp.handleMenu(choice);
				break;
			case 2: // calls handle Management UI
				RestaurantApp.handleManagement(choice);
				break;
			case 3: // calls handle Service UI
				RestaurantApp.handleService(choice);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Chocice");
			}

		} while (choice != 0);
		sc.close();
	}

	/**
	 * 
	 * @param operation
	 */
	public static void handleMenu(int operation) {
		// TODO - implement RestaurantApp.handleMenu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param operation
	 */
	public static void handleManagement(int operation) {
		int selection;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("==================================================================");
			System.out.println("Welcome to the Management Handler. Please select an option below:");
			System.out.println("                  1. Add New Staff                               ");
			System.out.println("                  2. Remove Staff                			     ");
			System.out.println("                  3. Generate Revenue Report           		     ");
			System.out.println("                  4. Back to main menu                		     ");
			System.out.println("=================================================================");

			selection = sc.nextInt();

			switch (selection) {
			case 1: // Add new staff
				int choice = StaffUI.getStaffInsertionChoice();
				// Add new staff by CSV
				if (choice == 1) {
					ArrayList<String> staffDetails = StaffUI.getDetails();
					RestaurantManagement.addStaff(staffDetails.get(0), staffDetails.get(1).charAt(0),
							(int) Integer.valueOf(staffDetails.get(2)), staffDetails.get(3));
					System.out.println("Staffs added successfully!");
				} else {
					// Add new staff manually
					String filePath = StaffUI.getFilePath();
					RestaurantManagement.addStaff(filePath);
					System.out.println("Staff added successfully!");
				}
				break;
			case 2: // Remove staff
				int staffId = StaffUI.getStaffId();
				RestaurantManagement.removeStaff(staffId);
				System.out.println("Staff removed successfully!");
				break;
			case 3: // Generate Revenue Report
				ReportDuration duration = RevenueReportUI.getRevenueDuration();
				int c = RevenueReportUI.getReportChoice();
				// Print Revenue Report
				if (c == 1) {
					RevenueReportUI.getRevenueDuration();
					RestaurantManagement.generateRevenueReport(orders, duration);
				} else {
					// Generate Revenue Report CSV
					String filePath = RevenueReportUI.getFilePath();
					RestaurantManagement.generateRevenueReport(RestaurantApp.orders, duration, filePath);

				}

				break;
			case 4: // Return to main menu
				break;
			default:
				System.out.println("Please enter a valid choice ");
				break;
			}

		} while (selection != 4);

	}

	/**
	 * 
	 * @param operation
	 */
	public static void handleService(int operation) {
		int selection;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("==============================================================");
			System.out.println("Welcome to the Service Handler. Please select an option below:");
			System.out.println("                  1. Get available tables                     ");
			System.out.println("                  2. Settle Payments               			  ");
			System.out.println("                  3. Create New Order                  		  ");
			System.out.println("                  4. Check Orders     		                  ");
			System.out.println("                  5. Create New Reservation                   ");
			System.out.println("                  6. Cancel Reservation                		  ");
			System.out.println("                  7. Check Reservation                		  ");
			System.out.println("                  8. Back to main menu                		  ");
			System.out.println("==============================================================");

			selection = sc.nextInt();

			switch(selection){
				case 1: //Gets the available tables
					getAvailableTables();
					break;
				case 2: //Settle Payments
					int askTableNo;
					int askOrderId;
					System.out.println("Enter the orderId for settling payment");
					askOrderId = sc.nextInt();
					System.out.println("Enter the table number for settling payment");
					askTableNo = sc.nextInt();
					RestaurantService.settlePayment(askTableNo, askOrderId);
					break;
					
				case 3: //create new order 
					OrderUI.createNewOrder();
					break;
				case 4: //Check orders
					System.out.println("Here are all the current orders: ");
					for(int i = 0; i < orders.size(); i++){
						System.out.println("The order ID: " + orders.get(i).getOrderId());
						System.out.println("The order subTotal: " + orders.get(i).getSubtotal());
						System.out.println("The Table number for this order : " + orders.get(i).getTableNumber());
						System.out.println("Created at : " + orders.get(i).getCreatedAt());
						System.out.println("Is paid : " + orders.get(i).getIsPaid());
					}
					break;
				case 5: //Create new reservation
					//TODO-
					break;
				case 6: //Cancel Reservation
					//TODO-
					break;
				case 7: //Check Reservation
					//TODO-
					break;
				case 8: // Return to main menu 
					break;
				default:
					System.out.println("Please enter a valid choice ");
					break;
			}

		} while (selection != 8);

		sc.close();
	}

	public static ArrayList<Table> getAvailableTables() {
		ArrayList<Table> temp = new ArrayList<Table>();
		for (int i = 0; i < TABLESEATCAP; i++) {
			if (tables.get(i).getOccupancy() == false)
				temp.add(tables.get(i));
		}
		return temp;

	}

	// help

}
