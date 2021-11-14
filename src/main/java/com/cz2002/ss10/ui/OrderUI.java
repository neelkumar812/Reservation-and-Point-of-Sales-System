package com.cz2002.ss10.ui;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.food.MenuItem;
import com.cz2002.ss10.objects.food.PromoItem;
import com.cz2002.ss10.objects.logistics.Order;
import com.cz2002.ss10.objects.person.Staff;
import com.cz2002.ss10.operations.RestaurantService;
import java.util.*;
import com.cz2002.ss10.RestaurantApp;

/**
 * OrderUI Class
 *
 * @author Neel Kumar 
 * @version 1.0
 * @since 2021-11-06
 */

public class OrderUI{

    /**
     * Scanner Init
     */
    Scanner sc = new Scanner(System.in);

    /**
    * Main Menu Screen For staff to contol orderUI functionality 
    */
        
    public int menuScreen() {

        int choice;
        do {
            System.out.println("Which Action would you like to perform?");
            System.out.println("1. Create new order");
            System.out.println("2. View orders");
            System.out.println("3. Edit order");
            System.out.println("4. Back to main menu");
            System.out.println("0. Exit App");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createNewOrderUI();
                    break;
                case 2:
                    viewOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    return -1;
                case 0:
                    return 1;
                default:
                System.out.println("Please pick a valid option");
            }
            return 0;
        } while (choice < 0 || choice > 5);
    }

 
    public void createNewOrderUI(){
        int flag = 0;
        String isMember;
        int tempTableNumber;
        Staff tempStaff;
        int tempOrderId;
        ArrayList<MenuItem> tempOrderItems;

        System.out.println("Welcome to the order creation page!");
        
        //Ask if member
        System.out.println("Is the customer a member? ");
        isMember = sc.next().toLowerCase();
        if(isMember == "yes"){
            flag = 0;
        }
        else if (isMember == "no"){
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
        tempStaff.setName(sc.next());
        System.out.println("        Staff gender? ");
        tempStaff.setGender(sc.next());
        System.out.println("      Staff employeeID? ");
        tempStaff.setStaffID(sc.nextInt());
        System.out.println("       Staff job title? ");
        tempStaff.setJobTitle(sc.next());
        System.out.println("============================");

        //Ask the items ordered
        /**
         * @snesboola can help out with this part, basically this section asks the staff to input everything the user ordered. 
         * I think if you can also reference to another class which takes user input forOrders?
         */


        













        RestaurantService.createNewOrder(tempStaff, isMember, tempTableNumber, tempOrderId, tempOrderItems);

        
    } 
}


