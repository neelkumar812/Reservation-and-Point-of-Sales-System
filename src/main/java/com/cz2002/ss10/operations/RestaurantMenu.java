package com.cz2002.ss10.operations;

import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.objects.food.MenuItem.MenuItemType;

import java.util.*;
import java.util.stream.Stream;

/**
 * RestaurantMenu Class
 *
 * @author Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

public class RestaurantMenu {

	/**
     * Scanner Object
     */

	 Scanner sc = new Scanner (System.in);
	 public static Scanner instance;

	
	/**
     * The Food Menu Items Management Menu
     *
     * @return Exit Code. Return 1 to exit the program and -1 to exit to main menu
     */

    protected int generateMenuScreen() {

        System.out.println("Options Available");
        System.out.println("1) Print existing menu");
        System.out.println("2) Create a new menu item");
        System.out.println("3) Edit an existing menu item's details");
        System.out.println("4) Delete a menu item");
        System.out.println("5) Back to main menu");
        System.out.println("0) Exit Application");

        int choice = doMenuChoice(5,0);
        switch (choice) {
            case 1: // Prints menu
                this.printMenu();
                break;
            case 2: // Create new menu item
                this.addMenuItem();
                break;
            case 3: // Edit an existing menu item
                this.editMenuItem();
                break;
            case 4: // Delete an existing menu item
                this.removeMenuItem();
                break;
            case 5:
                return -1;
            case 0:
                return 1;
            default:
			System.out.println("Invalid Option Entered");
        }
        return 0;
    }

	/**
     * Prints the menu of items stored in the CSV file.
     * Uses {@link MainApp#menuItems} to facilitate printing operations.
     **/
    private void printMenu() {};



	public ArrayList<MenuItem> getMenu() {
		// TODO - implement RestaurantMenu.getMenu

		//Returns an Array List
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param price
	 * @param description
	 * @param name
	 * @param itemType
	 */
	public void addMenuItem() {
		// TODO - implement RestaurantMenu.addMenuItem


		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void removeMenuItem() {
		// TODO - implement RestaurantMenu.removeMenuItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void editMenuItem() {
		// TODO - implement RestaurantMenu.removePromotionItem
		throw new UnsupportedOperationException();
	}

	public ArrayList<PromoItem> getPromotionItems() {
		// TODO - implement RestaurantMenu.getPromotionItems
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void removePromotionItem(String name) {
		// TODO - implement RestaurantMenu.removePromotionItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void editPromotionItem(String name) {
		// TODO - implement RestaurantMenu.removePromotionItem
		throw new UnsupportedOperationException();
	}

}
