package com.cz2002.ss10.ui;

import com.cz2002.ss10.objects.food.MenuItem;
import com.cz2002.ss10.objects.logistics.Order;
import com.cz2002.ss10.objects.person.Staff;
import com.cz2002.ss10.logistics.Reservation;
import java.util.*;
import java.time.*;



public class ReservationUI{

    Scanner sc = new Scanner(System.in);

    protected int generateMenuScreen() {
        printHeader("Reservation Booking System");
        System.out.println("1) Create a new reservation booking");
        System.out.println("2) Check reservation booking");
        System.out.println("3) Remove reservation booking");
        System.out.println("4) List all current reservations");
        System.out.println("5) Check for expired reservations");
        System.out.println("6) Back to main menu");
        System.out.println("0) Exit Application");
        

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                this.createReservationBooking();
                break;
            case 2:
                this.checkReservationBooking();
                break;
            case 3:
                this.removeReservationBooking();
                break;
            case 4:
                this.listReservations();
                break;
            case 5:
                this.checkExpiredReservations();
                break;
            case 6:
                return -1;
            case 0:
                return 1;
            default:
                throw new MenuChoiceInvalidException("Reservation Menu");
        }
        return 0;
    }

    
   












}


