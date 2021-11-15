package com.cz2002.ss10.objects.food;

public class RestaurantItem {
    

    private int restaurantItemID;
    private String restaurantItemName;
    private double restaurantItemPrice;

    /**
     * Restaurant item object constructor.
     * @param restaurantItemID    This restaurant item's ID.
     * @param restaurantItemName  This restaurant item's name.
     * @param restaurantItemPrice This restaurant item's price. 
     */
    RestaurantItem(int restaurantItemID, String restaurantItemName, double restaurantItemPrice) {
        this.restaurantItemID = restaurantItemID;
        this.restaurantItemName = restaurantItemName;
        this.restaurantItemPrice = restaurantItemPrice;
    }

     /**
      * Accessor for the ID of the Restraunt Item.
     * @return restrauntItemID
     */
    public int getId() {
        return restaurantItemID;
    }

    /**
     * Mutator for the ID of the restraunt Item.
     * @param restaurantItemID Id assoiciated with the restraunt item.
     */
    public void setId(int restaurantItemID) {
        this.restaurantItemID = restaurantItemID;
    }

    /**
     * Accessor for Item name.
     * @return item name 
     */
    public String getName() {
        return restaurantItemName;
    }

    /**
     * Mutator for Item name.
     * @param restaurantItemName Name of Item.
     */
    public void setName(String restaurantItemName) {
        this.restaurantItemName = restaurantItemName;
    }

    /**
     * Accessor for Item Price.
     * @return item price
     */
    public double getPrice() {
        return restaurantItemPrice;
    }

    /**
     * Mutator for Item Price
     * @param restaurantItemPrice. Price of Item.
     */
    public void setPrice(double restaurantItemPrice) {
        this.restaurantItemPrice = restaurantItemPrice;
    }
}
