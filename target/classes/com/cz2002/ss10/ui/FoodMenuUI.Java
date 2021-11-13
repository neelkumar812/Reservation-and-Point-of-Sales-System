package com.cz2002.ss10.ui;
import java.util.*;
import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.operations.RestaurantMenu;

/**
 * FoodMenuUI Class
 *
 * @author Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

public class FoodMenuUI{

    /**
     * Scanner for use in retrieving user input.
     */
    Scanner sc = new Scanner(System.in);

        /**
         * The Food Menu Items Management Menu
         *
         * @return Exit Code. Return 1 to exit the program and -1 to exit to main menu
         */
        
        public int generateMenuScreen() {

            int choice;


            do {
                System.out.println("Menu Items Operations");
                System.out.println("1. Print existing menu");
                System.out.println("2. Create new menu item");
                System.out.println("3. Edit an existing menu item's details");
                System.out.println("4. Delete menu item");
                System.out.println("5. Back to main menu");
                System.out.println("0. Exit Application");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: // Prints menu
                        this.printMenuUI();
                        break;
                    case 2: // Create new menu item
                        this.addNewMenuItemUI();
                        break;
                    case 3: // Edit an existing menu item
                        this.editMenuItemUI();
                        break;
                    case 4: // Delete an existing menu item
                        this.deleteMenuItemUI();
                        break;
                    case 5:
                        return -1;
                    case 0:
                        return 1;

                    default:
                       System.out.println("Invalid Choice.");

                }

            return 0;

            } while (choice < 0 || choice > 5);
        }


        private void printMenuUI() {

            int selection;
            MenuItem.MenuItemType printType = MenuItem.MenuItemType.ALL;

                do {
                    System.out.println("Enter the number of the item type you would like to print: \n");
                    System.out.println("1) Main");
                    System.out.println("2) Dessert");
                    System.out.println("3) Drink");
                    System.out.println("4) Appetiser");
                    System.out.println("5) All");
                    selection = sc.nextInt();

                    switch (selection) {
                        case 1:
                            printType = MenuItem.MenuItemType.MAIN;
                            System.out.println("Mains");
                            break;
                        case 2:
                            printType = MenuItem.MenuItemType.DESSERT;
                            System.out.println("Desserts");
                            break;
                        case 3:
                            printType = MenuItem.MenuItemType.DRINK;
                            System.out.println("Drinks");
                            break;
                        case 4:
                            printType = MenuItem.MenuItemType.APPETISERS;
                            System.out.println("All Items");
                            break;

                        case 5:
                            printType = MenuItem.MenuItemType.ALL;
                            System.out.println("All Items");
                            break;

                        case 0:
                            return;
                        
                        default: 
                        System.out.println("Please Choose a Valid Option");

                } 

            } while (selection < 0 || selection > 5); 

            RestaurantMenu.printMenu(printType);
        }

        private void addNewMenuItemUI() {

        String newItemName;
        int newItemType;
        String newItemDescription;
        double newItemPrice;

        do {

            System.out.println("Enter the number of the new menu item type: ");
            System.out.println("1) Main");
            System.out.println("2) Dessert");
            System.out.println("3) Drink");
            System.out.println("4) Appetiser");

            newItemType = sc.nextInt();

        } while (newItemType < 1 || newItemType > 4);

        System.out.println("Adding Item....");


        System.out.println("Enter new menu item name: ");
        sc.nextLine(); 
        newItemName = sc.nextLine();

        System.out.println("Enter new menu item description: ");
        newItemDescription = sc.nextLine();

        System.out.println("Enter new menu item price: ");
        newItemPrice = sc.nextDouble();

        RestaurantMenu.addMenuItem(newItemType, newItemName, newItemDescription, newItemPrice);

        System.out.println("Add successful. New menu item has been successfully added.");
        
        }


    private void editMenuItemUI() {

        int editItemID;
        String editedItemName;
        int editedItemType;
        String editedItemDescription;
        double editedItemPrice;

        // Insert Logic to Print Existing Menu

        System.out.println("Existing Menu: ");
        RestaurantMenu.printMenu(MenuItem.MenuItemType.ALL);
        
        //Insert Logic to find menu item 

        boolean menuItemFound = false;

        while (!menuItemFound) {
            System.out.println("Enter the ID of the menu item to be edited: \n");
            editItemID = sc.nextInt(); 
            if (MenuItem.retrieveMenuItem(editItemID) == null)
                System.out.println("Invalid ID. Please enter a valid menu item ID.");

            else menuItemFound = true;
        }

        // Get Params

        do {

            System.out.println("Enter what type you want to change: ");
            System.out.println("1) Main");
            System.out.println("2) Dessert");
            System.out.println("3) Drink");
            System.out.println("4) Appetiser");

            editedItemType = sc.nextInt();

        } while (editedItemType < 1 || editedItemType > 4);

        System.out.println("Enter new name: ");
        sc.nextLine(); 
        editedItemName = sc.nextLine();

        System.out.println("Enter new description: ");
        editedItemDescription = sc.nextLine();

        System.out.println("Enter new price: ");
        editedItemPrice = sc.nextDouble();

        RestaurantMenu.addMenuItem( editedItemType, editedItemName, editedItemDescription, editedItemPrice);

    }

    private void deleteMenuItemUI() {

        int deleteItemID = 0;

        // Insert Logic to Print Existing Menu

        System.out.println("Existing Menu: ");
        RestaurantMenu.printMenu(MenuItem.MenuItemType.ALL);
            
        //Insert Logic to find menu item 
    
        boolean menuItemFound = false;
    
        while (!menuItemFound) {
            System.out.println("Enter the ID of the menu item to be deleted: \n");
            deleteItemID = sc.nextInt(); 
            if (MenuItem.retrieveMenuItem(deleteItemID) == null)
                System.out.println("Invalid ID. Please enter a valid menu item ID.");
    
            else menuItemFound = true;
        }

        RestaurantMenu.deleteMenuItem(deleteItemID);

    }


}



