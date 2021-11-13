package com.cz2002.ss10.ui;
import java.util.*;
import com.cz2002.ss10.objects.food.*;

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
     * Prints the menu of promotions stored in the CSV file.
     * Uses {@link RestaurantApp#promotions} and {@link MenuItem#retrieveMenuItem(int)}.
     */
    private void printPromotionUI() {

        //Code to print all promotions
       System.out.println("All Promotions");
        int n = 1;
        System.out.printf("%-5s %-10s %-10s %-10s\n", "ID", "Name", "Price",  "Description");

        for (int i = 0; i < RestaurantApp.promotions.size(); i++) {
            PromotionItem pi = RestaurantApp.promotions.get(i);
            MenuItem mainItem = MenuItem.retrieveMenuItem(pi.getPromoMain());
            MenuItem dessertItem = MenuItem.retrieveMenuItem(pi.getPromoDessert());
            MenuItem drinkItem = MenuItem.retrieveMenuItem(pi.getPromoDrink());

            String tempDescription = ("Served with the following items: ");
            String tempMain = ("[" + pi.getPromoMain() + "]");
            String tempDessert = ("[" + pi.getPromoDessert() + "]");
            String tempDrink = ("[" + pi.getPromoDrink() + "]");

            System.out.printf("%-5s %-10s %-10s %-10s\n", pi.getId(), pi.getName(), pi.getPrice(), tempDescription);
            System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n", "", "", "", "Main: ", tempMain, mainItem.getName());
            System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n", "", "", "", "Dessert: ", tempDessert, dessertItem.getName());
            System.out.printf("%-5s %-10s %-10s %-10s %-5s %-5s\n\n", "", "", "", "Drink: ", tempDrink, drinkItem.getName());
        }

    }



   
}