package com.cz2002.ss10;

import com.cz2002.ss10.operations.*;
import com.cz2002.ss10.objects.*;
import com.cz2002.ss10.objects.logistics.*;
import java.util.*;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReservationTest {
    /**
     * Set up test environment
     */
    @Before
    public void setUpRestaurant() {
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        ArrayList<Table> tables = new ArrayList<Table>();
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
        Reservation expiredReservation = Reservation(8888888,LocalDate.now(), LocalTime.now(),12345678, 'Test Customer', 4);
        reservations.add(expiredReservation);

        // access reservation after period expiry
        // should remove reservation
        // TODO: make it a static method?
        RestaurantService.checkReservation(expiredReservation.getReservationId);

        // check that reservation has been removed
        Assert.assertEquals(null, reservations
              .stream()
              .filter(reservation -> reservation.getReservationId().equals(expiredReservation.getReservationId())).findFirst().orElse(null));

        // check reservation table is set to unoccupied
        Table reservationTable = tables.stream().filter(table -> table.getTableNumber().equals(reservation.getTableNumber())).findFirst().orElse(null);
        Assert.assertEquals(false, reservationTable.getOccupancy());
    }

    /**
     * Keep reservation if reservation period has not expired
     * @result Reservation will be present in RestaurantApp records
     */
    @Test
    public void retainReservationBeforePeriodExpiry() {
        // create reservation and add to reservations array
        Reservation validReservation = Reservation(8888888,LocalDate.of(2021, 12, 25), LocalTime.of(16, 20, 45) ,12345678, 'Test Customer', 4);
        reservations.add(validReservation);

        // access reservation after period expiry
        // should retain reservation
        RestaurantService.checkReservation(validReservation.getReservationId);

        // check that reservation still exists
        Assert.assertNotNull(reservations
              .stream()
              .filter(reservation -> reservation.getReservationId().equals(validReservation.getReservationId())).findFirst().orElse(null));

        // check reservation table is still set to occupied
        Table reservationTable = tables.stream().filter(table -> table.getTableNumber().equals(reservation.getTableNumber())).findFirst().orElse(null);
        Assert.assertEquals(true, reservationTable.getOccupancy()); 
    }
    
}
