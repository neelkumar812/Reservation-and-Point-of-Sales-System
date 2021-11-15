package com.cz2002.ss10.ui;
import java.util.*;
import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.operations.RestaurantMenu;

/**
 * PromotionMenuUI Class
 *
 * @author Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

public class PromotionMenuUI {

    /**
     * Main menu for staff to use 
     * @return Exit Code. Return 1 to exit the program and -1 to exit to main menu
     */
    PromotionMenuUI(){}
    
    public static int promotionMenuHandler() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Which Action would you like to perform?");
            System.out.println("1. View existing promotions");
            System.out.println("2. Create New promotion");
            System.out.println("3. Update Existing promotion");
            System.out.println("4. Delete promotion");
            System.out.println("5. Go to Main Menu");
            System.out.println("0. Exit App");
            choice = sc.nextInt();
            switch (choice) {
                case 1: 
                PromotionMenuUI.printPromotionUI();
                    break;
                case 2: 
                PromotionMenuUI.addNewPromotionUI();
                    break;
    
                case 3: 
                PromotionMenuUI.editPromotionUI();
                    break;
                case 4: 
                PromotionMenuUI.deletePromotionUI();
                    break;
                case 5:
                    return -1;
                case 0:
                    return 1;
                default:
                    System.out.println("Invalid choice.");
            }
            sc.close();
            return 0;
        
        } while (choice < 0 || choice > 5);
        
    }

    /**
     * Calls the print promotion items method 
     * 
     */
    private static void printPromotionUI() {
        RestaurantMenu.printpromotionItems();
    }


    /**
     * User Interface to get inputs for new promotion item 
     * 
     */


     //Overall Logic: 
     //Print all the filtered items so that user can pick and use 
     //Make user enter ID
     // If ID valid assign to variable
     // Else prompt again 

     private static void addNewPromotionUI(){
        Scanner sc = new Scanner(System.in);
        String newName;
        double newPrice;
        int newAppetiser = 1;
        int newMain = 2;
        int newDrink = 3;
        int newDessert = 4;
        boolean appetiserFound = false;
        boolean mainFound = false;
        boolean dessertFound = false;
        boolean drinkFound = false;

        ArrayList<MenuItem> filteredAppetisersMenu = MenuItem.funneledMenuItemList(MenuItem.MenuItemType.APPETISERS);
        ArrayList<MenuItem> filteredMainMenu = MenuItem.funneledMenuItemList(MenuItem.MenuItemType.MAIN); 
        ArrayList<MenuItem> filteredDessertMenu = MenuItem.funneledMenuItemList(MenuItem.MenuItemType.DESSERT);
        ArrayList<MenuItem> filteredDrinkMenu = MenuItem.funneledMenuItemList(MenuItem.MenuItemType.DRINK);

        System.out.println("Enter new promotion set name: ");
        sc.nextLine(); 
        newName = sc.nextLine();

        System.out.println("Enter new promotion's price: ");
        newPrice = sc.nextInt();

        System.out.println("All Appetiser Items");
        System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem item : filteredAppetisersMenu) {
            System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(), item.getMenuItemType(), item.getPrice(), item.getDescription());
        }

        while (!appetiserFound) {
            System.out.println("Enter new promotion's appetiser ID: ");
            newAppetiser = sc.nextInt();
            mainFound = MenuItem.typeCheck(filteredAppetisersMenu, newAppetiser);
            if (!appetiserFound) System.out.println("Enter a valid main ID.");
        }

        System.out.println("All Main Items");
        System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem item : filteredMainMenu) {
            System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(), item.getMenuItemType(), item.getPrice(), item.getDescription());
        }

        while (!mainFound) {
            System.out.println("Enter new promotion's main ID: ");
            newMain = sc.nextInt();
            mainFound = MenuItem.typeCheck(filteredMainMenu, newMain);
            if (!mainFound) System.out.println("Enter a valid main ID.");
        }

        System.out.println("All Dessert Items");
        System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem item : filteredDessertMenu) {
            System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(), item.getMenuItemType(), item.getPrice(), item.getDescription());
        }

        while (!dessertFound) {
            System.out.println("Enter new promotion's dessert ID: ");
            newDessert = sc.nextInt();
            dessertFound = MenuItem.typeCheck(filteredDessertMenu, newDessert);
            if (!dessertFound) System.out.println("Enter a valid dessert ID.");
        }

        System.out.println("All Drink Items");
        System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem item : filteredDrinkMenu) {
            System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(), item.getMenuItemType(), item.getPrice(), item.getDescription());
        }

        while (!drinkFound) {
            System.out.println("Enter new promotion's drink ID: ");
            newDrink = sc.nextInt();
            drinkFound = MenuItem.typeCheck(filteredDrinkMenu, newDrink);
            if (!drinkFound) System.out.println("Enter a valid drink ID.");
        }
        sc.close();
        RestaurantMenu.createPromoItem(newName, newPrice, newAppetiser, newMain, newDessert, newDrink);

     }


    /**
     * User Interface to get inputs for Edit Promotion UI  
     * 
     */

    private static void editPromotionUI(){
        Scanner sc = new Scanner(System.in);
        String editPromoName;
        double editPromoPrice;
        int editPromoID = 1;
        int editPromoAppetiser = 1;
        int editPromoMain = 2;
        int editPromoDrink = 3;
        int editPromoDessert = 4;
        boolean appetiserFound = false; 
        boolean mainFound = false;
        boolean dessertFound = false;
        boolean drinkFound = false;
        boolean promoFound = false;


        ArrayList<MenuItem> filteredAppetisersMenu = MenuItem.funneledMenuItemList(MenuItem.MenuItemType.APPETISERS);
        ArrayList<MenuItem> filteredMainMenu = MenuItem.funneledMenuItemList(MenuItem.MenuItemType.MAIN);   
        ArrayList<MenuItem> filteredDessertMenu = MenuItem.funneledMenuItemList(MenuItem.MenuItemType.DESSERT);
        ArrayList<MenuItem> filteredDrinkMenu = MenuItem.funneledMenuItemList(MenuItem.MenuItemType.DRINK);

        while (!promoFound) {
            System.out.println("Enter the ID of the promotion to be edited: ");
            editPromoID = sc.nextInt(); 
            if (PromoItem.retrievePromotion(editPromoID) == null)
             System.out.println("Invalid ID. Please enter a valid promo item ID.");
            else promoFound = true;
        }

        //retrieve menu item with editItemID check.
        if (PromoItem.retrievePromotion(editPromoID) == null){
            System.out.println("Invalid ID. Promotion not found.");
            sc.close();
            return;
        }

        System.out.println("Enter edited promotion set name: ");
        sc.nextLine(); //required if previous scanner takes in int, and now string is required
        editPromoName = sc.nextLine();

        System.out.println("Enter updated price for the promotion: ");
        editPromoPrice = sc.nextInt();

        //Code to print filtered menu of appetisers 
        System.out.println("All Appetiser Items");
        System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem item : filteredAppetisersMenu) {
            System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(), item.getMenuItemType(), item.getPrice(), item.getDescription());
        }

        while (!appetiserFound) {
            System.out.println("Enter updated Appetiser ID for the promotion: ");
            editPromoMain = sc.nextInt();
            mainFound = MenuItem.typeCheck(filteredAppetisersMenu, editPromoMain);
            if (!appetiserFound) System.out.println("Enter a valid Appetiser ID.");
        }


        //Code to print filtered menu of mains
        System.out.println("All Main Items");
        System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem item : filteredMainMenu) {
            System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(), item.getMenuItemType(), item.getPrice(), item.getDescription());
        }

        while (!mainFound) {
            System.out.println("Enter Updated main ID for the Promotion: ");
            editPromoMain = sc.nextInt();
            mainFound = MenuItem.typeCheck(filteredMainMenu, editPromoMain);
            if (!mainFound) System.out.println("Enter a valid main ID.");
        }

        System.out.println("All Dessert Items");
        System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem item : filteredDessertMenu) {
            System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(), item.getMenuItemType(), item.getPrice(), item.getDescription());
        }

        while (!dessertFound) {
            System.out.println("Enter Updated dessert ID for the Promotion: ");
            editPromoDessert = sc.nextInt();
            dessertFound = MenuItem.typeCheck(filteredDessertMenu, editPromoDessert);
            if (!dessertFound) System.out.println("Enter a valid dessert ID.");
        }

        //Code to print filtered menu of drinks
        System.out.println("All Drink Items");
        System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem item : filteredDrinkMenu) {
            System.out.printf("%-10s %-50s %-10s %-10s %-10s\n", item.getId(), item.getName(), item.getMenuItemType(), item.getPrice(), item.getDescription());
        }

        while (!drinkFound) {
            System.out.println("Enter Updated drink ID for the promotion: ");
            editPromoDrink = sc.nextInt();
            drinkFound = MenuItem.typeCheck(filteredDrinkMenu, editPromoDrink);
            if (!drinkFound) System.out.println("Enter a valid drink ID.");
        }
        sc.close();
        RestaurantMenu.editPromoItem(editPromoID, editPromoName, editPromoPrice, editPromoAppetiser, editPromoMain, editPromoDessert, editPromoDrink);
    }

    /**
     * Collect user inputs for deleting promotion
     * okay
     */
    
    private static void deletePromotionUI(){
        Scanner sc = new Scanner(System.in);
        int targetID = 1;
        boolean promoFound = false;
        RestaurantMenu.printpromotionItems();
        while (!promoFound) {
            System.out.println("Enter ID of the Promotion to be Deleted : ");
            targetID = sc.nextInt();
            if (PromoItem.retrievePromotion(targetID) == null) System.out.println("Enter a valid Promotion item ID.");
            else promoFound = true;
        }
        RestaurantMenu.deletePromoItem(targetID);
        sc.close();
    }
       
}