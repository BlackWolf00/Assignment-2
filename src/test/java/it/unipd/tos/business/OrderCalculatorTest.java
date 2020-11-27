package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class OrderCalculatorTest {

    private OrderCalculator calculator = new OrderCalculator();
    
    /*Test for simple order*/

    @Test
    public void getPriceBaseOrder_Test() throws TakeAwayBillException
    {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Coppa Nafta", 6.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Pinguino", 8.0D, MenuItem.itemType.Budino));
        itemsOrdered.add(new MenuItem("The al limone", 2.0D, MenuItem.itemType.Bevanda));

        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", Date.valueOf("1996-12-23")));
        assertEquals(16.0D, total, 0.0D);
    }
    
    /*Test for order with more five Ice Cream*/
    
    @Test
    public void moreThanFiveIceCream_Test() throws TakeAwayBillException{
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Coppa Nafta", 6.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Coppa Nafta", 6.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Coppa Nafta", 6.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D ,MenuItem.itemType.Gelato));
        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", Date.valueOf("1996-12-23")));
        assertEquals(45, total, 0.0);
    }
    
    /*Test for order with bill > 50*/
    
    @Test
    public void moreThanFiftyEuros_Test() throws TakeAwayBillException{
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D ,MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Pinguino", 8.0D, MenuItem.itemType.Budino));
        itemsOrdered.add(new MenuItem("Biancaneve", 6.0D, MenuItem.itemType.Budino));
        itemsOrdered.add(new MenuItem("Coca Cola", 2.0D ,MenuItem.itemType.Bevanda));
        itemsOrdered.add(new MenuItem("Coca Cola", 2.0D ,MenuItem.itemType.Bevanda));
        itemsOrdered.add(new MenuItem("Coca Cola", 2.0D ,MenuItem.itemType.Bevanda));
        itemsOrdered.add(new MenuItem("Coca Cola", 2.0D ,MenuItem.itemType.Bevanda));
        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", Date.valueOf("1996-12-23")));
        assertEquals(46.8, total, 0.0);
    }
    
    /*Test for oversized order*/
    
    @Test(expected = TakeAwayBillException.class)
    public void overSizedOrder_Test() throws TakeAwayBillException
    {
        MenuItem item = new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato);
        Stream<MenuItem> gelati = Stream.generate(() -> item);
        List<MenuItem> items = gelati.limit(31).collect(Collectors.toList());

        double result = calculator.getOrderPrice(items, new User("Luca", "Ambrato", Date.valueOf("1996-12-23")));
    }
    
    /*Test for order with commission of 0.50€*/
    
    @Test
    public void orderWithCommission_Test() throws TakeAwayBillException{
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Biancaneve", 6.0D, MenuItem.itemType.Bevanda));
        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", Date.valueOf("1996-12-23")));
        assertEquals(6.5, total,0.0);
    }
} 