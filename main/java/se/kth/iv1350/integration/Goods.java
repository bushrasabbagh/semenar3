package se.kth.iv1350.integration;

import se.kth.iv1350.util.Amount;

/**
 * Represents an Goods.
 */
public class Goods {
    private ItemDescription itemDescription;
    private String itemIdentifier;
    private Amount quantity;

    /**
     * Creates a new instance, represented as an item.
     *
     * @param itemDescription The description of an item.
     * @param itemIdentifier The identifier of an item.
     * @param quantity The amount if items.
     */
    public Goods(ItemDescription itemDescription, String itemIdentifier, Amount quantity) {
        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.quantity = quantity;
    }

    /**
     * Will increase the quantity of items with the specified {@link Amount}
     *
     * @param otherQuantity The {@link Amount} that will be added to the quantity.
     */
    public void increaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.plus(otherQuantity);
    }

    /**
     * Will decrease the quantity of items with the specified {@link Amount}
     *
     * @param otherQuantity The {@link Amount} that will be subtracted to the quantity.
     */
    public void decreaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.minus(otherQuantity);
    }

    /**
     * Get the value of quantity.
     *
     * @return The value of quantity.
     */
    public Amount getQuantity() {
        return quantity;
    }

    /**
     * Get the value of itemDescription.
     *
     * @return The value of itemDescription
     */
    public ItemDescription getItemDescription() {
        return itemDescription;
    }

    /**
     * Get the value of itemIdentifier.
     *
     * @return The value of itemIdentifier.
     */
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * Turns instance into a <code>String</code>
     *
     * @return The instance as a <code>String</code>
     */
    @Override
    public String toString() {
        String builder = ("item identifier: " + itemIdentifier) +
                "quantity: " + quantity +
                "item description: " + itemDescription.toString();
        return builder;
    }

    /**
     * Two <code>Goods
     *
     * @param obj The <code>Goods<code>Goods
     * @return <code>true<code>Goods<code>Goods<code>false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Goods other = (Goods) obj;
        if (!this.itemDescription.equals(other.itemDescription)){
            return false;
        }
        if (!this.itemIdentifier.equals(other.itemIdentifier)){
            return false;
        }
        return true;
    }
}
