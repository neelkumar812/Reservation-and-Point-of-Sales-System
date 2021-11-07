package com.cz2002.ss10.objects.food;

import java.util.*;

/**
 * PromoItem Class
 *
 * @author Sneha Ravisankar
 * @version 1.0
 * @since 2021-11-06
 */

 public class PromoItem extends RestaurantItem{

	private ArrayList<MenuItem> PromoItems;
	/**
     * The ID of the Promo item's components.
     */
    private int promoMain;
    private int promoDessert;
    private int promoDrink;

	/**
     * Constructor to pass in all attributes
     *
     * @param promoID      This Promo item's ID.
     * @param promoName    This Promo item's name.
     * @param promoPrice   This Promo item's price.
     * @param promoMain    This Promo item's main ID.
     * @param promoDessert This Promo item's dessert ID.
     * @param promoDrink   This Promo item's drink ID.
     */
    public PromoItem(int promoID, String promoName, double promoPrice, int promoMain, int promoDessert, int promoDrink) {
        
		super(promoID, promoName, promoPrice); //called from parent
        this.promoMain = promoMain;
        this.promoDessert = promoDessert;
        this.promoDrink = promoDrink;
    }

	public ArrayList<MenuItem> getPromoItems() {

		//Is this how an Array List Returns? 
		return PromoItems;
	}

	/**
	 * 
	 * @param PromoItem
	 */
	public void addPromoItem(MenuItem PromoItem) {
		// TODO - implement PromoSet.addPromoItem

		// How to add items to an Array List


		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param PromoItems
	 */
	public void setPromoItems(ArrayList<MenuItem> PromoItems) {
		this.PromoItems = PromoItems;
	}

	/**
     * Accessor for Promotion item's main.
     *
     * @return Gets the Promotion item's main.
     */
    public int getPromoMain() {
        return promoMain;
    }

    /**
     * Mutator for Promotion item's main.
     *
     * @param promoMain Sets the Promotion item's main.
     */
    public void setPromoMain(int promoMain) {
        this.promoMain = promoMain;
    }

    /**
     * Accessor for Promotion item's dessert.
     *
     * @return Gets the Promotion item's dessert.
     */
    public int getPromoDessert() {
        return promoDessert;
    }

    /**
     * Mutator for Promotion item's main.
     *
     * @param promoDessert Sets the Promotion item's dessert.
     */
    public void setPromoDessert(int promoDessert) {
        this.promoDessert = promoDessert;
    }

    /**
     * Accessor for Promotion item's drink.
     *
     * @return Gets the Promotion item's drink.
     */
    public int getPromoDrink() {
        return promoDrink;
    }

    /**
     * Mutator for Promotion item's drink.
     *
     * @param promoDrink Sets the Promotion item's drink.
     */
    public void setPromoDrink(int promoDrink) {
        this.promoDrink = promoDrink;
    }


}
