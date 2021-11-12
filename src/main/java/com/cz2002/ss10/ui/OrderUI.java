package com.cz2002.ss10.ui;

import com.cz2002.ss10.objects.food.MenuItem;
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

    Scanner sc = new Scanner(System.in);

    private int stuff;

    //constructor
    public OrderUI(){

    }

    public void createNewOrder(){
        String isMember;
        int flag = 0;
        System.out.println("Welcome to the order creation page!");
        do{
            System.out.println("Is the customer a member? ");
            isMember = sc.next().toLowerCase();
            if(isMember == "yes"){
                flag = 0;
            }
            else if(isMember == "no"){
                flag = 0;
            }
            else{
                flag = 1;
                System.out.println("Please enter either 'yes' or 'no' only");
            }
        }while(flag != 1);
        do{
            System.out.println("Please enter table number");
            isMember = sc.next().toLowerCase();
            if(isMember == "yes"){
                flag = 0;
            }
            else if(isMember == "no"){
                flag = 0;
            }
            else{
                flag = 1;
                System.out.println("Please enter either 'yes' or 'no' only");
            }
        }while(flag != 1);
    }












}


