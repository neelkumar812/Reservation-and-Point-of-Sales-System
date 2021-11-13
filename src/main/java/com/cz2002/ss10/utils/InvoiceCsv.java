package com.cz2002.ss10.utils;

import com.cz2002.ss10.objects.logistics.*;
import com.cz2002.ss10.objects.food.*;

import java.lang.Integer;
import java.time.LocalDateTime;
import java.util.stream.*;
import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class InvoiceCsv implements IExportCsv {
	private String paidAtAsString; 
	private String orderTotalAsString;

	public void exportOutputToCSV(String formattedCsvString, String filePath) throws IOException {
		try {
			File f = new File(filePath);
			FileWriter writer = new FileWriter(f, true);

			writer.write(this.paidAtAsString);
			writer.write(System.getProperty("line.separator"));

			// add headers
			String[] header = { "Food Item", "Quantity", "Price" };
			writer.write(String.join(",", header));
			writer.write(System.getProperty("line.separator"));
			
			// add sale items
			writer.write(formattedCsvString);
			writer.write(System.getProperty("line.separator"));

			writer.write("Total: " + this.orderTotalAsString);
			writer.write(System.getProperty("line.separator"));

			writer.close();
		} catch (IOException ioError) {
			throw new RuntimeException("Error encountered converting output to CSV", ioError);
		}

	}

	/**
	 * 
	 * @param invoiceList
	 */
	public String formatInvoiceToString(Order order) {
		setPaidAtAsString(order.getPaidAt());
		setOrderTotalAsString(order.getSubtotal());
		ArrayList<RestaurantItem> clonedOrderItems = new ArrayList<RestaurantItem>();
		ArrayList<String> orderItemsByName = new ArrayList<String>();
		// create clone of order items
		for (RestaurantItem orderItem : order.getOrderItems()) {
			orderItemsByName.add(orderItem.getName());
			clonedOrderItems.add(orderItem);
		}

		// create set to get unique menu items
		Set<String> itemSet = new HashSet<String>(orderItemsByName);

		Map<String, ArrayList<String>> finalItemMap = getItemInfo(itemSet, clonedOrderItems);

		// convert all orders to string
		String outputAsStrings = finalItemMap.entrySet().stream().map(entry -> toRows(entry.getValue()))
				.collect(Collectors.joining(System.getProperty("line.separator"))); // OS dependent line separator

		return outputAsStrings;

	}

	private String toRows(ArrayList<String> itemDetails) {
		return Stream.of(itemDetails.get(0), itemDetails.get(1), itemDetails.get(2))
				.map(value -> value.replaceAll("\"", "\"\""))
				.map(value -> Stream.of("\"", ",").anyMatch(value::contains) ? "\"" + value + "\"" : value)
				.collect(Collectors.joining(","));
	}

	private HashMap<String, ArrayList<String>> getItemInfo(Set<String> itemSet, ArrayList<RestaurantItem> orderItems) {
		// create hash map with unique keys from list of order items
		// HashMap<orderItemName, quantity>
		HashMap<String, Integer> itemHashMap = new HashMap<String, Integer>();
		Iterator<String> iter = itemSet.iterator();
		while (iter.hasNext()) {
			itemHashMap.put(iter.next(), 0);
		}

		// iterate through arraylist of ordered items, update quantity count when item matches
		Iterator<RestaurantItem> iterator = orderItems.iterator();
		while (iterator.hasNext()){
				// update sale count for every item sold
				String key = iterator.next().getName();
				itemHashMap.put(key, itemHashMap.get(key) + 1);
		}

		// HashMap<orderItemName, [quantity, price*quantity]>
		HashMap<String, ArrayList<String>> finalItemHashMap = new HashMap<String, ArrayList<String>>();
		for (String key: itemHashMap.keySet()) {
			finalItemHashMap.put(key, addNameQuantityAndPrice(key, itemHashMap.get(key).toString(), orderItems));
		}

		return finalItemHashMap;
	}

	private ArrayList<String> addNameQuantityAndPrice(String itemName, String itemQuantity, ArrayList<RestaurantItem> orderedItems) {
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

	private void setPaidAtAsString(LocalDateTime paidAt){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		paidAtAsString = paidAt.format(formatter);
	}

	private void setOrderTotalAsString(double subtotal) {
		orderTotalAsString = String.valueOf(subtotal);
	}

}