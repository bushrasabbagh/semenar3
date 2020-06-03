package se.kth.iv1350.model;

import se.kth.iv1350.integration.Goods;
import se.kth.iv1350.integration.ItemDescription;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.util.Amount;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptTest {

    @Test
    public void testToString() {
        Amount price = new Amount(20);
        Amount tax = new Amount(5);
        String itemIdentifier = "Paprika";
        ItemDescription itemDescription = new ItemDescription(price, itemIdentifier, tax);
        Amount quantity = new Amount(1);
        Goods item = new Goods(itemDescription, itemIdentifier, quantity);
        Sale sale = new Sale();
        sale.updateSale(item);
        Receipt receipt = new Receipt(sale);
        LocalDateTime saleTime = LocalDateTime.now();
        String expectedResult = "\n----------RECEIPT----------" +
                "\nSale time: " + saleTime.toLocalDate().toString() +
                "\nItems: " +
                "\nitem name: " + itemIdentifier + "\t" +
                "price: " + price + "\t" +
                "tax amount: " + tax + "\t" +
                " quantity: " + quantity + "\nTotal: " + price + "\nTax: " + tax + "\n" +
                        "\n------------END------------\n";
        String actualResult = receipt.toString();
        assertEquals("Receipt string is not equal to another instance with same state.", expectedResult, actualResult);
    }
}