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
	public void printMenu(MenuItem.MenuItemType printType) {

		//Need to debug the retrive Menu item List function

		ArrayList<MenuItem> filteredMenu = MenuItem.retrieveMenuItemListFiltered(printType);
        System.out.printf("%-5s %-50s %-10s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredMenu) {
            System.out.printf("%-5s %-50s %-10s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }	
	}

	/**
	 * 
	 * @param price
	 * @param description
	 * @param name
	 * @param itemType
	 */
	public void addMenuItem(int itemType, String name, String description, double price) {

            //basically gets the last object in the menuItem array
            MenuItem menuItemObj = RestaurantApp.menuItems.get((RestaurantApp.menuItems.size()) - 1);

            //gets the ID value from the last object and +1 to create a new PK
            int id = menuItemObj.getId() + 1;

            MenuItem menuItem = new MenuItem(id, name, itemType, description, price);
            RestaurantApp.menuItems.add(menuItem); //adds the RestaurantItem object to the menu array


			// IMPORTANT: Implement the save to CSV Function

        System.out.println("Add successful. New menu item has been successfully added.");

	}

	/**
	 * 
	 * @param name
	 */
	public void deleteMenuItem(int itemId) {

		//Note to self, if the current item is a part of the promotion, need to handle the deletion over there as well


	// Implement:	MenuItemCSVHelper menuHelper = MenuItemCSVHelper.getInstance();

        for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) {

            MenuItem menuItemObj = RestaurantApp.menuItems.get(i);

            if (itemId == menuItemObj.getId()) { //if we can find the target item

                    RestaurantApp.menuItems.remove(i); //delete using i as for loop index
                    //menuHelper.writeToCsv(RestaurantApp.menuItems); // calls IO method to save the new array into the CSV file
                    System.out.println("Delete Successful. Target menu item deleted!");
                    return;
			}
		}

	}

	/**
	 * 
	 * @param name
	 */
	public void editMenuItem(int itemId, int itemType, String name, String description, double price) {

        for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) {

            MenuItem menuItemObj = RestaurantApp.menuItems.get(i); //when you do this, you actually retrieve the whole object

            if (itemId == menuItemObj.getId()) {

                    menuItemObj.setName(name);
                    menuItemObj.setMenuItemType(itemType);
                    menuItemObj.setDescription(description);
                    menuItemObj.setPrice(price);
                    //at this point, the object has been edited with the new values

		// Important Save the Menu Item CSV Here
                    System.out.println("Menu item successfuly edited!");
                    return;

            }

        }
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
