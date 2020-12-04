package it.unipd.tos.business;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class OrderCalculatorTest {

    private OrderCalculator calculator = new OrderCalculator();

    /* Test for simple order */

    @Test
    public void getPriceBaseOrder_Test() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Coppa Nafta", 6.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Pinguino", 8.0D, MenuItem.itemType.Budino));
        itemsOrdered.add(new MenuItem("The al limone", 2.0D, MenuItem.itemType.Bevanda));

        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", LocalDate.of(1996, 12, 23)),
                LocalTime.of(1, 1, 1));
        assertEquals(16.0D, total, 0.0D);
    }

    /* Test for order with more five Ice Cream */

    @Test
    public void moreThanFiveIceCream_Test() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Coppa Nafta", 6.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Coppa Nafta", 6.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Coppa Nafta", 6.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", LocalDate.of(1996, 12, 23)),
                LocalTime.of(1, 1, 1));
        assertEquals(45, total, 0.0);
    }

    /* Test for order with bill > 50 */

    @Test
    public void moreThanFiftyEuros_Test() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato));
        itemsOrdered.add(new MenuItem("Pinguino", 8.0D, MenuItem.itemType.Budino));
        itemsOrdered.add(new MenuItem("Biancaneve", 6.0D, MenuItem.itemType.Budino));
        itemsOrdered.add(new MenuItem("Coca Cola", 2.0D, MenuItem.itemType.Bevanda));
        itemsOrdered.add(new MenuItem("Coca Cola", 2.0D, MenuItem.itemType.Bevanda));
        itemsOrdered.add(new MenuItem("Coca Cola", 2.0D, MenuItem.itemType.Bevanda));
        itemsOrdered.add(new MenuItem("Coca Cola", 2.0D, MenuItem.itemType.Bevanda));
        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", LocalDate.of(1996, 12, 23)),
                LocalTime.of(1, 1, 1));
        assertEquals(46.8, total, 0.0);
    }

    /* Test for oversized order */

    @Test(expected = TakeAwayBillException.class)
    public void overSizedOrder_Test() throws TakeAwayBillException {
        MenuItem item = new MenuItem("Banana Split", 10.0D, MenuItem.itemType.Gelato);
        Stream<MenuItem> gelati = Stream.generate(() -> item);
        List<MenuItem> items = gelati.limit(31).collect(Collectors.toList());

        double total = calculator.getOrderPrice(items, new User("Luca", "Ambrato", LocalDate.of(1996, 12, 23)),
                LocalTime.of(1, 1, 1));
    }

    /* Test for order with commission of 0.50€ */

    @Test
    public void orderWithCommission_Test() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Biancaneve", 6.0D, MenuItem.itemType.Budino));
        double total = calculator.getOrderPrice(itemsOrdered, new User("Luca", "Ambrato", LocalDate.of(1996, 12, 23)),
                LocalTime.of(1, 1, 1));
        assertEquals(6.5, total, 0.0);
    }

    /* Test for free order */

    @Test
    public void freeOrder() throws TakeAwayBillException {
        List<MenuItem> itemsOrdered = new ArrayList<>();
        itemsOrdered.add(new MenuItem("Biancaneve", 6.0D, MenuItem.itemType.Budino));
        List<User> utenti = Arrays.asList(
                new User("Paolo", "1", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "2", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "3", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "4", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "5", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "6", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "7", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "8", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "9", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "11", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "12", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "13", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "14", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "15", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "16", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "17", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "18", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "18", LocalDate.of(2016, 04, 13)),
                new User("Paolo", "19", LocalDate.of(2016, 04, 13)),
                new User("Luca", "1", LocalDate.of(1995, 10, 04)),
                new User("Luca", "2", LocalDate.of(1995, 10, 04)),
                new User("Luca", "3", LocalDate.of(1995, 10, 04)),
                new User("Luca", "4", LocalDate.of(1995, 10, 04)),
                new User("Luca", "5", LocalDate.of(1995, 10, 04)),
                new User("Luca", "6", LocalDate.of(1995, 10, 04)));

        int freeOrder = 0;
        for (User user : utenti) {
            double total = calculator.getOrderPrice(itemsOrdered, user, LocalTime.of(18, 0, 0));
            if (ChronoUnit.YEARS.between(user.getDob(), LocalDate.now()) < 18 && Math.random() < 0.5D && freeOrder < 10)
                freeOrder++;
            assertTrue(total == 6.5D || total == 0);
        }
        assertTrue(freeOrder <= 10);

    }
}