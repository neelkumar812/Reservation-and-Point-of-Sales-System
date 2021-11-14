package com.cz2002.ss10.operations;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;

import java.util.*;
import java.time.*;
import com.cz2002.ss10.RestaurantApp;

public class RestaurantService {

    public static final int TABLESEATCAP =25;

    Scanner sc = new Scanner(System.in);

    //Constructor
    public RestaurantService(){}
    /**
     * @param staff
     * @param membershipType
     * @param tableNumber
     * @param orderId
     * @param orderItems
     */

    public static void createNewOrder(Staff staff, String membershipType, int tableNumber, int orderID, ArrayList<MenuItem> orderItems)
     {
        Order temp = new Order(staff, membershipType, tableNumber, orderID, orderItems);
        RestaurantApp.orders.add(temp);
        throw new UnsupportedOperationException();
    }

    //SettlePayments essentially does all the calculation stuff, and calls PrintOrderInvoice in the end
    public void settlePayment(int tableNumber, int orderId) {
        // TODO - implement RestaurantService.settlePayment
        


        throw new UnsupportedOperationException();
    }

    //Just prints the orderInvoice in a receipt format
    public void printOrderInvoice() {
		
        System.out.println( "============================");
		throw new UnsupportedOperationException();

    /**
     * 
     * @param staff
     * @param membershipType
     * @param tableNumber
     * @param orderItems
     */
    
    /**
     * 
     * @param customerName
     * @param reservationId
     */
    public void cancelReservation(String customerName, int reservationId) {
        // TODO - implement RestaurantService.cancelReservation
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param customerName
     * @param customerContact
     * @param dinerSize
     * @param reservationDate
     * @param reservationTime
     */
    public void createNewReservation(String customerName, int customerContact, int dinerSize, LocalDate reservationDate,
            LocalTime reservationTime) {
        // TODO - implement RestaurantService.createNewReservation
        throw new UnsupportedOperationException();
    }

    public class ReservationNotFoundException extends Exception {
        public ReservationNotFoundException() {
        }

        public ReservationNotFoundException(String message) {
            super(message);
        }
    }

    /**
     * 
     * @param reservationId
     */
    public static void checkReservation(int reservationId) {
        // TODO - implement RestaurantService.checkReservation
        try {
            throw new ReservationNotFoundException("Reservation of id: " + reservationId + " not found!");
        } catch (ReservationNotFoundException err) {
            // handle error
        }
    }







    

}