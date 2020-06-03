package se.kth.iv1350.integration;

/**
 * Represents a creator that consists of different catalogs.
 */
public class CatalogCreator {
    private ItemIdentif itemCatalog;

    /**
     * Creates a new instance
     */
    public CatalogCreator(){
        itemCatalog = new ItemIdentif();
    }

    /**
     * Gets the value of itemCatalog.
     * @return  The value of itemCatalog.
     */
    public ItemIdentif getItemCatalog() {
        return itemCatalog;
    }
}
