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
	public static void printMenu(MenuItem.MenuItemType printType) {

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
	public static void addMenuItem(int itemType, String name, String description, double price) {

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
	public static void editMenuItem(int itemId, int itemType, String name, String description, double price) {

        for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) {

            MenuItem menuItemObj = RestaurantApp.menuItems.get(i); //when you do this, you actually retrieve the whole object

            if (itemId == menuItemObj.getId()) {

                    menuItemObj.setName(name);
                    menuItemObj.setMenuItemType(itemType);
                    menuItemObj.setDescription(description);
                    menuItemObj.setPrice(price);

		// Important Save the Menu Item CSV Here
                    System.out.println("Menu item successfuly edited!");
                    return;

            }

        }
	}

	/**
	 * 
	 * @param name
	 */
	public static void deleteMenuItem(int itemId) {

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
	 * @param id
	 */

	public static void printPromotionItems() {

		System.out.println("All Promotions");
		System.out.printf("%-5s %-10s %-10s %-10s\n", "ID", "Name", "Price",  "Description");
 
		 for (int i = 0; i < RestaurantApp.promotionItems.size(); i++) {
			 PromoItem pi = RestaurantApp.promotionItems.get(i);
			 MenuItem mainItem = MenuItem.retrieveMenuItem(pi.getPromoMain());
			 MenuItem dessertItem = MenuItem.retrieveMenuItem(pi.getPromoDessert());
			 MenuItem drinkItem = MenuItem.retrieveMenuItem(pi.getPromoDrink());
 
			 String tempDescription = ("Served with the following items: ");
			 String tempMain = ("[" + pi.getPromoMain() + "]");
			 String tempDessert = ("[" + pi.getPromoDessert() + "]");
			 String tempDrink = ("[" + pi.getPromoDrink() + "]");
 
			 System.out.printf("%-5s %-10s %-10s %-10s\n", pi.getId(), pi.getName(), pi.getPrice(), tempDescription);
			 System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n", "", "", "", "Main: ", tempMain, mainItem.getName());
			 System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n", "", "", "", "Dessert: ", tempDessert, dessertItem.getName());
			 System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n\n", "", "", "", "Drink: ", tempDrink, drinkItem.getName());
		 }
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void createPromotionItem(int id) {
		// TODO - implement RestaurantMenu.removePromotionItem
		throw new UnsupportedOperationException();
	}



	/**
	 * 
	 * @param id
	 */
	public void editPromotionItem(int id) {
		// TODO - implement RestaurantMenu.removePromotionItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void deletePromotionItem(int id) {
		// TODO - implement RestaurantMenu.removePromotionItem
		throw new UnsupportedOperationException();
	}

}
