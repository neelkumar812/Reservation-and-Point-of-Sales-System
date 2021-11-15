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
	 * Accessors
     * @return PromoItems 
	 */

	public ArrayList<MenuItem> getPromoItems() {
		return PromoItems;
	}

	/**
     * 
	 * @param PromoItems
	 */
	public void setPromoItems(ArrayList<MenuItem> PromoItems) {
		this.PromoItems = PromoItems;
	}

	/**
     * Accessor for the Main in the promomtion.
     * @return Main Item in the promotion.
     */
    public int getPromoMain() {
        return promoMain;
    }

    /**
     * Mutator for the Main in the promotion.
     * @param promoMain
     */
    public void setPromoMain(int promoMain) {
        this.promoMain = promoMain;
    }

    /**
     * Accessor for the Appetiser in the promotion.
     * @return The Appetiser in the promotion item.
     */
    public int getPromoAppetiser() {
        return promoAppetiser;
    }

    /**
     * Mutator for the Appetiser in the promotion.
     * @param promoAppetiser Appetiser in the promotion.
     */
    public void setPromoAppetiser(int promoAppetiser) {
        this.promoAppetiser = promoAppetiser;
    }

    /**
     * Accessor for Dessert in the promotion.
     * @return Dessert in the promotion item.
     */
    public int getPromoDessert() {
        return promoDessert;
    }

    /**
     * Mutator for the Dessert in the promotion.
     * @param promoDessert Dessert in the promotion.
     */
    public void setPromoDessert(int promoDessert) {
        this.promoDessert = promoDessert;
    }

    /**
     * Accessor for the Drink in the promotion. 
     * @return Drink in the promoItem.
     */
    public int getPromoDrink() {
        return promoDrink;
    }

    /**
     * Mutator for the Drink in the promotion.
     * @param promoDrink Drink in the promotion.
     */
    public void setPromoDrink(int promoDrink) {
        this.promoDrink = promoDrink;
    }

    /**
     * Finds and returns promotion object of desired ID
     * @param promoID Id associated with the promotion.
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
