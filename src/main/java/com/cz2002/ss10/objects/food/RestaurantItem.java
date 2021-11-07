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

    /**
     * Constructor to pass in all required parameters for a restaurant item.
     *
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

    /**
     * A method to read from a CSV string to convert to an object instance.
     * This needs to be overridden if CSV data must be retrieved from a file.
     *
     * @param csv A string array of the CSV file.
     */
// To DO

    /**
     * A method to convert to CSV.
     * This needs to be overridden if files need to be saved to CSV.
     *
     * @return A String array of the CSV file.
     */
//To Do


}
