package se.kth.iv1350.integration;

import se.kth.iv1350.util.Amount;

import java.util.HashMap;

/**
 * Represents a dummy item database.
 */
public class ItemIdentif {
    private HashMap<String, ItemDescription> itemList = new HashMap<>();

    /**
     *  Creates a instance of a dummy item database.
     */
    ItemIdentif(){
        addItems();
    }

    /**
     *  Checks if the searched itemIdentifier exists in the database.
     *
     * @param itemIdentifier The looked item.
     * @return If item exists <code>true</code> else <code>false</code>
     */
    public boolean itemExists(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    /**
     * Gets the item description of the specified itemIdentifier.
     * Returns an item with the specified quantity.
     *
     * @param itemIdentifier The identifier of an item.
     * @param quantity The amount of items.
     * @return An item with it's itemDescription and quantity or null if the identifier didn't exist..
     */
    public Goods getItem(String itemIdentifier, Amount quantity){
        if (itemExists(itemIdentifier)){
            return new Goods(itemList.get(itemIdentifier), itemIdentifier, quantity);
        }
        return null;
    }

    private void addItems(){
        itemList.put("Tomat", new ItemDescription(new Amount(20), "Tomat", new Amount(10)));
        itemList.put("Gurka", new ItemDescription(new Amount(30), "Gurka", new Amount(15)));
        itemList.put("Apelsin", new ItemDescription(new Amount(42), "Apelsin", new Amount(20)));
        itemList.put("Paprika", new ItemDescription(new Amount(5), "Paprika", new Amount(2)));
    }
}
