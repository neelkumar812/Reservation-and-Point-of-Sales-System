package com.cz2002.ss10.objects.person;

/**
 * Class Staff
 * @author Neel Kumar 
 * @version 1.0
 * @since 2021-11-06
 */
public class Staff {

	private String name;
	private String gender;
	private String jobTitle;
	private int employeeID;
	

	/**
	 * 
	 * @param name
	 * @param gender
	 * @param id
	 * @param jobTitle
	 */
	public Staff(String name, String gender, int id, String jobTitle) {
		this.gender = gender;
		this.name = name;
		this.employeeID = id;
		this.jobTitle = jobTitle;
	}
	public int getStaffID(){
		return this.employeeID;
	}
	public String getStaffName(){
		return this.name;
	}
	public String getGender(){
		return this.gender;
	}
	public String getJobTitle(){
		return this.jobTitle;
	}
	/**
	 * @param employeeID
	 */
	public void setStaffID(int employeeID){
		this.employeeID = employeeID;
	}
	/**
	 * @param gender
	 */
	public void setGender(String gender){
		this.gender = gender;
	}
	/**
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;
	}
	/**
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
}
