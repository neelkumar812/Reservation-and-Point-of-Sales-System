package com.cz2002.ss10.objects.food;

public class orderItem {

    public enum OrderItemType {MENU, PROMO}
    private OrderItemType orderItemType;
    private int orderItemId;
    private int quantity;
    private double itemTotalCost;


    /**
     * Constructor for orderItem
     *
     * @param itemId 
     * @param quantity of item
     * @param itemType 
     */
    public orderItem(int itemId, int quantity, OrderItemType type) {
        this.orderItemId = itemId;
        this.quantity = quantity;
        this.orderItemType = type;
        this.calculateTotal();
    }

    /**
    * Method to get Promotion Object
     */
    private PromoItem getPromo() {
        if (this.orderItemType != OrderItemType.PROMO) 
        return null;

        return PromoItem.retrievePromotion(this.orderItemId);
    }

    /**
     * Method to get MenuItem Object
     *
     */
    private MenuItem getMenuItem() {
        if (this.orderItemType != OrderItemType.MENU) 
        return null; 

        return MenuItem.retrieveMenuItem(this.orderItemId);
    }

    /**
     * Checks If prmomotion
     *
     * @return true/false based on if Item added is of type promotion or not
     */
    public boolean isPromotion() {
        return this.orderItemType == OrderItemType.PROMO;
    }

    /**
     * Gets the object from this entry
     *
     * @return promo object or a menu object
     */
    public RestaurantItem getItem() {
        if (this.isPromotion()) return getPromo();
        return getMenuItem();
    }

    /**
     * Accessors and Mutators
     */

    /**
     *
     * @return Quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity Number of Items
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Total Cost
     */
    public double getitemTotalCost() {
        return itemTotalCost;
    }

    /**
     * itemTotalCost Method Implementation
     */
    public void calculateTotal() {
        Object orderItem = this.getItem();
        if (orderItem instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) orderItem;
            this.itemTotalCost = menuItem.getPrice() * this.quantity;
        } else if (orderItem instanceof PromoItem) {
            PromoItem promoItem = (PromoItem) orderItem;
            this.itemTotalCost = promoItem.getPrice() * this.quantity;
        }
    }
}
