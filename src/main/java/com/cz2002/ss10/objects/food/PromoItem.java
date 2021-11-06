package com.cz2002.ss10.objects.food;

import java.util.*;

public class PromoItem extends RestaurantItem {

	private ArrayList<MenuItem> promotionItems;

	public ArrayList<MenuItem> getPromotionItems() {
		return this.promotionItems;
	}

	PromoItem(){
		super();
	}

	PromoItem(double price, String description, String name, int noOfAvailability, ArrayList<MenuItem> promotionItems){
		super(price, description, name, noOfAvailability);
		this.promotionItems = promotionItems;
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

}