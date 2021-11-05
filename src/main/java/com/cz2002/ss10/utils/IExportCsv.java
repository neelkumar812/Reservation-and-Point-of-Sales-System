package com.cz2002.ss10.utils;

public interface IExportCsv {

	/**
	 * 
	 * @param headers
	 * @param strings
	 * @param fileName
	 */
	void exportOutputToCSV(String[] headers, String[] strings, String fileName);

}