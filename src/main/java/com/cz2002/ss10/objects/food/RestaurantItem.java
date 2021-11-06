package com.cz2002.ss10.objects.food;

public class RestaurantItem {
    private double price;
	private String description;
	private String name;
    private int noOfAvailability;

    RestaurantItem(){
    }

    RestaurantItem(double price, String description, String name, int noOfAvailability){
        this.price = price;
        this.description = description;
        this.name = name;
        this.noOfAvailability = noOfAvailability;
    }


	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
    
}
