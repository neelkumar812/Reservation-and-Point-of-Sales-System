package com.cz2002.ss10.operations;

import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import java.util.*;
import java.time.*;

public class RestaurantService {


    Scanner sc = new Scanner(System.in);
    
    private static final int SEATCAP = 25;
    private Table[] tableList = new Table[SEATCAP];
    //Constructor to initialize all tables in increasing order of seating capacity.
    public RestaurantService(){
        for(int i = 0;i<SEATCAP; i++){
            if(i<5) tableList[i] = new Table(2, i+1, false);
            else if(i<10 && i>4) tableList[i] = new Table(4, i+1, false);
            else if(i<15 && i>9) tableList[i] = new Table(6, i+1, false);
            else if(i<20 && i>14) tableList[i] = new Table(8, i+1, false);
            else if(i>19) tableList[i] = new Table(10, i+1, false);
        }
    }
    public ArrayList<Table> getAvailableTables() {

        ArrayList<Table> temp = new ArrayList<Table>();
        for(int i = 0; i<SEATCAP;i++){
            if(tableList[i].getOccupancy() == false) temp.add(tableList[i]);
        }
        return temp;
        throw new UnsupportedOperationException();
    }
    /**
     * 
     * @param tableNumber
     * @param orderId
     */

    public void settlePayment(int tableNumber, int orderId) {
        // TODO - implement RestaurantService.settlePayment
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param staff
     * @param membershipType
     * @param tableNumber
     * @param orderItems
     */
    public void createNewOrder(Staff staff, String membershipType, int tableNumber, ArrayList<MenuItem> orderItems) {
        
        throw new UnsupportedOperationException();
    }

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
    public void checkReservation(int reservationId) {
        // TODO - implement RestaurantService.checkReservation
        try {
            throw new ReservationNotFoundException("Reservation of id: " + reservationId + " not found!");
        } catch (ReservationNotFoundException err) {
            // handle error
        }
    }

}