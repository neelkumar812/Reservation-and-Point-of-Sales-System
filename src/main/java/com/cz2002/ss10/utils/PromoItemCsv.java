package com.cz2002.ss10.utils;

import com.cz2002.ss10.objects.food.*;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class PromoItemCsv implements IExtractCsv {

    public Map<String, List<String>> extractInputFromCSV(String filePath) {

		Map<String, List<String>> promoItemMap = new HashMap<String, List<String>>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> r = reader.readAll();
			String[] promoItems = r.stream().toArray(String[]::new);
			int index = 0;
			while (promoItems.length > index) {
				ArrayList<String> promoInfo = new ArrayList<String>();
				promoInfo.addAll(Arrays.asList(promoItems[1], promoItems[2], promoItems[3], promoItems[4], promoItems[5], promoItems[6], promoItems[7]));
				promoItemMap.put(promoItems[0],promoInfo);
			}

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

	/**
	 * 
	 * @param promoList
	 */
	public void insertPromoList(Map<String, List<String>> promoList) {
		
	}

	/**
	 * 
	 * @param promoList
	 */
	public String[] formatPromoToString(ArrayList<PromoItem> promoList) {
		// TODO - implement PromoItemCsv.formatPromoToString
		throw new UnsupportedOperationException();
	}

}