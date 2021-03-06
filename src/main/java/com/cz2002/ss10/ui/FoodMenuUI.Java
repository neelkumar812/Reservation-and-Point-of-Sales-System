package com.cz2002.ss10.ui;
import java.util.*;
import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.operations.RestaurantMenu;
import com.cz2002.ss10.RestaurantApp;

/**
 * FoodMenuUI Class
 *
 * @author Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

public class FoodMenuUI{
//comment
    /**
     * Scanner Init
     */
    FoodMenuUI(){};

        public static void printMenuUI() {
            int selection;
            MenuItem.MenuItemType type = MenuItem.MenuItemType.ALL;
                do {
                    System.out.println("Enter the number of the item type you would like to print: \n");
                    System.out.println("1. Appetiser");
                    System.out.println("2. Main");
                    System.out.println("3. Drink");
                    System.out.println("4. Dessert");
                    System.out.println("5. All Items");
                    selection = RestaurantApp.sc.nextInt();

                    switch (selection) {
                        case 1:
                        type = MenuItem.MenuItemType.APPETISERS;
                        System.out.println("All Items");
                        break;
                        
                        case 2:
                        type = MenuItem.MenuItemType.MAIN;
                        System.out.println("Mains");
                        break;

                        case 3:
                        type = MenuItem.MenuItemType.DRINK;
                        System.out.println("Drinks");
                        break;

                        case 4:
                        type = MenuItem.MenuItemType.DESSERT;
                            System.out.println("Dessert");
                            break;

                        case 5:
                            type = MenuItem.MenuItemType.ALL;
                            System.out.println("All Items");
                            break;

                        case 0:

                        default: 
                        System.out.println("Please Choose a Valid Option.");
                         
                } 
            } while (selection < 0 || selection > 5); 
            RestaurantMenu.printMenu(type);
        }

        public static void addNewMenuItemUI() {
        String newItemName;
        int newItemType;
        String newItemDescription;
        double newItemPrice;
        do {
            System.out.println("Enter the number of the new menu item type: ");
            System.out.println("1. Appetiser");
            System.out.println("2. Main");
            System.out.println("3. Drink");
            System.out.println("4. Dessert");
            newItemType = RestaurantApp.sc.nextInt();
        } while (newItemType < 1 || newItemType > 4);

        System.out.println("Enter new menu item name: ");
        RestaurantApp.sc.nextLine(); 
        newItemName = RestaurantApp.sc.nextLine();

        System.out.println("Enter new menu item description: ");
        newItemDescription = RestaurantApp.sc.nextLine();

        System.out.println("Enter new menu item price: ");
        newItemPrice = RestaurantApp.sc.nextDouble();

        RestaurantMenu.addMenuItem(newItemType, newItemName, newItemDescription, newItemPrice);
         
        }

    public static void editMenuItemUI() {
        int editItemID = 0;
        String updatedItemName;
        int updatedItemType;
        String updatedItemDescription;
        double updatedItemPrice;

       //Insert Logic to  print existing menu
        System.out.println("Existing Menu: ");
        RestaurantMenu.printMenu(MenuItem.MenuItemType.ALL);
        
        //Insert Logic to find menu item  
        boolean menuItemExists = false;
        while (!menuItemExists) {
            System.out.println("Enter the ID of Menu item to be updated: \n");
            editItemID = RestaurantApp.sc.nextInt(); 
            if (MenuItem.retrieveMenuItem(editItemID) == null) System.out.println("Enter a valid menu item ID.");
            else menuItemExists = true;
        }

        do {
            System.out.println("Enter what type you want to change: ");
            System.out.println("1. Appetiser");
            System.out.println("2. Main");
            System.out.println("3. Drink");
            System.out.println("4. Dessert");
            updatedItemType = RestaurantApp.sc.nextInt();
        } while (updatedItemType < 1 || updatedItemType > 4);

        //Get all the changed parameters 

        System.out.println("Enter Updated name: ");
        RestaurantApp.sc.nextLine(); 
        updatedItemName = RestaurantApp.sc.nextLine();

        System.out.println("Enter Updated description: ");
        updatedItemDescription = RestaurantApp.sc.nextLine();

        System.out.println("Enter Updated price: ");
        updatedItemPrice = RestaurantApp.sc.nextDouble();

         
        RestaurantMenu.editMenuItem(editItemID, updatedItemType, updatedItemName, updatedItemDescription, updatedItemPrice);

    }

    public static void deleteMenuItemUI() {
        int deleteItemID = 0;
        // Insert Logic to Print Existing Menu
        System.out.println("Existing Menu: ");
        RestaurantMenu.printMenu(MenuItem.MenuItemType.ALL);
        //Insert Logic to find menu item 
        boolean menuItemExists = false;
        while (!menuItemExists) {
            System.out.println("Enter ID of Item to be deleted: \n");
            deleteItemID = RestaurantApp.sc.nextInt(); 
            if (MenuItem.retrieveMenuItem(deleteItemID) == null) System.out.println("Enter a valid ID.");
            else menuItemExists = true;
             
        }
        RestaurantMenu.deleteMenuItem(deleteItemID);
    }
}



