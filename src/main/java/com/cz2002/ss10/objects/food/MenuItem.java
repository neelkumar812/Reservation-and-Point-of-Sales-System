package com.cz2002.ss10.objects.food;
import java.util.*;

import com.cz2002.ss10.RestaurantApp;

/**
 * MenuItem Class
 *
 * @author Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

public class MenuItem extends RestaurantItem {

	public enum MenuItemType {
		MAIN, DRINK, DESSERT, APPETISERS, OTHERS, ALL
	}

	private String description;
	private MenuItemType itemType;

	/**
     * Constructor to pass in all required parameters for menu item.
     *
     * @param id          Menu item's ID.
     * @param name        Menu item's name.
     * @param type        Menu item's type.
     * @param description Menu item's description.
     * @param price       Menu item's price.
	 * @param stock       Menu item's stock.
     */
    public MenuItem(int id, String name, int itemType, String description, double price) {
        super(id, name, price); // Called from restaurant class
		this.itemType = convertToItemType(itemType);     
        this.description = description;
    }


	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	public MenuItemType getMenuItemType() {
		return itemType;
	}

	/**
	 * 
	 * @param menuItemType
	 */
	public void setMenuItemType(int itemType) {
		this.itemType = convertToItemType(itemType);

	}


	/**
     * Method that takes in integer of menu type to convert into its corresponding enum type equivalent.
     *
     * @param type The menu item's type, in integer form.
     * @return The menu item's type in its enum equivalent form.
     */
    public MenuItemType convertToItemType(int type) {
        return type == 1 ? MenuItemType.MAIN :
                	type == 2 ? MenuItemType.DESSERT :
                        type == 3 ? MenuItemType.DRINK :
							type == 4 ? MenuItemType.APPETISERS :
                               type == 5? MenuItemType.OTHERS:
							   		MenuItemType.ALL;
    }

	/**
     * Prints a menu item's details.
     * Formatted to fit a console table of size 60.
     *
     * @return Parsed string of the Menu Item.
     */
    public String printItemDetail() {
        return "Name: " + this.getName() + "\n" + 
                "Description: " + this.getDescription() + "\n" + 
                "Price: $" + String.format("%.2f", this.getPrice());
    }

    /**
     * Method returning a MenuItem object that matches the input targetItemID.
     * Uses {@link RestaurantApp#menuItems} to retrieval operations.
     *
     * @param targetItemID ID of the menu item object to be retrieved.
     * @return menuItemObj Object containing menu item attributes.
     */

    public static MenuItem retrieveMenuItem(int targetItemID) {

        for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) {

            MenuItem menuItemObj = RestaurantApp.menuItems.get(i);

            if (targetItemID == menuItemObj.getId()) { //"Target menu item found."
                return menuItemObj;
            }

        }
        return null; //"Target menu item not found."
    }



	/**
     * Method returning an ArrayList filtered by enum type.
     * Uses {@link RestaurantApp#menuItems} to retrieval operations.
     *
     * @param targetItemType type of the menu item objects to be retrieved.
     * @return menuItemsFiltered ArrayList containing the menu item type selected
     */

    public static ArrayList<MenuItem> retrieveMenuItemListFiltered(MenuItem.MenuItemType targetItemType) {

        ArrayList<MenuItem> menuItemsFiltered = new ArrayList<>(); //declare new empty arraylist

        //send in master first if ALL
        if (targetItemType == MenuItem.MenuItemType.ALL) {
            return RestaurantApp.menuItems; //returns original array if ALL is selected.
        }

        for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) { //for loop to run through menuitems and to filter out

            MenuItem menuItemObj = RestaurantApp.menuItems.get(i); //gets a menu item object while the loop is running

            //need to change to enum
            if (targetItemType == menuItemObj.getMenuItemType()) { //"Menu item of target item types found."
                menuItemsFiltered.add(menuItemObj); //add the found object into the filtered array list
            }

        }
        return menuItemsFiltered;
    }

}
