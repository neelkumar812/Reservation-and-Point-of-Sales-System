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
	public void addMenuItem(int itemType, String name, String description, double price) {
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
