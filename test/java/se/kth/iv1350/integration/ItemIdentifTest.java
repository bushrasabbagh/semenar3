package se.kth.iv1350.integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemIdentifTest {

    @Test
    public void testItemExists() {
        String tomat = "Paprika";
        boolean expectedResult = true;
        ItemIdentif ItemIdentif = new ItemIdentif();
        boolean actualResult = ItemIdentif.itemExists(tomat);
        assertEquals(expectedResult, actualResult);
        fail("The expected item didn't exist in database.");

// assertEquals("The expected item didn't exist in database.", expectedResult, actualResult);
    }

}