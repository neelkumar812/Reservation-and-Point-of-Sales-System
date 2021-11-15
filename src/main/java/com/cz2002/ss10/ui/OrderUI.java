package com.cz2002.ss10.ui;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.food.MenuItem;
import com.cz2002.ss10.objects.food.PromoItem;
import com.cz2002.ss10.objects.food.RestaurantItem;
import com.cz2002.ss10.objects.logistics.Order;
import com.cz2002.ss10.objects.person.Staff;
import com.cz2002.ss10.operations.RestaurantMenu;
import com.cz2002.ss10.operations.RestaurantService;

import org.w3c.dom.css.Counter;

import java.util.*;
import com.cz2002.ss10.RestaurantApp;

/**
 * OrderUI Class
 *
 * @author Neel Kumar 
 * @version 1.0
 * @since 2021-11-06
 */

public class OrderUI
{

    //constructor
    public OrderUI(){}


    
    public static void createNewOrder()
    {

        int counter = 0;
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        Boolean isMember;
        int tempTableNumber;
        int tempOrderId;
        ArrayList<RestaurantItem> tempOrderItems;

        System.out.println("Welcome to the order creation page!");
        
        //Ask if member
        System.out.println("Is the customer a member? Enter true for yes false for no");
        isMember = sc.nextBoolean();
        if(isMember == true){
            flag = 0;
        }
        else if (isMember == false){
            flag = 0;
        }
        else{
            flag = 1;
            System.out.println("Please enter either 'yes' or 'no' only");
        }

        //Ask for OrderID
        System.out.println("What is the order ID? ");
        tempOrderId = sc.nextInt();
       
        //Ask table number
        System.out.println("Please enter table number");
        tempTableNumber = sc.nextInt();
        if(tempTableNumber < 25 && RestaurantApp.tables.get(tempTableNumber-1).getOccupancy() == false){
            flag = 0;            
        }
        else if(tempTableNumber > 0 && RestaurantApp.tables.get(tempTableNumber-1).getOccupancy() == false){
            flag = 0;
        }
        else{
            flag = 1;
            System.out.println("Please enter a table from the available list");
        }

        //Ask Staff Details and setting staff details
        System.out.println(" Please enter Staff Details");
        System.out.println("============================");
        System.out.println("         Staff name? ");
        RestaurantApp.staffs.get(counter).setName(sc.next());
        System.out.println("        Staff gender? ");
        RestaurantApp.staffs.get(counter).setGender(sc.next().charAt(0));
        System.out.println("      Staff employeeID? ");
        RestaurantApp.staffs.get(counter).setStaffID(sc.nextInt());
        System.out.println("       Staff job title? ");
        RestaurantApp.staffs.get(counter).setJobTitle(sc.next());
        System.out.println("============================");
        counter++;

                //Ask the items ordered
        // Ask what Users want to order: Promotion Menu or Normal Menu?
        // Print Each Specific Menu 
        // Take and Add the specific item id into the the tempOrderItems (Restraunt Item) ArrayList
        int choice;
        do{
        System.out.println(" Which Menu would you like to order from? ");
        System.out.println("==========================================");
        System.out.println("            1. Promotion Menu             ");
        System.out.println("            2. Ala-Carte Menu             ");
        System.out.println("==========================================");
        System.out.println("     Enter the number of your choice:     ");
        choice = sc.nextInt();
        }while(choice<1 || choice > 2);

        switch(choice){
        case(1): 
        RestaurantMenu.printMenu(MenuItem.MenuItemType.ALL);
        boolean menuItemExists = false;
        while (!menuItemExists) {
            System.out.println("Enter the ID of Menu item to add: \n");
            int orderItemID = sc.nextInt(); 
            if (MenuItem.retrieveMenuItem(orderItemID) == null) 
            System.out.println("Enter a valid menu item ID.");
            else {
                menuItemExists = true;
                System.out.println("Enter quantity of item: \n");
                int itemQuantity = sc.nextInt();
                for(int i = 0; i < itemQuantity; i++){
                    for (int j = 0; j < (RestaurantApp.menuItems.size()); j++) {
                        MenuItem menuItemObj = RestaurantApp.menuItems.get(i); 
                        if (orderItemID == menuItemObj.getId()) {
                            tempOrderItems.add(menuItemObj);
                                System.out.println("Menu item has been added to Order");
                                return;
                        }
                    }
         
                }
         
            }
        }
            break;

            case(2):
            RestaurantMenu.printpromotionItems();
            boolean promoItemExists = false;
            while (!promoItemExists) {
                System.out.println("Enter the ID of Promo item to add: \n");
                int orderItemID = sc.nextInt(); 
                if (PromoItem.retrievePromotion(orderItemID) == null) 
                System.out.println("Enter a valid promo item ID.");
                else {
                    promoItemExists = true;
                    System.out.println("Enter quantity of item: \n");
                    int promoQuantity = sc.nextInt();
                    for(int i = 0; i < promoQuantity; i++){
                        for (int j = 0; j < (RestaurantApp.promotionItems.size()); j++) {
                         PromoItem promoItemObj = RestaurantApp.promotionItems.get(i); 
                            if (orderItemID == promoItemObj.getId()) {
                                tempOrderItems.add(promoItemObj);
                                    System.out.println("Promotion item has been added to Order");
                                    return;
                            }
                        }
              
                    }
                    

                }
            }
            break;
            default: System.out.println("Invalid Choice");
            break;
        };
        





        //Ask the items ordered
        // Ask what Users want to order: Promotion Menu or Normal Menu?
        // Print Each Specific Menu 
        // Take and Add the specific item id into the the tempOrderItems (Restraunt Item) ArrayList

        /**
         * @snesboola can help out with this part, basically this section asks the staff to input everything the user ordered. 
         * I think if you can also reference to another class which takes user input forOrders?
         */
        RestaurantService.createNewOrder(RestaurantApp.staffs.get(counter), isMember, tempTableNumber, tempOrderId, tempOrderItems);
        

        // Ask what Users want to order: Promotion Menu or Normal Menu?
        // Print Each Specific Menu 
        // Take and Add the specific item id into the the tempOrderItems (Restraunt Item) ArrayList
        

        
    }



}


