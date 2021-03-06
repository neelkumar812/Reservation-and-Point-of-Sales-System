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
	 * Prints out the Items in the MenuList Sorted by Desired Type.
	 * 
	 * @param printType Type to be filtered by.
	 */
	public static void printMenu(MenuItem.MenuItemType printType) {
		if (RestaurantApp.menuItems.isEmpty() || RestaurantApp.menuItems == null) {
			System.out.println("No menu items of " + printType.toString() + "!");
		} else {
			ArrayList<MenuItem> funneledMenu = MenuItem.funneledMenuItemList(printType);
			System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
			for (MenuItem item : funneledMenu) {
				System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(),
						item.getMenuItemType(), item.getPrice(), item.getDescription());
			}
		}
	}

	/**
	 * Adds MenuItem Object to the ArrayList. 
	 * @param price Price of the Item.
	 * @param description Description of the Item.
	 * @param name Name of the Item.
	 * @param itemType Type of the Item.
	 */
	public static void addMenuItem(int itemType, String name, String description, double price) {
		int id;    
		if (RestaurantApp.menuItems == null || RestaurantApp.menuItems.isEmpty()){
				id = 1;
			}
			else {
            MenuItem menuItemObj = RestaurantApp.menuItems.get((RestaurantApp.menuItems.size()) - 1);
            id = menuItemObj.getId() + 1;
			}
            MenuItem menuItem = new MenuItem(id, name, itemType, description, price);
            RestaurantApp.menuItems.add(menuItem);
        System.out.println("Menu Item has been Added");
	}

	/**
	 * Updates the object corresponding to the desired itemId in the MenuItem
	 * ArrayList.
	 * 
	 * @param itemId      ID of item to be edited.
	 * @param itemType    Type of item.
	 * @param name        Name of item.
	 * @param description Description of item.
	 * @param price       Price of item.
	 */
	public static void editMenuItem(int itemId, int itemType, String name, String description, double price) {
		for (int i = 0; i < (RestaurantApp.menuItems.size()); i++) {
			MenuItem menuItemObj = RestaurantApp.menuItems.get(i);
			if (itemId == menuItemObj.getId()) {
				menuItemObj.setName(name);
				menuItemObj.setMenuItemType(itemType);
				menuItemObj.setDescription(description);
				menuItemObj.setPrice(price);
				System.out.println("Menu item has been Edited");
				return;
			}
		}
	}

	/**
	 * Removes the object from the MenuItem ArrayList. Removes Promotion if it
	 * contains item object to be deleted.
	 * 
	 * @param itemID
	 */
	public static void deleteMenuItem(int itemID) {

		// Note to self, if the current item is a part of the promotion, need to handle
		// the deletion over there as well
		// If there is a promotion dependent on this item then delete the promotion as
		// well
		for (int i = 0; i < RestaurantApp.menuItems.size(); i++) {
			MenuItem menuItemObj = RestaurantApp.menuItems.get(i);
			if (itemID == menuItemObj.getId()) {
				for (int j = 0; j < RestaurantApp.promotionItems.size(); j++) { // iterate through promotionItems Arrray
					PromoItem promoItemObj = RestaurantApp.promotionItems.get(j);
					if (itemID == promoItemObj.getPromoAppetiser() || itemID == promoItemObj.getPromoMain()
							|| itemID == promoItemObj.getPromoDessert() || itemID == promoItemObj.getPromoDrink()) {
						RestaurantApp.promotionItems.remove(j);
						System.out.println("The Promotion with this Item has now been deleted");
					}
				}
			}

			// Basically the normal deletion (Deletes the item aswell, even if it was in the
			// promotion)
			for (int m = 0; m < RestaurantApp.menuItems.size(); m++) {
				MenuItem menuItemObj1 = RestaurantApp.menuItems.get(m);
				if (itemID == menuItemObj1.getId()) {
					RestaurantApp.menuItems.remove(m);
					System.out.println("Item Deleted");
					return;
				}
			}
		}
	}

	/**
	 * Prints out All the Current Promotion Items.
	 */

	public static void printpromotionItems() {

		System.out.println("All promotionItems");
		System.out.printf("%-10s %-10s %-10s %-10s\n", "ID", "Name", "Price", "Description");

		for (int i = 0; i < RestaurantApp.promotionItems.size(); i++) {
			PromoItem promo = RestaurantApp.promotionItems.get(i);
			MenuItem appetiserItem = MenuItem.retrieveMenuItem(promo.getPromoAppetiser());
			MenuItem mainItem = MenuItem.retrieveMenuItem(promo.getPromoMain());
			MenuItem dessertItem = MenuItem.retrieveMenuItem(promo.getPromoDessert());
			MenuItem drinkItem = MenuItem.retrieveMenuItem(promo.getPromoDrink());

			String tempDescription = ("In this promotion we have: ");
			String tempAppetiser = ("||" + promo.getPromoAppetiser() + "||");
			String tempMain = ("||" + promo.getPromoMain() + "||");
			String tempDessert = ("||" + promo.getPromoDessert() + "||");
			String tempDrink = ("||" + promo.getPromoDrink() + "||");

			// change the formatting to make it look better while testing
			System.out.printf("%-10s %-10s %-10s %-10s\n", promo.getId(), promo.getName(), promo.getPrice(),
					tempDescription);
			System.out.printf("%-10s %-10s %-10s\n", "Appetiser: ", tempAppetiser, appetiserItem.getName());
			System.out.printf("%-10s %-10s %-10s\n", "Main: ", tempMain, mainItem.getName());
			System.out.printf("%-10s %-10s %-10s\n", "Dessert: ", tempDessert, dessertItem.getName());
			System.out.printf("%-10s %-10s %-10s\n", "Drink: ", tempDrink, drinkItem.getName());
		}

	}

	/**
	 * Creates a Promotion Item object and adds it to the promotionItems Arraylist.
	 * 
	 * @param PromoName      Name of the promotion.
	 * @param PromoPrice     Price of the promotion.
	 * @param PromoAppetiser Appetiser in the current promotion.
	 * @param PromoMain      Main in the current promotion.
	 * @param PromoDessert   Dessert in the current promotion.
	 * @param PromoDrinks    Drinks in the current promotion.
	 */
	public static void createPromoItem(String PromoName, Double PromoPrice, int PromoAppetiser, int PromoMain,
			int PromoDessert, int PromoDrink) {
		PromoItem promotionObj = RestaurantApp.promotionItems.get((RestaurantApp.promotionItems.size()) - 1);
		int PromoID = promotionObj.getId() + 1;
		PromoItem promotion = new PromoItem(PromoID, PromoName, PromoPrice, PromoAppetiser, PromoMain, PromoDessert,
				PromoDrink);
		RestaurantApp.promotionItems.add(promotion);
		System.out.println("Promotion Has Been Created");

	}

	/**
	 * Updates Existing Promotion Object in the ArrayList.
	 * 
	 * @param PromoID        Id of the Promotion Object to be Updates.
	 * @param PromoName      Updated PromoName.
	 * @param PromoPrice     Updated PromoPrice
	 * @param PromoAppetiser Updated Appetiser
	 * @param PromoMain      Updated Main
	 * @param PromoDessert   Updated Dessert
	 */
	public static void editPromoItem(int PromoID, String PromoName, Double PromoPrice, int PromoAppetiser,
			int PromoMain, int PromoDessert, int PromoDrink) {

		for (int i = 0; i < (RestaurantApp.promotionItems.size()); i++) {
			PromoItem promoObj = RestaurantApp.promotionItems.get(i);
			if (PromoID == promoObj.getId()) {
				// Note to self: Arraylist returns a reference to the object, so any edits will
				// be reflected.
				PromoItem promo = PromoItem.retrievePromotion(PromoID);
				promo.setName(PromoName);
				promo.setPrice(PromoPrice);
				promo.setPromoAppetiser(PromoAppetiser);
				promo.setPromoMain(PromoMain);
				promo.setPromoDessert(PromoDessert);
				promo.setPromoDrink(PromoDrink);
				System.out.println("Promotion Has Been Edited");
				return;
			}
		}
	}

	/**
	 * 
	 * @param id
	 */
	public static void deletePromoItem(int id) {
		for (int i = 0; i < RestaurantApp.promotionItems.size(); i++) {
			PromoItem promoObj = RestaurantApp.promotionItems.get(i);
			if (id == promoObj.getId()) {
				RestaurantApp.promotionItems.remove(i);
				System.out.println("Promotion Has Been Deleted.");
				return;
			}
		}
	}
}
