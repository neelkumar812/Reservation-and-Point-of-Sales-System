package com.cz2002.ss10.utils;

import java.io.IOException;

public interface IExportCsv {

	/**
	 * 
	 * @param headers
	 * @param strings
	 * @param fileName
	 */
	void exportOutputToCSV(String formattedCsvString, String filePath) throws IOException;

}