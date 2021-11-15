package com.cz2002.ss10.operations;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.person.*;
import com.cz2002.ss10.objects.food.*;
import java.util.*;
import java.time.*;

public class RestaurantService {

    public static final int TABLESEATCAP = 25;
    private static int cancellationCounter = 1000;
    Scanner sc = new Scanner(System.in);

    // Constructor
    public RestaurantService() {
    }

    /**
     * @param staff
     * @param membershipType
     * @param tableNumber
     * @param orderId
     * @param orderItems
     */

    public static void createNewOrder(Staff staff, Boolean membershipType, int tableNumber, int orderID,
            ArrayList<RestaurantItem> orderItems) {
        Order temp = new Order(staff, membershipType, tableNumber, orderID, orderItems);
        RestaurantApp.orders.add(temp);
        System.out.println("New order created!");

    }

    // SettlePayments essentially does all the calculation stuff, and calls
    // PrintOrderInvoice in the end
    public static void settlePayment(int tableNumber, int orderId) {
        double current = 0;
        double temp;
        double serviceChrg = 0;
        double gst = 0;
        double curTotal;
        double finalTotal = 0;
        int orderIndex = 0;

        for (int i = 0; i < RestaurantApp.orders.size(); i++) {
            if (RestaurantApp.orders.get(i).getOrderId() == orderId) {
                orderIndex = i;
                RestaurantApp.orders.get(i).markAsPaid();
                RestaurantApp.tables.get(tableNumber - 1).setOccupancy(false);
                System.out.println("Order paid and table is now available");
            } else
                System.out.println("OrderID not found");
        }
        // Calculating Total for This Order
        for (int i = 0; i < RestaurantApp.orders.size(); i++) {
            if (RestaurantApp.orders.get(i).getOrderId() == orderId)
                current = RestaurantApp.orders.get(i).getSubtotal();
            if (RestaurantApp.orders.get(i).getMembershipType() == true) {
                temp = 0.1 * current;
                current = current - temp;
            }
            serviceChrg = 0.1 * current;
            curTotal = serviceChrg + current;
            gst = 0.07 * curTotal;
            finalTotal = gst + curTotal;

        }
        printOrderInvoice(current, serviceChrg, gst, finalTotal, RestaurantApp.orders.get(orderIndex));

    }

    // Just prints the orderInvoice in a receipt format
    public static void printOrderInvoice(double subtotal, double serviceCharge, double GST, double finalTotal,
            Order order) {

        System.out.println("********************************************************************");
        System.out.println("                Thank you for dining with us today!");
        System.out.println("Date:" + LocalDate.now() + "                 Time:" + LocalTime.now());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Quantity | Item                                          | Price    |");
        Iterator<RestaurantItem> orderIterator = order.getOrderItems().iterator();
        HashMap<String, Integer> itemHashMap = new HashMap<String, Integer>();
        while (orderIterator.hasNext()) {
            // update sale count for every item sold
            String key = orderIterator.next().getName();
            if (itemHashMap.containsKey(key)) {
                itemHashMap.put(key, itemHashMap.get(key) + 1);
            } else {
                itemHashMap.put(key, 1);
            }
        }
        // HashMap<orderItemName, [quantity, price*quantity]>
        HashMap<String, ArrayList<String>> finalItemHashMap = new HashMap<String, ArrayList<String>>();
        for (String key : itemHashMap.keySet()) {
            finalItemHashMap.put(key, addNameQuantityAndPrice(key, itemHashMap.get(key).toString(), order.getOrderItems()));
        }
        for (ArrayList<String> value : finalItemHashMap.values()) {
            System.out.println(value.get(1) + "  " + value.get(0) + "           " + value.get(2));
        }
        System.out.println("********************************************************************");
        System.out.println("Subtotal:                                          $" + subtotal);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Service Charge:                                    $" + serviceCharge);
        System.out.println("GST           :                                    $" + GST);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Final Total:                                       $" + finalTotal);
        System.out.println("                Payment made via credit/debit card :) .             ");

    }

    private static ArrayList<String> addNameQuantityAndPrice(String itemName, String itemQuantity, ArrayList<RestaurantItem> orderedItems) {
		ArrayList<String> itemInfo = new ArrayList<String>();

		// get item price
		String itemPrice = "0.00";
		int index = 0;
		while (orderedItems.size() > index){
				if (orderedItems.get(index).getName() == itemName) {
					itemPrice = String.valueOf(orderedItems.get(index).getPrice()* Double.valueOf(itemQuantity));
				}
				index ++;
		}


		// update quantity and price of ordered item
		itemInfo.addAll(Arrays.asList(itemName,itemQuantity, itemPrice));
		return itemInfo;

	}

    /**
     * 
     * @param customerName
     * @param customerContact
     * @param dinerSize
     * @param reservationDate
     * @param reservationTime
     */
    public static void createNewReservation(int resId, LocalDate resDate, LocalTime resTime, String name, int contactNumber, int tableNumber, int dinerSize) {
    
        Reservation temp = new Reservation(resId, resDate, resTime, contactNumber, name, tableNumber, dinerSize);
        RestaurantApp.reservations.add(temp);
        System.out.println("Reservation ssuccessfully created");
    }

    /**
     * 
     * @param customerName
     * @param reservationId
     */
    public static void cancelReservation(String customerName, int reservationId) {
        for (int i = 0; i < RestaurantApp.reservations.size(); i++) {
            if (RestaurantApp.reservations.get(i).getReservationId() == reservationId) {
                RestaurantApp.reservations.remove(i);
                System.out.println("Reservation for " + customerName + "has been cancelled");
                cancellationCounter++;
                System.out.println("Cancellation ID: " + cancellationCounter);
                break;
            }

        }
        System.out.println("Error cancelling reservation, please try again!");

    }

    /**
     * 
     * @param reservationId
     */
    public static void checkReservation(int reservationID) {

        boolean existResv = false;
        for (int i = 0; i <= RestaurantApp.reservations.size(); i++) {
            if (RestaurantApp.reservations.get(i).getReservationId() == reservationID) {
                System.out.println("There is a reservation for " + RestaurantApp.reservations.get(i).getDinerSize()
                        + " people who are designated table number "
                        + RestaurantApp.reservations.get(i).getTableNumber());
                System.out.println("Reservation details are as follows: ");
                System.out.println("---------------------");
                System.out.println("Customer Name: " + RestaurantApp.reservations.get(i).getCustomerName());
                System.out
                        .println("Customer Contact Number: " + RestaurantApp.reservations.get(i).getCustomerContact());
                System.out.println("Reservation Date: " + RestaurantApp.reservations.get(i).getReservationDate());
                System.out.println("Reservation Time: " + RestaurantApp.reservations.get(i).getReservationTime());
                System.out.println("Reservation ID: " + RestaurantApp.reservations.get(i).getReservationId());
                existResv = true;
                break;
            }
        }
        if (existResv == false)
            System.out.println("Reservation not found!");
    }

}