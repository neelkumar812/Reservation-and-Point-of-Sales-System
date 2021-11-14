package com.cz2002.ss10.ui;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.food.MenuItem;
import com.cz2002.ss10.objects.food.PromoItem;
import com.cz2002.ss10.objects.food.RestaurantItem;
import com.cz2002.ss10.objects.logistics.Order;
import com.cz2002.ss10.objects.logistics.Table;
import com.cz2002.ss10.objects.person.Staff;
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

public class ReservationUI
{

    //constructor
    public ReservationUI(){}
    
    public static void createNewReservation()
    {
        Scanner sc = new Scanner(System.in);
        int occupancyCounter = 0;
        int pax;
        String customerName;
        int customerPhone;
        int tempTableNumber = 0;
        int tempReservationId;
        ArrayList<RestaurantItem> tempOrderItems;

        System.out.println("Welcome to the reservation creation page!");

        //Assigning a table based on number of people
        System.out.println("How many people is the reservation for? ( MAX 10 PAX )");
        pax = sc.nextInt(); 
        if(pax <= 2 && pax >=1){
            for(int i = 0;i<5;i++)
            {
                if(RestaurantApp.tables.get(i).getOccupancy() == false){
                    Table temp = new Table(pax, i+1, true);
                    RestaurantApp.tables.remove(i);
                    RestaurantApp.tables.add(i, temp); //i'm not sure if this line of code works 
                    System.out.println("Table no. " + i+1 + "is available!");
                    tempTableNumber = i+1;
                    break;
                }
                else occupancyCounter++;
            }
            if(occupancyCounter >= 4) System.out.println("Sorry, no more tables available for your desired number of people :(");
            occupancyCounter = 0;
        }
        else if(pax <= 4 && pax >=2){
            for(int i = 5;i<10;i++)
            {
                if(RestaurantApp.tables.get(i).getOccupancy() == false){
                    Table temp = new Table(pax, i+1, true);
                    RestaurantApp.tables.remove(i);
                    RestaurantApp.tables.add(i, temp); //i'm not sure if this line of code works 
                    System.out.println("Table no. " + i+1 + "is available!");
                    tempTableNumber = i+1;
                    break;
                }
                else occupancyCounter++;
            }
            if(occupancyCounter >= 4) System.out.println("Sorry, no more tables available for your desired number of people :(");
            occupancyCounter = 0;
        }
        else if(pax <= 6 && pax >=4){
            for(int i = 10;i<15;i++)
            {
                if(RestaurantApp.tables.get(i).getOccupancy() == false){
                    Table temp = new Table(pax, i+1, true);
                    RestaurantApp.tables.remove(i);
                    RestaurantApp.tables.add(i, temp); //i'm not sure if this line of code works 
                    System.out.println("Table no. " + i+1 + "is available!");
                    tempTableNumber = i+1;
                    break;
                }
                else occupancyCounter++;
            }
            if(occupancyCounter >= 4) System.out.println("Sorry, no more tables available for your desired number of people :(");
            occupancyCounter = 0;
        }
        else if(pax <= 8 && pax >=6){
            for(int i = 15;i<20;i++)
            {
                if(RestaurantApp.tables.get(i).getOccupancy() == false){
                    Table temp = new Table(pax, i+1, true);
                    RestaurantApp.tables.remove(i);
                    RestaurantApp.tables.add(i, temp); //i'm not sure if this line of code works 
                    System.out.println("Table no. " + i+1 + "is available!");
                    tempTableNumber = i+1;
                    break;
                }
                else occupancyCounter++;
            }
            if(occupancyCounter >= 4) System.out.println("Sorry, no more tables available for your desired number of people :(");
            occupancyCounter = 0;
        
        }
        else if(pax <= 10 && pax >=8){
            for(int i = 20;i<25;i++)
            {
                if(RestaurantApp.tables.get(i).getOccupancy() == false){
                    Table temp = new Table(pax, i+1, true);
                    RestaurantApp.tables.remove(i);
                    RestaurantApp.tables.add(i, temp); //i'm not sure if this line of code works 
                    System.out.println("Table no. " + i+1 + "is available!");
                    tempTableNumber = i+1;
                    break;
                }
                else occupancyCounter++;
            }
            if(occupancyCounter >= 4) System.out.println("Sorry, no more tables available for your desired number of people :(");
            occupancyCounter = 0;
        }
        
        else System.out.println("Too many people per table!");
        
        //Ask for Customer Name
        System.out.println("Name of customer making the reservation?");
        customerName = sc.next();

        //Ask for Customer Contact Number
        System.out.println("Contact number of customer making the reservation?");
        customerPhone = sc.nextInt();
        
        //Ask for ReservationID
        System.out.println("What is the Reservation ID? ");
        tempReservationId = sc.nextInt();
       
        //Ask table number
        System.out.println("You have been assigned Table number: " + tempTableNumber);
        
        //Creating the reservation
        RestaurantService.createNewReservation(customerName, customerPhone, pax, tempTableNumber, tempReservationId);
    }

}


