package com.cz2002.ss10.utils;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.food.*;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;


public class MenuItemCsv implements IExtractCsv {

	/**
	 * @param filePath path on which csv lies on
	 */
    public Map<String, List<String>> extractInputFromCSV(String filePath) {

		Map<String, List<String>> menuItemMap = new HashMap<String, List<String>>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> r = reader.readAll(); // nested lists of lists
			r.forEach(menuItem -> menuItemMap.put(menuItem[0],getMenuInfoAsList(menuItem)));

			return menuItemMap;
		}
		catch (FileNotFoundException error) {
			throw new RuntimeException("File not found at specified file path!", error);
		}
		catch (IOException error) {
			throw new RuntimeException("Bad input obtained!", error);
		}
		catch (CsvException error) {
			throw new RuntimeException("Error encountered converting from CSV!", error);
		}

		
    }

	private List<String> getMenuInfoAsList(String[] menuItem) {
		List<String> menuInfo = new ArrayList<String>();
		menuInfo.addAll(Arrays.asList(menuItem[1], menuItem[2], menuItem[3], menuItem[4]));
		return menuInfo;
	}

	/**
	 * 
	 * @param menuList
	 */
	public void insertMenuList(Map<String, List<String>> menuList) {
		for (Map.Entry<String, List<String>> entry : menuList.entrySet()) {
			// get menu info
			List<String> menuInfo = entry.getValue();

			// add MenuItem object to MenuItems ArrayList in RestaurantApp
			RestaurantApp.menuItems.add(new MenuItem((int)Integer.parseInt(entry.getKey()), menuInfo.get(0), (int)Integer.valueOf(menuInfo.get(1)), menuInfo.get(2), Double.valueOf(menuInfo.get(3))));
		}
		
	}

	/**
	 * 
	 * @param menuList
	 */
	public String[] formatMenuToString(ArrayList<MenuItem> menuList) {
		// TODO - implement MenuItemCsv.formatMenuToString
		throw new UnsupportedOperationException();
	}

}