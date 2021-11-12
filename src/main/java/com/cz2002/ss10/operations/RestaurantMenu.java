package com.cz2002.ss10.operations;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.food.*;
import java.util.*;


/**
 * RestaurantMenu Class
 *
 * @author Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

public class RestaurantMenu {

	/**
	 * 
	 * @param price
	 * @param description
	 * @param name
	 * @param itemType
	 */
	public void printMenu(int printType) {

		ArrayList<MenuItem> menuItemsFiltered = new ArrayList<>(); //declare new empty arraylist


		
	}

	    /**
     * Method returning an ArrayList filtered by enum type.
     * Uses {@link MainApp#menuItems} to retrieval operations.
     *
     * @param targetItemType type of the menu item objects to be retrieved.
     * @return menuItemsFiltered ArrayList containing the menu item type selected
     */
	
    public static ArrayList<MenuItem> retrieveMenuItemListFiltered(MenuItem.MenuItemType targetItemType) {

        ArrayList<MenuItem> menuItemsFiltered = new ArrayList<>(); //declare new empty arraylist

        //send in master first if ALL
        if (targetItemType == MenuItem.MenuItemType.ALL) {
            return MainApp.menuItems; //returns original array if ALL is selected.
        }

        for (int i = 0; i < (MainApp.menuItems.size()); i++) { //for loop to run through menuitems and to filter out

            MenuItem menuItemObj = MainApp.menuItems.get(i); //gets a menu item object while the loop is running

            //need to change to enum
            if (targetItemType == menuItemObj.getType()) { //"Menu item of target item types found."
                menuItemsFiltered.add(menuItemObj); //add the found object into the filtered array list
            }

        }
        return menuItemsFiltered;
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
	public void deleteMenuItem(int itemId) {
		// TODO - implement RestaurantMenu.removeMenuItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void editMenuItem(int itemId, int itemType, String name, String description, double price) {
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
