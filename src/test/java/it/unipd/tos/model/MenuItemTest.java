package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuItemTest {

    @Test
    public void MenuItem_Test() {
        MenuItem order = new MenuItem("Pinguino", 8.0D, MenuItem.itemType.Budino);
        assertEquals("Pinguino", order.getName());
        assertEquals(8.0D, order.getPrice(), 0.0);
        assertEquals(MenuItem.itemType.Budino, order.getItemType());
    }
}