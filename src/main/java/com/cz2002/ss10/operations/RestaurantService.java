package com.cz2002.ss10.operations;

import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;

import java.util.*;
import java.time.*;

public class RestaurantService {

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
	public void createNewReservation(String customerName, int customerContact, int dinerSize, LocalDate reservationDate, LocalTime reservationTime) {
		// TODO - implement RestaurantService.createNewReservation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reservationId
	 */
	public static void checkReservation(int reservationId) {
		// TODO - implement RestaurantService.checkReservation
		throw new UnsupportedOperationException();
	}

}