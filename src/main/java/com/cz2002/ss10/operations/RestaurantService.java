package com.cz2002.ss10.operations;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import com.cz2002.ss10.logistics.Reservation;
import java.util.*;

import java.time.*;


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

    public static void createNewOrder(Staff staff, Boolean membershipType, int tableNumber, int orderID, ArrayList<RestaurantItem> orderItems)
     {
        Order temp = new Order(staff, membershipType, tableNumber, orderID, orderItems);
        RestaurantApp.orders.add(temp);
        
    }

    //SettlePayments essentially does all the calculation stuff, and calls PrintOrderInvoice in the end
    public static void settlePayment(int tableNumber, int orderId) 
    {
        double current = 0;
        double temp;
        double serviceChrg = 0;
        double gst = 0;
        double curTotal;
        double finalTotal = 0;

        for(int i = 0; i<RestaurantApp.orders.size();i++)
        {
            if(RestaurantApp.orders.get(i).getOrderId() == orderId)
            {
                RestaurantApp.orders.get(i).markAsPaid(); 
                RestaurantApp.tables.get(tableNumber-1).setOccupancy(false);
                System.out.println("Order paid and table is now available");
            }
            else System.out.println("OrderID not found");
        }
        //Calculating Total for This Order
        for(int i = 0; i<RestaurantApp.orders.size();i++)
        {
            if(RestaurantApp.orders.get(i).getOrderId() == orderId) current = RestaurantApp.orders.get(i).getSubtotal();
            if(RestaurantApp.orders.get(i).getMembershipType() == true)
            {
                temp = 0.1 * current;
                current = current - temp;
            } 
            serviceChrg = 0.1*current;
            curTotal = serviceChrg + current;
            gst = 0.07*curTotal;
            finalTotal = gst + curTotal;
            
        }
        printOrderInvoice(current, serviceChrg, gst, finalTotal);
        
    }

    //Just prints the orderInvoice in a receipt format
    public static void printOrderInvoice(double subtotal, double serviceCharge, double GST, double finalTotal) {
		
        System.out.println("********************************************************************");
        System.out.println("                Thank you for dining with us today!");
        System.out.println("Date:          " + LocalDate.now() + "Time:             " + LocalTime.now());
        System.out.println("--------------------------------------------------------------------");
        //Print all the items ordered along with their prices 
        System.out.println("********************************************************************");
        System.out.println("Subtotal:                                          $" + subtotal);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Service Charge:                                    $" + serviceCharge);
        System.out.println("GST           :                                    $" + GST);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Final Total:                                       $" + finalTotal);
        System.out.println("                Payment made via credit/debit card :) .                 ");
        
		
    }

    /**
     
    /**
     * 
     * @param customerName
     * @param reservationId
     */
    public void cancelReservation(int telNo) {
        // TODO - implement RestaurantService.cancelReservation
         for(int i = 0;i<=RestaurantApp.reservations.size();i++){
            if(RestaurantApp.reservations.get(i).getCustomerContact()== telNo){
                RestaurantApp.reservations.get(i).cancelReservation();
                break;
            }
        }
        
    }

    /**
     * 
     * @param customerName
     * @param customerContact
     * @param dinerSize
     * @param reservationDate
     * @param reservationTime
     */
    public void createNewReservation(int resvID,LocalDate resDate, LocalTime resTime, int contactNumber, String name, int dinerSize) {
        // TODO - implement RestaurantService.createNewReservation
        Reservation newResv = new Reservation( resvID,resDate,  resTime,  contactNumber,  name, dinerSize);
        System.out.println("Reservation ssuccessfully created");
        
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
    public static boolean checkReservation(int telNo) {
        // TODO - implement RestaurantService.checkReservation
        boolean existResv = false;

        for(int i = 0;i<=RestaurantApp.reservations.size();i++){
            if(RestaurantApp.reservations.get(i).getCustomerContact()== telNo){
                existResv= true;
                System.out.println("Reservation for "+ RestaurantApp.reservations.get(i).getCustomerName + " for the session of " + RestaurantApp.reservations.get(i).getResvSession() + " at " + RestaurantApp.reservations.get(i).getResvTime);
            }
        }

        return existResv;
    }









    

}