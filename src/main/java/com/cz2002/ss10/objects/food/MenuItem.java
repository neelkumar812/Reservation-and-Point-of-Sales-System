package com.cz2002.ss10.objects.food;
import java.util.*;

import com.cz2002.ss10.RestaurantApp;

/**
 * MenuItem Class
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
     * Method to Construct Menu Item Object
     * @param id          
     * @param name       
     * @param itemType        
     * @param description 
     * @param price       
     */
    public MenuItem(int id, String name, int itemType, String description, double price) {
        super(id, name, price); 
		this.itemType = intToItemType(itemType);     
        this.description = description;
    }


	/** 
     * Accessor for the description
	 * @return description of the item 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Mutator for the description
	 * @param description description of item
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Accessor for the itemType
	 * @return itemType type of the item 
	 */
	public MenuItemType getMenuItemType() {
		return itemType;
	}

	/**
     * Mutator for Menu Item Type
	 * @param menuItemType An integer that corresponds to a particular item type.
	 */
	public void setMenuItemType(int itemType) {
		this.itemType = intToItemType(itemType);

	}


	/**
     * Returns the item type corresponding to the integer number entered.
     * @param type The menu item's type, in integer form.
     * @return The menu item's type in its enum equivalent form.
     */
    public MenuItemType intToItemType(int type) {
        return type == 1 ? MenuItemType.APPETISERS :
                	type == 2 ? MenuItemType.MAIN :
                        type == 3 ? MenuItemType.DRINK :
							type == 4 ? MenuItemType.DESSERT :
                               type == 5? MenuItemType.OTHERS:
							   		MenuItemType.ALL;
    }


    /**
     * Find and return menu item of a specific item ID.
     * @param itemId Id of the menu item desired.
     * @return menu item object with the specific ID.
     */

    public static MenuItem retrieveMenuItem(int itemId) {

        for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) {
            MenuItem itemObj = RestaurantApp.menuItems.get(i);
            if (itemId == itemObj.getId()) return itemObj;
        } return null; 
    }

	/**
     * Returns an arraylist of items in the Menu, sorted by item type. 
     * @param desiredType item type to be filtered by.
     * @return menuItemFunnel Arraylist of menuItem sorted by Objects.
     */

    public static ArrayList<MenuItem> funneledMenuItemList(MenuItem.MenuItemType desiredType) {
        ArrayList<MenuItem> menuItemFunnel = new ArrayList<>();
        if (desiredType == MenuItem.MenuItemType.ALL) {
            return RestaurantApp.menuItems; 
        }
        for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) {
            MenuItem itemObj = RestaurantApp.menuItems.get(i);
            if (desiredType == itemObj.getMenuItemType()) { 
                menuItemFunnel.add(itemObj);
            }
        }
        return menuItemFunnel;
    }

    /**
     * Checks type of the items in the array
     * @param menuArrayList   Make an arraylist with only items of desired type
     * @param desiredItemType Type of the menu item added to the promotion
     * @return True/False Boolean that indicates whether the item is of desired type or not
     */
    public static boolean typeCheck(ArrayList<MenuItem> menuArrayList, int desiredItemType) {
        for (MenuItem itemObj : menuArrayList) { 
            if (desiredItemType == itemObj.getId()) { 
                return true;
            }
        } 
        System.out.println("Item not found");
        return false;
    }

}
