package it.unipd.tos.business;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import static org.junit.Assert.assertEquals;

public class OrderCalculatorTest {

    private OrderCalculator calculator = new OrderCalculator();

    @Test
    public void getPriceBaseOrder_Test() throws TakeAwayBillException
    {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Coppa Nafta", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Pinguino", 8.0D, MenuItem.itemType.Budino));
        itemsOrdered.add(new MenuItem("Te al limone", 2.0D, MenuItem.itemType.Bevanda));

        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", Date.valueOf("1996-12-23")));
        assertEquals(20.0D, total, 0.0D);
    }
} 