package com.cz2002.ss10.objects.food;

public class RestaurantItem {
    

    private int restaurantItemID;
    private String restaurantItemName;
    private double restaurantItemPrice;

    /**
     * restaurant item object constructor.
     *
     * @param restaurantItemID    This restaurant item's ID.
     * @param restaurantItemName  This restaurant item's name.
     * @param restaurantItemPrice This restaurant item's price.
     * 
     */
    RestaurantItem(int restaurantItemID, String restaurantItemName, double restaurantItemPrice) {
        this.restaurantItemID = restaurantItemID;
        this.restaurantItemName = restaurantItemName;
        this.restaurantItemPrice = restaurantItemPrice;
    }

     /**
     * Accessors and Mutators 
     */

     /**
     * @return restrauntItemID
     */
    public int getId() {
        return restaurantItemID;
    }

    /**
     * @param restaurantItemID 
     */
    public void setId(int restaurantItemID) {
        this.restaurantItemID = restaurantItemID;
    }

    /**
     * @return item name 
     */
    public String getName() {
        return restaurantItemName;
    }

    /**
     * @param restaurantItemName 
     */
    public void setName(String restaurantItemName) {
        this.restaurantItemName = restaurantItemName;
    }

    /**
     * @return item price
     */
    public double getPrice() {
        return restaurantItemPrice;
    }

    /**
     * @param restaurantItemPrice.
     */
    public void setPrice(double restaurantItemPrice) {
        this.restaurantItemPrice = restaurantItemPrice;
    }
}
