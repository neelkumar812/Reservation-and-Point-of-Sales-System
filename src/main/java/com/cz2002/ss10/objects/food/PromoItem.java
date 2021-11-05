package com.cz2002.ss10.objects.food;

import java.util.*;

public class PromoItem {

	private ArrayList<MenuItem> promotionItems;
	private double price;
	private String description;
	private String name;

	public ArrayList<MenuItem> getPromotionItems() {
		return this.promotionItems;
	}

	/**
	 * 
	 * @param promotionItem
	 */
	public void addPromotionItem(MenuItem promotionItem) {
		// TODO - implement PromotionSet.addPromotionItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param promotionItems
	 */
	public void setPromotionItems(ArrayList<MenuItem> promotionItems) {
		this.promotionItems = promotionItems;
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