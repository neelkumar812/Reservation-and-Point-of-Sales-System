package com.cz2002.ss10.objects.food;

public class MenuItem extends RestaurantItem {

	public enum MenuItemType {
		MAIN, DRINK, DESSERT, APPETISERS, OTHERS
	}

	private MenuItemType itemType;

	MenuItem(){
		super();
	}

	MenuItem(double price, String description, String name, int noOfAvailability, MenuItemType itemType){
        super(price, description, name, noOfAvailability);
		this.itemType = itemType;
    }


	public void getMenuItemType() {
		// TODO - implement MenuItem.getMenuItemType
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param menuItemType
	 */
	public void setMenuItemType(int menuItemType) {
		// TODO - implement MenuItem.setMenuItemType
		throw new UnsupportedOperationException();
	}

}