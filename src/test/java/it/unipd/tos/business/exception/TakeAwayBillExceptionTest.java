package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TakeAwayBillExceptionTest {

    @Test
    public void Constructor_Test()
    {
        TakeAwayBillException exc = new TakeAwayBillException("Ordine troppo grande");
        assertEquals("Ordine troppo grande", exc.getMessage());
    }
} 