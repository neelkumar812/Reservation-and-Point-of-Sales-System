package com.cz2002.ss10.objects.food;

import java.util.*;

import com.cz2002.ss10.RestaurantApp;

/**
 * PromoItem Class
 *
 * @author Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

 public class PromoItem extends RestaurantItem{

	private ArrayList<MenuItem> PromoItems;
    private int promoMain;
    private int promoDessert;
    private int promoDrink;
    private int promoAppetiser;

	/**
     * PromoItem Object Constructor
     *
     * @param promoID         
     * @param promoName       
     * @param promoPrice      
     * @param promoMain       
     * @param promoAppetiser  
     * @param promoDessert    
     * @param promoDrink      
     */
    public PromoItem(int promoID, String promoName, double promoPrice, int promoMain, int promoAppetiser, int promoDessert, int promoDrink) {
        
		super(promoID, promoName, promoPrice); //called from parent
        this.promoMain = promoMain;
        this.promoAppetiser = promoAppetiser;
        this.promoDessert = promoDessert;
        this.promoDrink = promoDrink;
    }

    /**
	 * Accessors and Mutators
	 */

	public ArrayList<MenuItem> getPromoItems() {
		return PromoItems;
	}

	/**
	 * @param PromoItems
	 */
	public void setPromoItems(ArrayList<MenuItem> PromoItems) {
		this.PromoItems = PromoItems;
	}

	/**
     *
     * @return Main Item in the promotion.
     */
    public int getPromoMain() {
        return promoMain;
    }

    /**
     * @param promoMain
     */
    public void setPromoMain(int promoMain) {
        this.promoMain = promoMain;
    }

    /**
     * @return The Appetiser in the promotion item.
     */
    public int getPromoAppetiser() {
        return promoAppetiser;
    }

    /**
     * @param promoAppetiser
     */
    public void setPromoAppetiser(int promoAppetiser) {
        this.promoAppetiser = promoAppetiser;
    }

    /**
     * @return Dessert in the promotion item.
     */
    public int getPromoDessert() {
        return promoDessert;
    }

    /**

     * @param promoDessert
     */
    public void setPromoDessert(int promoDessert) {
        this.promoDessert = promoDessert;
    }

    /**
     * @return Drink in the promoItem.
     */
    public int getPromoDrink() {
        return promoDrink;
    }

    /**
     * @param promoDrink
     */
    public void setPromoDrink(int promoDrink) {
        this.promoDrink = promoDrink;
    }

    /**
     * Finds and returns promotion object of desired ID
     *
     * @param promoID
     * @return promotionObject
     */

    public static PromoItem retrievePromotion(int promoID) {
        for (int i = 0; i < (RestaurantApp.promotionItems.size()); i++) {
            PromoItem promotionObject = RestaurantApp.promotionItems.get(i);
            if (promoID == promotionObject.getId()) {
                return promotionObject;
            }
        }
        return null; 
    }


}
