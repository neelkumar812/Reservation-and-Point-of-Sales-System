package com.cz2002.ss10;

import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.operations.RestaurantService;
import com.cz2002.ss10.operations.RestaurantManagement;
import com.cz2002.ss10.ui.OrderUI;
import com.cz2002.ss10.ui.FoodMenuUI;
import com.cz2002.ss10.ui.PromotionMenuUI;
import com.cz2002.ss10.ui.ReservationUI;
import com.cz2002.ss10.ui.RevenueReportUI;
import com.cz2002.ss10.ui.StaffUI;
import com.cz2002.ss10.utils.RevenueReportCsv.ReportDuration;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
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
	 public static ArrayList<MenuItem> menuItems;

	/**
	 * The list of promoitems loaded into the program
	 */
	 public static ArrayList<PromoItem> promotionItems;
	 public static ArrayList<Reservation> reservations;
	 public static ArrayList<Staff> staffs;
	 public static LocalTime openingTime;
	public static LocalTime closingTime;
	public static ArrayList<Order> orders;
	
	public static Scanner sc = new Scanner(System.in);;

	public static void setPromotionItems(ArrayList<PromoItem> promotionItems) {
		RestaurantApp.promotionItems = promotionItems;
	}

	// Method for initializing all the tables in the restaurant
	// Return the Arraylist of tables that are sorted in ASSCENDING ORDER OF
	// CAPACITY
	// 25 total tables, 5 per capacity type
	// for example the first 5 are two seaters, next 5 are 4 seaters and so on and
	// so forth
	public static ArrayList<Table> initializeTables() {
		tables = new ArrayList<Table>();
		for (int i = 0; i < TABLESEATCAP; i++) {
			if (i < 5)
				tables.add(new Table(2, i + 1, false));
			else if (i < 10 && i > 4)
				tables.add(new Table(4, i + 1, false));
			else if (i < 15 && i > 9)
				tables.add(new Table(6, i + 1, false));
			else if (i < 20 && i > 14)
				tables.add(new Table(8, i + 1, false));
			else if (i > 19)
				tables.add(new Table(10, i + 1, false));
		}
		return tables;
	}

	public static void initializeAllObjects(){
		RestaurantApp.menuItems = new ArrayList<MenuItem>();
		RestaurantApp.promotionItems= new ArrayList<PromoItem>();
		RestaurantApp.reservations = new ArrayList<Reservation>();
		RestaurantApp.staffs = new ArrayList<Staff>();
		RestaurantApp.openingTime = LocalTime.parse("08:00:00");
		RestaurantApp.closingTime = LocalTime.parse("22:30:00");
		RestaurantApp.orders = new ArrayList<Order>();
		RestaurantApp.menuItems.add(new MenuItem(1, "Pasta", 1, "Bolognese Sauce", 12.00));
		RestaurantApp.menuItems.add(new MenuItem(2, "Fish and Chips", 1, "Cod and Fries with Tartar Sauce", 18.00));
		RestaurantApp.menuItems.add(new MenuItem(3, "Baked Rice with Cheese",1, "Baked Rice with Cheese", 5.00));
		RestaurantApp.menuItems.add(new MenuItem(4, "Lemonade",2, "Lemonade", 3.00));
		RestaurantApp.menuItems.add(new MenuItem(5, "Brownies",3, "Brownies", 3.00));
		RestaurantApp.menuItems.add(new MenuItem(6, "Tacos",4, "Tacos and Salsa", 13.00));
		RestaurantApp.promotionItems= new ArrayList<PromoItem>();
		RestaurantApp.promotionItems.add(new PromoItem(1, "Italian Lunch Set", 35.00, 1, 6, 5, 4));
		RestaurantApp.reservations = new ArrayList<Reservation>();
		RestaurantApp.reservations.add(new Reservation(1, LocalDate.parse("2021-12-26"), LocalTime.parse("08:45:00"), 91243245, "Jan", 1, 2));
		RestaurantApp.reservations.add(new Reservation(2, LocalDate.parse("2021-12-30"), LocalTime.parse("08:45:00"), 91243115, "Mary", 2, 2));
		RestaurantApp.reservations.add(new Reservation(3, LocalDate.parse("2021-12-26"), LocalTime.parse("08:45:00"), 82312324, "Joseph", 3, 2));
		RestaurantApp.staffs = new ArrayList<Staff>();
		RestaurantApp.staffs.add(new Staff("Randy", 'f', 1, "Waiter"));
		RestaurantApp.staffs.add(new Staff("Alison", 'f', 2, "Waiter"));
		RestaurantApp.staffs.add(new Staff("Joe", 'm', 3, "Waiter"));
		RestaurantApp.staffs.add(new Staff("Raul", 'f', 4, "Cook"));
		RestaurantApp.staffs.add(new Staff("Lisa", 'f', 5, "Manager"));
		RestaurantApp.openingTime = LocalTime.parse("08:00:00");
		RestaurantApp.closingTime = LocalTime.parse("22:30:00");
		RestaurantApp.orders = new ArrayList<Order>();
		ArrayList<RestaurantItem> tempOrder = new ArrayList<RestaurantItem>();
		tempOrder.add(RestaurantApp.menuItems.get(0));
		tempOrder.add(RestaurantApp.menuItems.get(1));
		RestaurantApp.orders.add(new Order(RestaurantApp.staffs.get(0), false, 1, 1, tempOrder));
		RestaurantApp.orders.add(new Order(RestaurantApp.staffs.get(1), true, 2, 2, tempOrder));
		RestaurantApp.orders.add(new Order(RestaurantApp.staffs.get(2), true, 3, 3, tempOrder));
		//RestaurantApp.tables.get(0).setOccupancy(true);
	}

	// Main Menu UI NOT COMPLETE
	public static void main(String[] Args) {
		if (tables == null) {
			System.out.println("Initializing all tables as empty to begin with");
			tables = initializeTables();
			System.out.println(TABLESEATCAP + " tables loaded");
			initializeAllObjects();
		}
		int choice;

		do {
			System.out.println("=====================================================");
			System.out.println("Welcome to the main menu. What would you like to do? ");
			System.out.println("                  1. Handle Menu                     ");
			System.out.println("                  2. Handle Management               ");
			System.out.println("                  3. Handle Service                  ");
			System.out.println("                  0. Exit Application                 ");
			System.out.println("=====================================================");

			choice = RestaurantApp.sc.nextInt();

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
			    RestaurantApp.sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
			}

		} while (choice != 0);
		 
	}

	/**
	 * 
	 * @param operation
	 */
	public static void handleMenu(int operation) {
		int choice;
		do {
			System.out.println("==============================================================");
			System.out.println("  Welcome to the Menu Handler. Please select an option below: ");
			System.out.println("                  1. Print menu                               ");
			System.out.println("                  2. Create menu item                         ");
			System.out.println("                  3. Edit existing menu item                  ");
			System.out.println("                  4. Delete menu item                         ");
			System.out.println("                  5. Handle Promotions                        ");
			System.out.println("                  6. Exit to main menu                        ");
			System.out.println("                  0. Exit App                                 ");
			System.out.println("==============================================================");

			choice = RestaurantApp.sc.nextInt();

			switch (choice) {
			case 1:
				FoodMenuUI.printMenuUI();
				break;
			case 2:
				FoodMenuUI.addNewMenuItemUI();
				break;
			case 3:
				FoodMenuUI.editMenuItemUI();
				break;
			case 4:
				FoodMenuUI.deleteMenuItemUI();
				break;
			case 5:
				PromotionMenuUI.promotionMenuHandler();
			case 6:
				RestaurantApp.main(null);
			case 0:
				System.exit(0);
			default:
				System.out.println("Invalid Choice.");
				break;

			}
			 
		} while (choice != 0);
	}

	// Comment

	/**
	 * 
	 * @param operation
	 */
	public static void handleManagement(int operation) {
		int selection;
		do {
			System.out.println("==================================================================");
			System.out.println("Welcome to the Management Handler. Please select an option below:");
			System.out.println("                  1. Add New Staff                               ");
			System.out.println("                  2. Remove Staff                			     ");
			System.out.println("                  3. Generate Revenue Report           		     ");
			System.out.println("                  4. Back to main menu                		     ");
			System.out.println("=================================================================");

			selection = RestaurantApp.sc.nextInt();

			switch (selection) {
			case 1: // Add new staff
				int choice = StaffUI.getStaffInsertionChoice();
				// Add new staff by CSV
				if (choice == 1) {
					String filePath = StaffUI.getFilePath();
					RestaurantManagement.addStaff(filePath);
					System.out.println("Staff added successfully!");
				} else {
					// Add new staff manually
					ArrayList<String> staffDetails = StaffUI.getDetails();
					RestaurantManagement.addStaff(staffDetails.get(0), staffDetails.get(1).charAt(0),
							(int) Integer.valueOf(staffDetails.get(2)), staffDetails.get(3));
					System.out.println("Staffs added successfully!");
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
				RestaurantApp.main(null);
				break;
			default:
				System.out.println("Please enter a valid choice ");
				break;
			}
		} while (selection != -1);
		 

	}

	/**
	 * 
	 * @param operation
	 */
	public static void handleService(int operation) {
		int selection;

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

			selection = RestaurantApp.sc.nextInt();

			switch (selection) {
			case 1: // Gets the available tables
				System.out.println("Here are the available tables:");
				Iterator<Table> availTable = getAvailableTables().iterator();
				while (availTable.hasNext()) {
					Table temporary = availTable.next();
					System.out.println("Table ID: " + temporary.getTableNumber() + " Seating Capacity: "
							+ temporary.getSeatingCap());
				}

				break;
			case 2: // Settle Payments
				int askTableNo;
				int askOrderId;
				if (RestaurantApp.orders == null || RestaurantApp.orders.isEmpty()){
					System.out.println("No orders to settle!");
				}
				else {
					System.out.println("Enter the orderId for settling payment");
				askOrderId = RestaurantApp.sc.nextInt();
				System.out.println("Enter the table number for settling payment");
				askTableNo = RestaurantApp.sc.nextInt();
				RestaurantService.settlePayment(askTableNo, askOrderId);
				}
				break;

			case 3: // create new order
				OrderUI.createNewOrder();
				RestaurantApp.sc.nextLine();
				break;
			case 4: // Check orders
			    if (RestaurantApp.orders == null || RestaurantApp.orders.isEmpty()){
					System.out.println("No orders!");
				}
				else {
				System.out.println("Here are all the current orders: ");
				for (int i = 0; i < RestaurantApp.orders.size(); i++) {
					System.out.println("The order ID: " + RestaurantApp.orders.get(i).getOrderId());
					System.out.println("The order subtotal: " + RestaurantApp.orders.get(i).calculateSubtotal());
					System.out.println("The Table number for this order : " + RestaurantApp.orders.get(i).getTableNumber());
					System.out.println("Created at : " + RestaurantApp.orders.get(i).getCreatedAt());
					System.out.println("Is paid : " + RestaurantApp.orders.get(i).getIsPaid());
					System.out.println("\n");
				}
				}
				break;
			case 5: // Create new reservation
				ReservationUI.createNewReservation();
				RestaurantApp.sc.nextLine();
				break;
			case 6: // Cancel Reservation

				System.out.println("Please enter Customer Name: ");
				String tempCustName = RestaurantApp.sc.next();
				System.out.println("Please enter Reservation ID for cancellation: ");
				int tempResvID = RestaurantApp.sc.nextInt();
				RestaurantService.cancelReservation(tempCustName, tempResvID);
				break;
			case 7: // Check Reservation

				System.out.println("Please enter Reservation ID for checking: ");
				int checkResvID = RestaurantApp.sc.nextInt();
				RestaurantService.checkReservation(checkResvID);
				break;
			case 8: // Return to main menu
			    RestaurantApp.main(null);
				break;
			default:
				System.out.println("Please enter a valid choice ");
				break;
			}

		} while (selection != 8);

		 
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
