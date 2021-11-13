package com.cz2002.ss10.objects.food;

public class RestaurantItem {
    
    /**
     * The ID of the restaurant item.
     */
    private int restaurantItemID;
    /**
     * The name of the restaurant item.
     */
    private String restaurantItemName;
    /**
     * The price of the restaurant item.
     */
    private double restaurantItemPrice;

    // /**
    //  * The stock of the restaurant item.
    //  */
    // private int restaurantItemStock;

    /**
     * Constructor to pass in all required parameters for a restaurant item.
     *
     * @param restaurantItemID    This restaurant item's ID.
     * @param restaurantItemName  This restaurant item's name.
     * @param restaurantItemPrice This restaurant item's price.
    //  * @param restaurantItemStock This restaurant item's stocks.
     */
    RestaurantItem(int restaurantItemID, String restaurantItemName, double restaurantItemPrice) {
        this.restaurantItemID = restaurantItemID;
        this.restaurantItemName = restaurantItemName;
        this.restaurantItemPrice = restaurantItemPrice;
        // this.restaurantItemStock = restaurantItemStock;

    }

     /**
     * Accessor for Restaurant Item type.
     *
     * @return Gets the restaurant item's ID.
     */
    public int getId() {
        return restaurantItemID;
    }

    /**
     * Mutator for Restaurant Item ID.
     *
     * @param restaurantItemID Sets the restaurant item's ID.
     */
    public void setId(int restaurantItemID) {
        this.restaurantItemID = restaurantItemID;
    }

    /**
     * Accessor for Restaurant Item name.
     *
     * @return Gets the restaurant item's name.
     */
    public String getName() {
        return restaurantItemName;
    }

    /**
     * Mutator for Restaurant Item name.
     *
     * @param restaurantItemName Sets the restaurant item's name.
     */
    public void setName(String restaurantItemName) {
        this.restaurantItemName = restaurantItemName;
    }

    /**
     * Accessor for Restaurant Item price.
     *
     * @return Gets the restaurant item's price.
     */
    public double getPrice() {
        return restaurantItemPrice;
    }

    /**
     * Mutator for Restaurant Item price.
     *
     * @param restaurantItemPrice Sets the restaurant item's price.
     */
    public void setPrice(double restaurantItemPrice) {
        this.restaurantItemPrice = restaurantItemPrice;
    }

    // /**
    //  * Accessor for Restaurant Item type.
    //  *
    //  * @return Gets the restaurant item's Stock.
    //  */
    // public int getStock() {
    //     return restaurantItemStock;
    // }

    // /**
    //  * Mutator for Restaurant Item Stock.
    //  *
    //  * @param restaurantItemStock Sets the restaurant item's ID.
    //  */
    // public void setStock(int restaurantItemStock) {
    //     this.restaurantItemStock = restaurantItemStock;
    // }

}
