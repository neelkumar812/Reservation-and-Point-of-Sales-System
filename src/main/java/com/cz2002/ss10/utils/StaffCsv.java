package com.cz2002.ss10.utils;

import com.cz2002.ss10.objects.person.*;

import java.util.*;

public class StaffCsv implements IExtractCsv, IExportCsv {

    @Override
    public Map<String, List<String>> extractInputFromCSV(String fileName) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void exportOutputToCSV(String[] headers, String[] strings, String fileName) {
        // TODO Auto-generated method stub
        
    }

	/**
	 * 
	 * @param staffList
	 */
	public ArrayList<Staff> insertStaffList(Map<String, List<String>> staffList) {
		// TODO - implement StaffCsv.insertStaffList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param staffList
	 */
	public String[] formatStaffToString(ArrayList<Staff> staffList) {
		// TODO - implement StaffCsv.formatStaffToString
		throw new UnsupportedOperationException();
		int size = staffList.size();
		String sL[] = staffList.toArray(new String[size]);
		return sL;
	}

}