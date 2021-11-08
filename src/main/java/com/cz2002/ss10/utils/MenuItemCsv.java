package com.cz2002.ss10.utils;

import com.cz2002.ss10.objects.food.*;

import java.util.*;
import java.io.*.;


public class MenuItemCsv implements IExtractCsv {

    @Override
    public Map<String, List<String>> extractInputFromCSV(String fileName) {
        // TODO Auto-generated method stub

		String line ="";
        try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			List<String> values = new ArrayList<>();
			while((line = br.readLine()) != null){
				values.add(line.split(","));
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		String key = Files.readAllLines(Paths.get(fileName)).get(0); 

		Map<String, List<String>> map = new HashMap<>();

		map.put(key,values[i]);
    }

	/**
	 * 
	 * @param menuList
	 */
	public String[] formatMenuToString(ArrayList<MenuItem> menuList) {
		// TODO - implement MenuItemCsv.formatMenuToString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param menuList
	 */
	public void insertMenuList(Map<String, List<String>> menuList) {
		// TODO - implement MenuItemCsv.insertMenuList
		throw new UnsupportedOperationException();
	}

}