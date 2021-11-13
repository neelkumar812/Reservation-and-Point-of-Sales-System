package com.cz2002.ss10.ui;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.food.MenuItem;
import com.cz2002.ss10.objects.food.PromoItem;
import com.cz2002.ss10.objects.logistics.Order;
import com.cz2002.ss10.objects.person.Staff;
import com.cz2002.ss10.operations.RestaurantService;
import java.util.*;

/**
 * OrderUI Class
 *
 * @author Neel Kumar 
 * @version 1.0
 * @since 2021-11-06
 */

public class OrderUI{

    //private static final int SEATCAP = 25;
    //private Table[] tableList = new Table[SEATCAP];
    Scanner sc = new Scanner(System.in);

    private int stuff;

    //constructor
    public OrderUI(){

    }
    public void createNewOrder(){

        int flag = 0;

        String isMember;
        int tempTableNumber;
        Staff tempStaff;
        ArrayList<MenuItem> tempOrdOrders;



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
       
        //Ask table number
        System.out.println("Please enter table number");
        tempTableNumber = sc.nextInt();
        if(tempTableNumber < 25 && this.[tempTableNumber-1].getOccupancy == false){
            flag = 0;            
        }
        else if(tempTableNumber > 0 && this.[tempTableNumber-1].getOccupancy == false){
            flag = 0;
         }
        else{
            flag = 1;
            System.out.println("Please enter a table from the available list");
        }

        //Ask Staff Details 
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
        RestaurantService.createNewOrder(tempStaff, isMember, tempTableNumber, tempOrdOrders);
        } 

    
        /**
     * Adds item to Order
     *
     * @param o Order Object
     */
    private void addOrdOrder(Order o) {
        System.out.println("Select Item Type:");
        System.out.println("1) Ala-carte Items");
        System.out.println("2) Promotion Set");
        System.out.println("0) Cancel");
        int selection = doMenuChoice(2, 0);

        switch (selection) {
            case 1:
                addAlaCarteItem(o);
                break;
            case 2:
                if (RestaurantApp.promotions.size() == 0) {
                    System.out.println("No promotions available");
                    return;
                }
                System.out.println("Promotion Sets", 40);
                int i = 0;
                for (PromoItem p : RestaurantApp.promotions) {
                    // Get each item in promotion
                    System.out.printf("%3d) %-27s $%-6.2f\n", (i + 1), p.getName(), p.getPrice());
                    i++;
                }
                printBreaks(40);
                int promotionSelected = ScannerHelper.getIntegerInput("Enter Set ID (0 to cancel): ", -1, RestaurantApp.promotions.size() + 1) - 1;
                if (promotionSelected < 0) {
                    System.out.println("Operation Cancelled. Returning to Order Edit screen");
                    return;
                }
                int quantity = ScannerHelper.getIntegerInput("Enter Quantity: ", 0);

                // Print promotion detail and ask if we really want to add this
                PromoItem p = RestaurantApp.promotions.get(promotionSelected);
                System.out.println();
                System.out.printf(p.getName() + " Details", 60, "\n");
                System.out.printf(p.printPromotionDetail(), "\n");
                System.out.println("Quantity: " + quantity + "");
                System.out.printf("Total Set Price: $%.2f\n", (quantity * p.getPrice()));
                boolean confirm = ScannerHelper.getYesNoInput("Confirm Promotion Set Selection?");
                if (confirm) {
                    // Add to Order
                    o.getOrdOrders().add(newOrder(p.getId(), quantity,Order.OrdOrderType.TYPE_PROMO));
                    o.calculateSubtotal();
                    System.out.println("Promotion Set Added to Order");
                }
                break;
            case 0:
                return;
            default:
                throw new MenuChoiceInvalidException("Order Item Add");
        }
    }

    /**
     * Adds ala-carte items {@link MenuItem} to the Order
     *
     * @param o Order object to add the item to
     */
    private void addAlaCarteItem(Order o) {

        int selection = 0;
        int itemSel = 0;
        MenuItem.MenuItemType itemType;

        do{

            System.out.println("Select Ala-Carte Item Types:");
            System.out.println("1) Main Dishes");
            System.out.println("2) Dessert");
            System.out.println("3) Drinks");
            System.out.println("0) Cancel");
           
            selection = sc.nextInt();

            switch (selection) {
                case 1:
                itemType = MenuItem.MenuItemType.MAIN;
                    break;
                case 2:
                itemType = MenuItem.MenuItemType.DESSERT;
                    break;
                case 3:
                itemType = MenuItem.MenuItemType.DRINK;
                    break;
                case 0:
                    return;
                default:
                System.out.println("Error");
            }

        } while (selection < 0 || selection > 3);
   
        ArrayList<MenuItem> foodItems = MenuItem.retrieveMenuItemListFiltered(itemType);
        if (foodItems.size() == 0) {
            System.out.println("No items in this category. Exiting....");
            return;
        }
        System.out.printf("List of " + itemType, 60, "/n");

        for(int i = 0; i < foodItems.size()-1; i++){
            MenuItem m = foodItems.get(i);
            System.out.printf("%3d) %-47s $%-6.2f\n", (i + 1), m.getName(), m.getPrice());
        }
       
        System.out.println("Enter Item ID: ");
        itemSel = sc.nextInt();
        if (itemSel < 0 || itemSel > foodItems.size() + 1) {
            System.out.println("Operation Cancelled. Returning to Order Edit screen");
            return;
        }
        
        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();

        MenuItem mi = foodItems.get(itemSel);
            o.getOrder().add(new Order(mi.getId(), quantity,Order.OrderType.TYPE_MENU));
            o.calculateSubtotal();
            System.out.println("Item Added to Order");
        }
    }












}


