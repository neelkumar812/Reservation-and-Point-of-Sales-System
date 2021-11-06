package com.cz2002.ss10.operations;

import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;

import java.util.*;
import java.time.*;

public class RestaurantService {

    public RestaurantService(){}

    public ArrayList<Table> getAvailableTables() {
        // TODO - implement RestaurantService.getAvailableTables
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
        // TODO - implement RestaurantService.createNewOrder
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