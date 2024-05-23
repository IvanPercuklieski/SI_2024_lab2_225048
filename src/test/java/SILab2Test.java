import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Item> items(Item... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void EveryBranchTest(){
        Item item_wrong_barcode = new Item("name", "asdasdas", 123, 0);
        Item item_no_barcode = new Item("name", null, 123, 0);
        Item item_good_item = new Item("name", "123123123", 123, 0);

        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 0));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(item_wrong_barcode), 0));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(item_no_barcode), 0));
        assertTrue(ex.getMessage().contains("No barcode!"));

        assertEquals(true, SILab2.checkCart(items(item_good_item), 200));
        assertEquals(false, SILab2.checkCart(items(item_good_item), 100));
    }

    @Test
    void MultipleConditionsTest(){


        //(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
        // T && T && T
        Item TTT = new Item(null, "023123123", 1000, 0.1f);
        assertEquals(true, SILab2.checkCart(items(TTT), 70));
        assertEquals(false, SILab2.checkCart(items(TTT), 69));
        // F && X && X
        Item FXX = new Item(null, "023123123", 300, 0.1f);
        assertEquals(true, SILab2.checkCart(items(FXX), 30));
        assertEquals(false, SILab2.checkCart(items(FXX), 29));
        // T && F && X
        Item TFX = new Item(null, "023123123", 1000, 0);
        assertEquals(true, SILab2.checkCart(items(TFX), 1000));
        assertEquals(false, SILab2.checkCart(items(TFX), 999));

        // T && T && F
        Item TTF = new Item(null, "123123123", 1000, 0.1f);
        assertEquals(true, SILab2.checkCart(items(TTF), 100));
        assertEquals(false, SILab2.checkCart(items(TTF), 99));
    }

}