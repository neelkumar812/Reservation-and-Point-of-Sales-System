package com.cz2002.ss10;

import com.cz2002.ss10.operations.*;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.operations.RestaurantService.ReservationNotFoundException;

import java.time.*;
import java.util.*;

import org.junit.After;
import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class ReservationTest {
    /**
     * Set up test environment
     */
    private ArrayList<Reservation> reservations;
    private ArrayList<Table> tables;
    private RestaurantService restaurantService;

    @BeforeClass
    public void setUpRestaurant() {
        reservations = new ArrayList<Reservation>();
        tables = new ArrayList<Table>();
        restaurantService = new RestaurantService();
    }

    @After
    public void clearRestaurant(){
        reservations.clear();
        tables.clear();
    }

    /**
     * Expect no error if reservation exists even if full reservation capacity
     */
    @Test(expected = Test.None.class /* no exception expected */)
    public void fullReservationExistingReservation() {
        // create reservations until full occupancy (all tables booked)
        setToFullReservations(10);

        // check existing reservation
        restaurantService.checkReservation(1);
    }

    /**
     * Throw ReservationNotFoundException if reservation does not exists
     * When attempting to create new reservation, reject due to full reservation capcity
     */
    @Test(expected=ReservationNotFoundException.class)
    public void fullReservationNonexistentReservation() {
        try{
        // create reservations until full occupancy (all tables booked)
        setToFullReservations(10);

        // check null reservation
        restaurantService.checkReservation(0);
        }
        finally {
            // enter input to create new reservation

            // assert failed creation due to full reservation capacity
        }
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
        restaurantService.checkReservation(expiredReservationId);

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
        restaurantService.checkReservation(validReservationId);

        // check that reservation still exists
        Assert.assertNotNull(reservations
              .stream()
              .filter(reservation -> reservation.getReservationId() == validReservationId).findFirst().orElse(null));

        // check reservation table is still set to occupied
        Table reservationTable = tables.stream().filter(table -> table.getTableNumber() == validReservationTableNum).findFirst().orElse(null);
        Assert.assertEquals(true, reservationTable.getOccupancy()); 
    }

    public void setToFullReservations(int tableCount){
        // create tableCount number of table objects
        for (int i=1; i <= tableCount; i++) {
            tables.add(new Table(4, i, false));
        }

        // create tableCount number of reservations (all tables booked)
        for (int i=1; i <= tableCount; i++) {
            reservations.add(new Reservation(i, LocalDate.of(2021, 12, 25), LocalTime.of(16, 20, 45), new Random().nextInt(900000000) + 100000000, "Test Customer", 4));
        }
    }
    
}
