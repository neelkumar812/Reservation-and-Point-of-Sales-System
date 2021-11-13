package com.cz2002.ss10.objects.person;

public class Staff {

	private String name;
	private char gender;
	private int employeeID;
	private String jobTitle;

	/**
	 * 
	 * @param name
	 * @param gender
	 * @param id
	 * @param jobTitle
	 */
	public Staff(String name, char gender, int id, String jobTitle) {
		this.gender = gender;
		this.name = name;
		this.employeeID = id;
		this.jobTitle = jobTitle;
		
	}

	public int getStaffID(){
		return employeeID;
	}

	public String getStaffName(){
		return name;
	}

	public String getGender(){
		return Character.toString(gender);
	}

	public String getJobTitle(){
		return getJobTitle();
	}



}
