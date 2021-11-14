package com.cz2002.ss10.utils;

import com.cz2002.ss10.RestaurantApp;
import com.cz2002.ss10.objects.food.*;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class PromoItemCsv implements IExtractCsv {

	/**
	 * @param filePath path on which csv lies on
	 */
    public Map<String, List<String>> extractInputFromCSV(String filePath) {

		Map<String, List<String>> promoItemMap = new HashMap<String, List<String>>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> r = reader.readAll(); // nested lists of lists
			r.forEach(promoItem -> promoItemMap.put(promoItem[0],getPromoInfoAsList(promoItem)));

			return promoItemMap;
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

	private List<String> getPromoInfoAsList(String[] promoItem) {
		List<String> promoInfo = new ArrayList<String>();
		promoInfo.addAll(Arrays.asList(promoItem[1], promoItem[2], promoItem[3], promoItem[4], promoItem[5], promoItem[6], promoItem[7]));
		return promoInfo;
	}

	/**
	 * 
	 * @param promoList
	 */
	public void insertPromoList(Map<String, List<String>> promoList) {
		for (Map.Entry<String, List<String>> entry : promoList.entrySet()) {
			// get promo info
			List<String> promoInfo = entry.getValue();

			// add PromoItem object to PromoItems ArrayList in RestaurantApp
			RestaurantApp.promotionItems.add(new PromoItem((int)Integer.parseInt(entry.getKey()), promoInfo.get(0), Double.valueOf(promoInfo.get(1)), (int)Integer.valueOf(promoInfo.get(2)), (int)Integer.valueOf(promoInfo.get(3)), (int)Integer.valueOf(promoInfo.get(4)), (int)Integer.valueOf(promoInfo.get(5))));
		}
		
	}

}