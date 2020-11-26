////////////////////////////////////////////////////////////////////
// [Matteo] [Tossuto] [1193493]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class OrderCalculator implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException
    {
        double total = 0.0;
        for(MenuItem item : itemsOrdered)
        {
            total += item.getPrice();
        }
        return total;
    }
}