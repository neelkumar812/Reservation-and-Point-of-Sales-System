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
     * Scanner for use in retrieving user input.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * The PromotionItem Management Menu
     * @return Exit Code. Return 1 to exit the program and -1 to exit to main menu
     */

    protected int generateMenuScreen() {
        
        int choice;
        
        do {

            System.out.println("Promotion Item Management");
            System.out.println("1) View existing promotions");
            System.out.println("2) Create a new promotion");
            System.out.println("3) Update an existing promotion");
            System.out.println("4) Delete a promotion");
            System.out.println("5) Back to main menu");
            System.out.println("0) Exit Application");

            choice = sc.nextInt();
            switch (choice) {
    
                case 1: // Prints existing promotions
                    this.printPromotionUI();
                    break;
                case 2: // Create a new promotion
                    this.addNewPromotionUI();
                    break;
    
                case 3: //Edit an existing promotion
                    this.editPromotionUI();
                    break;
                case 4: //Delete an existing promotion
                    this.deletePromotionUI();
                    break;
                case 5:
                    return -1;
                case 0:
                    return 1;
                default:
                    System.out.println("Invalid choice.");
            }
            return 0;
    
        } while (choice < 0 || choice > 5);
    }

    /**
     * Calls the print promotion items method 
     * 
     */
    private void printPromotionUI() {

        RestaurantMenu.printpromotionItems();

    }


    /**
     * User Interface to get inputs for new promotion item 
     * 
     */

     private void addNewPromotionUI(){

        String newPromoName;
        double newPromoPrice;
        int newPromoAppetiser = 0;
        int newPromoMain = 1;
        int newPromoDessert = 2;
        int newPromoDrink = 3;
        boolean appetiserFound = false;
        boolean mainFound = false;
        boolean dessertFound = false;
        boolean drinkFound = false;

        //have to create 3 temporary arrays here to filter out.
        ArrayList<MenuItem> filteredAppetisersMenu = MenuItem.retrieveMenuItemListFiltered(MenuItem.MenuItemType.APPETISERS);
        ArrayList<MenuItem> filteredMainMenu = MenuItem.retrieveMenuItemListFiltered(MenuItem.MenuItemType.MAIN); //the main here is just for main dishes
        ArrayList<MenuItem> filteredDessertMenu = MenuItem.retrieveMenuItemListFiltered(MenuItem.MenuItemType.DESSERT);
        ArrayList<MenuItem> filteredDrinkMenu = MenuItem.retrieveMenuItemListFiltered(MenuItem.MenuItemType.DRINK);

        System.out.println("Enter new promotion set name: ");
        sc.nextLine(); //required if previous scanner takes in int, and now string is required
        newPromoName = sc.nextLine();

        System.out.println("Enter new promotion's price: ");
        newPromoPrice = sc.nextInt();

        //Code to print filtered menu of appetisers 
        System.out.println("All Appetiser Items");
        System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredAppetisersMenu) {
            System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }

        while (!appetiserFound) {
            System.out.println("Enter new promotion's appetiser ID: ");
            newPromoAppetiser = sc.nextInt();
            mainFound = MenuItem.menuTypeChecker(filteredAppetisersMenu, newPromoAppetiser, "Main");
            if (!appetiserFound) System.out.println("Main not found. Please enter a valid main ID.");
        }


        //Code to print filtered menu of mains
        System.out.println("All Main Items");
        System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredMainMenu) {
            System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }

        while (!mainFound) {
            System.out.println("Enter new promotion's main ID: ");
            newPromoMain = sc.nextInt();
            mainFound = MenuItem.menuTypeChecker(filteredMainMenu, newPromoMain, "Main");
            if (!mainFound) System.out.println("Main not found. Please enter a valid main ID.");
        }

        //Code to print filtered menu of desserts
        System.out.println("All Dessert Items");
        System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredDessertMenu) {
            System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }

        while (!dessertFound) {

            System.out.println("Enter new promotion's dessert ID: ");
            newPromoDessert = sc.nextInt();
            dessertFound = MenuItem.menuTypeChecker(filteredDessertMenu, newPromoDessert, "Dessert");
            if (!dessertFound) System.out.println("Dessert not found. Please enter a valid dessert ID.");
        }

        //Code to print filtered menu of drinks
        System.out.println("All Drink Items");
        System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredDrinkMenu) {
            System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }

        while (!drinkFound) {
            System.out.println("Enter new promotion's drink ID: ");
            newPromoDrink = sc.nextInt();
            drinkFound = MenuItem.menuTypeChecker(filteredDrinkMenu, newPromoDrink, "Drink");
            if (!drinkFound) System.out.println("Drink not found. Please enter a valid drink ID.");
            //need to find way to reprompt for input!
        }

        RestaurantMenu.createPromoItem(newPromoName, newPromoPrice, newPromoAppetiser, newPromoMain, newPromoDessert, newPromoDrink);

     }


    /**
     * User Interface to get inputs for Edit Promotion UI  
     * 
     */

    private void editPromotionUI(){

        String editPromoName;
        double editPromoPrice;
        int editPromoAppetiser = 0;
        int editPromoMain = 1;
        int editPromoDessert = 2;
        int editPromoDrink = 3;
        boolean appetiserFound = false; 
        boolean mainFound = false;
        boolean dessertFound = false;
        boolean drinkFound = false;


        //have to create 3 temporary arrays here to filter out.
        ArrayList<MenuItem> filteredAppetisersMenu = MenuItem.retrieveMenuItemListFiltered(MenuItem.MenuItemType.APPETISERS);
        ArrayList<MenuItem> filteredMainMenu = MenuItem.retrieveMenuItemListFiltered(MenuItem.MenuItemType.MAIN);   
        ArrayList<MenuItem> filteredDessertMenu = MenuItem.retrieveMenuItemListFiltered(MenuItem.MenuItemType.DESSERT);
        ArrayList<MenuItem> filteredDrinkMenu = MenuItem.retrieveMenuItemListFiltered(MenuItem.MenuItemType.DRINK);

        System.out.println("Enter edited promotion set name: ");
        sc.nextLine(); //required if previous scanner takes in int, and now string is required
        editPromoName = sc.nextLine();

        System.out.println("Enter edited promotion's price: ");
        editPromoPrice = sc.nextInt();

        //Code to print filtered menu of appetisers 
        System.out.println("All Appetiser Items");
        System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredAppetisersMenu) {
            System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }

        while (!appetiserFound) {
            System.out.println("Enter edited promotion's Appetiser ID: ");
            editPromoMain = sc.nextInt();
            mainFound = MenuItem.menuTypeChecker(filteredAppetisersMenu, editPromoMain, "Main");
            if (!appetiserFound) System.out.println("Main not found. Please enter a valid main ID.");
        }


        //Code to print filtered menu of mains
        System.out.println("All Main Items");
        System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredMainMenu) {
            System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }

        while (!mainFound) {
            System.out.println("Enter new promotion's main ID: ");
            editPromoMain = sc.nextInt();
            mainFound = MenuItem.menuTypeChecker(filteredMainMenu, editPromoMain, "Main");
            if (!mainFound) System.out.println("Main not found. Please enter a valid main ID.");
        }

        //Code to print filtered menu of desserts
        System.out.println("All Dessert Items");
        System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredDessertMenu) {
            System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }

        while (!dessertFound) {

            System.out.println("Enter new promotion's dessert ID: ");
            editPromoDessert = sc.nextInt();
            dessertFound = MenuItem.menuTypeChecker(filteredDessertMenu, editPromoDessert, "Dessert");
            if (!dessertFound) System.out.println("Dessert not found. Please enter a valid dessert ID.");
        }

        //Code to print filtered menu of drinks
        System.out.println("All Drink Items");
        System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", "ID", "Name", "Type", "Price", "Description");
        for (MenuItem mi : filteredDrinkMenu) {
            System.out.printf("%-5s %-50s %-6s %-6s %-9s\n", mi.getId(), mi.getName(), mi.getMenuItemType(), mi.getPrice(), mi.getDescription());
        }

        while (!drinkFound) {
            System.out.println("Enter new promotion's drink ID: ");
            editPromoDrink = sc.nextInt();
            drinkFound = MenuItem.menuTypeChecker(filteredDrinkMenu, editPromoDrink, "Drink");
            if (!drinkFound) System.out.println("Drink not found. Please enter a valid drink ID.");
        }

        RestaurantMenu.editPromoItem(editPromoName, editPromoPrice, editPromoAppetiser, editPromoMain, editPromoDessert, editPromoDrink);

    }

    /**
     * User Interface to get inputs for new promotion item 
     * 
     */

    private void deletePromotionUI(){

        int targetPromoID = 1;
        boolean promoFound = false;

        RestaurantMenu.printpromotionItems();

        while (!promoFound) {
            System.out.println("Enter the ID of the promotion to be deleted: ");
            targetPromoID = sc.nextInt();
            if (PromoItem.retrievePromotion(targetPromoID) == null) 
            System.out.println("Invalid ID. Please enter a valid promo item ID.");
            else promoFound = true;
        }

        RestaurantMenu.deletePromoItem(targetPromoID);

    }
       
}