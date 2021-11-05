package com.cz2002.ss10.utils;

import java.util.*;

public interface IExtractCsv {

	/**
	 * 
	 * @param fileName
	 */
	Map<String, List<String>> extractInputFromCSV(String fileName);

}