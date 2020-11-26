package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

public class UserTest {

    @Test
    public void User_Test()
    {
        User user = new User("Luca", "Ambrato", Date.valueOf("1999-12-23"));
        assertEquals("Luca", user.getName());
        assertEquals("Ambrato", user.getSurname());
        assertEquals(Date.valueOf("1999-12-23"), user.getDob());
    }
} 