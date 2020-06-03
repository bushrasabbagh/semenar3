package se.kth.iv1350.model;

import se.kth.iv1350.integration.Goods;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Represents a point of sale between a customer and a cashier.
 */
public class Sale {
    private TotalPrice total;
    private HashMap<String, Goods> items = new HashMap<>();

    /**
     * Creates a new instance, represented as a Sale.
     */
    public Sale(){
        this.total = new TotalPrice();
    }

    /**
     * Gets the value of total.
     *
     * @return The value of total.
     */
    public TotalPrice getTotal() {
        return total;
    }

    /**
     * Gets the HashMap items.
     *
     * @return The HashMap items.
     */
    public HashMap<String, Goods> getItems(){
        return items;
    }

    /**
     * Updates the current sale. Updates how many items and the running total.
     * Can't take null items.
     *
     * @param item The item that will be added to the sale.
     * @return  The itemDescription as a string.
     */
    public String updateSale(Goods item){
        if (itemListContains(item)) {
            updateItemQuantityAndTotal(item);
        } else {
            addItemAndUpdateTotal(item);
        }
        return item.getItemDescription().toString();
    }

    private boolean itemListContains(Goods item){
        return items.containsKey(item.getItemIdentifier());
    }

    private void updateItemQuantityAndTotal(Goods item){
        Goods oldItem = items.get(item.getItemIdentifier());
        oldItem.increaseQuantity(item.getQuantity());
        items.put(oldItem.getItemIdentifier(), oldItem);
        total.updateTotal(item);
    }

    private void addItemAndUpdateTotal(Goods item){
        items.put(item.getItemIdentifier(), item);
        total.updateTotal(item);
    }

    /**
     * Makes the instance into to a <code>String</code>
     *
     * @return The instance as a <code>String</code>
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator entriesIterator = getEntries();

        while(entriesIterator.hasNext()) {
            Goods item = getCurrentItem(entriesIterator);
            builder.append(item.getItemDescription().toString());
            addNewLine(builder, " quantity: " + item.getQuantity().toString());
        }

        addNewLine(builder, "Total: " + total.getTotal().toString());
        addNewLine(builder, "Tax: " + total.getTotalTax());
        return builder.toString();
    }

    private Iterator getEntries(){
        Set entries = items.entrySet();
        return entries.iterator();
    }

    private Goods getCurrentItem(Iterator entriesIterator){
        Map.Entry mapping = (Map.Entry) entriesIterator.next();
        return (Goods) mapping.getValue();
    }

    private void addNewLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }
}
