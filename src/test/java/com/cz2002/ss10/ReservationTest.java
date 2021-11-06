package com.cz2002.ss10;

import com.cz2002.ss10.operations.*;
import com.cz2002.ss10.objects.*;
import com.cz2002.ss10.objects.logistics.*;

import java.time.*;
import java.util.*;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReservationTest {
    /**
     * Set up test environment
     */
    private static ArrayList<Reservation> reservations;
    private static ArrayList<Table> tables;

    @Before
    public static void setUpRestaurant() {
        reservations = new ArrayList<Reservation>();
        tables = new ArrayList<Table>();
    }

    /**
     * 
     */
    @Test
    public void fullReservationExistingReservation() {

    }

    /**
     * 
     */
    @Test
    public void fullReservationNonexistentReservation() {
        
    }

    /**
     * Return error if staff makes reservation with invalid
     */
    @Test
    public void fullReservationInvalidReservation() {
        // TODO: Change int to operation corresponding to reservation
    }

    /**
     * Remove reservation if reservation period expires
     * @result Reservation will be removed from RestaurantApp records
     *         Corresponding table object will have isOccupied set to false
     */
    @Test
    public void removeReservationAfterPeriodExpiry() {
        // create reservation and add to reservations array
        Reservation expiredReservation = new Reservation(8888888,LocalDate.now(), LocalTime.now(),12345678, "Test Customer", 4);
        reservations.add(expiredReservation);

        int expiredReservationId = expiredReservation.getReservationId();
        int expiredReservationTableNum = expiredReservation.getTableNumber();

        // access reservation after period expiry
        // should remove reservation
        RestaurantService.checkReservation(expiredReservationId);

        // check that reservation has been removed
        Assert.assertEquals(null, reservations
              .stream()
              .filter(reservation -> reservation.getReservationId() == expiredReservationId).findFirst().orElse(null));

        // check reservation table is set to unoccupied
        Table reservationTable = tables.stream().filter(table -> table.getTableNumber() == expiredReservationTableNum).findFirst().orElse(null);
        Assert.assertEquals(false, reservationTable.getOccupancy());
    }

    /**
     * Keep reservation if reservation period has not expired
     * @result Reservation will be present in RestaurantApp records
     */
    @Test
    public void retainReservationBeforePeriodExpiry() {
        // create reservation and add to reservations array
        Reservation validReservation = new Reservation(8888888,LocalDate.of(2021, 12, 25), LocalTime.of(16, 20, 45) ,12345678, "Test Customer", 4);
        reservations.add(validReservation);

        int validReservationId = validReservation.getReservationId();
        int validReservationTableNum = validReservation.getTableNumber();

        // access reservation after period expiry
        // should retain reservation
        RestaurantService.checkReservation(validReservationId);

        // check that reservation still exists
        Assert.assertNotNull(reservations
              .stream()
              .filter(reservation -> reservation.getReservationId() == validReservationId).findFirst().orElse(null));

        // check reservation table is still set to occupied
        Table reservationTable = tables.stream().filter(table -> table.getTableNumber() == validReservationTableNum).findFirst().orElse(null);
        Assert.assertEquals(true, reservationTable.getOccupancy()); 
    }
    
}
