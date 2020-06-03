package se.kth.iv1350.integration;

import se.kth.iv1350.model.Sale;
import se.kth.iv1350.util.Amount;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A dummy representing a class that makes calls to a "external inventory system"
 */
public class InventorySystem {
    private HashMap<String, Goods> inventory = new HashMap();

    /**
     * Creates a new instance of a dummy inventory system.
     */
    InventorySystem(){
        addItems();
    }

    /**
     * Updates the amount of items in the inventory.
     *
     * @param sale The information about the sale, contains information about the items.
     */
    public void updateInventory(Sale sale){
        HashMap<String, Goods> items = sale.getItems();
        Set entries = items.entrySet();

        for (Object entry : entries) {
            Goods item = getCurrentItem(entry);

            if (itemExistsInInventory(item)) {
                decreaseQuantityOfItem(item);
            }
        }
    }

    private boolean itemExistsInInventory(Goods item){
        return inventory.containsKey(item.getItemIdentifier());
    }

    private void decreaseQuantityOfItem(Goods item){
        Goods oldItem = inventory.get(item.getItemIdentifier());
        oldItem.decreaseQuantity(item.getQuantity());
        inventory.put(oldItem.getItemIdentifier(), oldItem);
    }

    private Goods getCurrentItem(Object entry){
        Map.Entry mapping = (Map.Entry) entry;
        return (Goods) mapping.getValue();
    }

    private void addItems(){
        inventory.put("Tomat", new Goods(new ItemDescription(new Amount(20), "Tomat", new Amount(10)), "Tomat", new Amount(Integer.MAX_VALUE)));
        inventory.put("Gurka", new Goods(new ItemDescription(new Amount(30), "Gurka", new Amount(15)), "Gurka", new Amount(Integer.MAX_VALUE)));
        inventory.put("Apelsin", new Goods(new ItemDescription(new Amount(42), "Apelsin", new Amount(20)), "Apelsin", new Amount(Integer.MAX_VALUE)));
        inventory.put("Paprika", new Goods(new ItemDescription(new Amount(5), "Paprika", new Amount(2)), "Paprika", new Amount(Integer.MAX_VALUE)));
    }
}
