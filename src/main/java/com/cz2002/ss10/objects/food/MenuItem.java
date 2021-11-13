package com.cz2002.ss10.objects.food;

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
    public MenuItem(int id, String name, int itemType, String description, double price, int stock) {
        super(id, name, price, stock); // Called from restaurant class
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
		throw new UnsupportedOperationException();
	}


	public MenuItemType getMenuItemType() {
		return itemType;
	}

	/**
	 * 
	 * @param menuItemType
	 */
	public void setMenuItemType(MenuItemType itemType) {
		this.itemType = itemType;
		throw new UnsupportedOperationException();
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

}
