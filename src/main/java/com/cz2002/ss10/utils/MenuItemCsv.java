package com.cz2002.ss10.utils;

import com.cz2002.ss10.objects.food.*;

import java.util.*;
import java.io.*;


public class MenuItemCsv extends baseCsv {

	/**
     * Path to Menu Items CSV File in the data folder. Defaults to menu.csv.
     */
    private String menuItemCsv = "menu.csv";

    /**
     * Singleton instance of this class.
     */
    private static MenuItemCsv mInstance;

    /**
     * Default Constructor to initialize this class with menu.csv as the CSV file.
     */
    private MenuItemCsv() {
    }

    // public Map<String, List<String>> extractInputFromCSV(String fileName) {

	// 	String line ="";
    //     try{
	// 		BufferedReader br = new BufferedReader(new FileReader(fileName));
	// 		List<String> values = new ArrayList<>();
	// 		while((line = br.readLine()) != null){
	// 			values.add(line.split(","));
	// 		}
	// 	}catch(FileNotFoundException e){
	// 		e.printStackTrace();
	// 	}
	// 	catch(IOException e){
	// 		e.printStackTrace();
	// 	}
	// 	String key = Files.readAllLines(Paths.get(fileName)).get(0); 

	// 	Map<String, List<String>> map = new HashMap<>();

	// 	map.put(key,values[i]);
    // }

	/**
     * Gets the singleton instasvMenuItemCsv that reads from menu.csv
     *
     * @return Instance of this class
     */
    public static MenuItemCsv getInstance() {
        if (mInstance == null) mInstance =  new MenuItemCsv();
        return mInstance;
    }

	/**
     * Reads the CSV file and parses it into an array list of menu item objects.
     *
     * @return ArrayList of Menu Item Objects.
     * @throws IOException Unable to read from file.
     */
    public ArrayList<MenuItem> readFromCsv() throws IOException {
        if (!FileIOHelper.exists(this.menuItemCsv)) return new ArrayList<>(); // Empty array list
        BufferedReader csvFile = FileIOHelper.getFileBufferedReader(this.menuItemCsv);
        List<String[]> csvLines = readAll(csvFile, 1);
        ArrayList<MenuItem> items = new ArrayList<>();
        if (csvLines.size() == 0) return items;
        csvLines.forEach((str) -> items.add(new MenuItem(str)));
        return items;
    }

    /**
     * Writes to the CSV File.
     *
     * @param items ArrayList of Menu items to save.
     * @throws IOException Unable to write to file.
     */
    public void writeToCsv(ArrayList<MenuItem> items) throws IOException {
        String[] header = {"ID", "Name", "Price", "Type", "Description"};
        BufferedWriter csvFile = FileIOHelper.getFileBufferedWriter(this.menuItemCsv);
        ArrayList<String[]> toWrite = new ArrayList<>();
        toWrite.add(header);
        items.forEach((i) -> toWrite.add(i.toCsv()));
        writeToCsvFile(toWrite, csvFile);
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