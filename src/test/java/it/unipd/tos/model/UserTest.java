package it.unipd.tos.model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class UserTest {

    @Test
    public void User_Test() {
        User user = new User("Luca", "Ambrato", LocalDate.of(1999, 12, 23));
        assertEquals("Luca", user.getName());
        assertEquals("Ambrato", user.getSurname());
        assertEquals(LocalDate.of(1999, 12, 23), user.getDob());
    }
}
