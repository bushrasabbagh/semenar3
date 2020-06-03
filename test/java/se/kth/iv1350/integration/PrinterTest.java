package se.kth.iv1350.integration;

import se.kth.iv1350.model.Receipt;
import se.kth.iv1350.model.Sale;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.util.Amount;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PrinterTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    @BeforeAll
    public void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void printReceipt() {
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
                "\n------------END------------\n\n";
        Printer printer = new Printer();
        printer.printReceipt(receipt);
        String actualResult = outContent.toString();
        assertEquals("Output is not equal to string with the same state.", expectedResult, actualResult);
    }
}