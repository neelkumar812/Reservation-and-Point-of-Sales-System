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
	 * @param printType
	 */
	public static void printMenu(MenuItem.MenuItemType printType) {
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

		MenuItemCSVHelper menuHelper = MenuItemCSVHelper.getInstance();

        String tempPromoName;

        for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) {

            MenuItem menuItemObj = RestaurantApp.menuItems.get(i);

            if (itemId == menuItemObj.getId()) { //if we can find the target item

                    //PromoCSVHelper promoHelper = PromoCSVHelper.getInstance(); //bring in promo helper class to do I/O

                    //problem here is the promotionItems size becomes smaller, and it prematurely exits the loop.

                    for (int j = 0; j < (RestaurantApp.promotionItems.size()); j++) { //

                        PromoItem promoItemObj = RestaurantApp.promotionItems.get(j);

                        //if found
                        if (itemId == promoItemObj.getPromoMain() || itemId == promoItemObj.getPromoDessert() || itemId == promoItemObj.getPromoDrink()) {

                            tempPromoName = RestaurantApp.promotionItems.get(j).getName();
                            RestaurantApp.promotionItems.remove(j);

                            System.out.println("Associated Promotion '" + tempPromoName + "' Deleted.");
                        }
                        //else business as usual

                    }
                    //promoHelper.writeToCsv(RestaurantApp.promotionItems);
				}

	 // Implement:	MenuItemCSVHelper menuHelper = MenuItemCSVHelper.getInstance();

        for (int m = 0; i < (RestaurantApp.menuItems.size()); m++) {

            MenuItem menuItemObj1 = RestaurantApp.menuItems.get(m);

            if (itemId == menuItemObj1.getId()) { //if we can find the target item

                    RestaurantApp.menuItems.remove(m); //delete using i as for loop index
                    //menuHelper.writeToCsv(RestaurantApp.menuItems); // calls IO method to save the new array into the CSV file
                    System.out.println("Delete Successful. Target menu item deleted!");
                    return;
			}
		}
		}

	}


	/**
	 * 
	 * @param id
	 */

	public static void printpromotionItems() {

		System.out.println("All promotionItems");
		System.out.printf("%-5s %-10s %-10s %-10s\n", "ID", "Name", "Price",  "Description");
 
		 for (int i = 0; i < RestaurantApp.promotionItems.size(); i++) {
			PromoItem pi = RestaurantApp.promotionItems.get(i);
			 MenuItem appetiserItem = MenuItem.retrieveMenuItem(pi.getPromoAppetiser());
			 MenuItem mainItem = MenuItem.retrieveMenuItem(pi.getPromoMain());
			 MenuItem dessertItem = MenuItem.retrieveMenuItem(pi.getPromoDessert());
			 MenuItem drinkItem = MenuItem.retrieveMenuItem(pi.getPromoDrink());
 
			 String tempDescription = ("Served with the following items: ");
			 String tempAppetiser = ("[" + pi.getPromoAppetiser() + "]");
			 String tempMain = ("[" + pi.getPromoMain() + "]");
			 String tempDessert = ("[" + pi.getPromoDessert() + "]");
			 String tempDrink = ("[" + pi.getPromoDrink() + "]");
 
			 System.out.printf("%-5s %-10s %-10s %-10s\n", pi.getId(), pi.getName(), pi.getPrice(), tempDescription);
			 System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n", "", "", "", "Appetiser: ", tempAppetiser, appetiserItem.getName());
			 System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n", "", "", "", "Main: ", tempMain, mainItem.getName());
			 System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n", "", "", "", "Dessert: ", tempDessert, dessertItem.getName());
			 System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n\n", "", "", "", "Drink: ", tempDrink, drinkItem.getName());
		 }

	}

	/**
	 * 
	 * @param PromoName 
	 * @param PromoPrice 
	 * @param PromoAppetiser
	 * @param PromoMain
	 * @param PromoDessert
	 * @param PromoDrinks
	 */
	public static void createPromoItem(String PromoName, Double PromoPrice, int PromoAppetiser, int PromoMain, int PromoDessert, int PromoDrink) {

		PromoItem promotionObj = RestaurantApp.promotionItems.get((RestaurantApp.promotionItems.size())-1);
		int PromoID = promotionObj.getId()+1;

		PromoItem promotion = new PromoItem(PromoID, PromoName, PromoPrice, PromoAppetiser, PromoMain, PromoDessert, PromoDrink);
		RestaurantApp.promotionItems.add(promotion);

		// PromoCSVHelper promotionHelper = PromoCSVHelper.getInstance();
		// promotionHelper.writeToCsv(RestaurantApp.promotionItems);

	}



	/**
	 * 
	 * @param
	 */
	public static void editPromoItem(String PromoName, Double PromoPrice, int PromoAppetiser, int PromoMain, int PromoDessert, int PromoDrink) {

		for (int i=0; i<(RestaurantApp.promotionItems.size()); i++) {

			int editPromoID = 0;

            PromoItem promoObj = RestaurantApp.promotionItems.get(i);
            if (editPromoID == promoObj.getId()) {

                    PromoItem promo = PromoItem.retrievePromotion(editPromoID);

                    promo.setName(PromoName);
                    promo.setPrice(PromoPrice);
                    promo.setPromoMain(PromoMain);
                    promo.setPromoDessert(PromoDessert);
                    promo.setPromoDrink(PromoDrink);
                    //at this point, the object has been edited with the new values

                    //promoHelper.writeToCsv(RestaurantApp.promotionItems); // calls IO method to save the array into the CSV file
                    System.out.println("Edit successful. Target promotion successfully edited!");
                    return;
				}

			}

	}

	/**
	 * 
	 * @param id
	 */
	public static void deletePromoItem(int id) {

		for (int i=0; i<(RestaurantApp.promotionItems.size()); i++) {
            PromoItem promoObj = RestaurantApp.promotionItems.get(i);
            if (id == promoObj.getId()) {
                    RestaurantApp.promotionItems.remove(i); //delete using i as for loop index
                    //promoHelper.writeToCsv(RestaurantApp.promotionItems); // calls IO method to save the new array into the CSV file
                    System.out.println("Target promotion has been successfully removed!");
                    return;
			}
		}

	}
}
