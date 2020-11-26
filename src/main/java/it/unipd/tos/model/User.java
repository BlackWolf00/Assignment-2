////////////////////////////////////////////////////////////////////
// [Matteo] [Tossuto] [1193493]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import java.util.Date;

public class User {

    private final String name, surname;
    private final Date dob;

    public User(String name, String surname, Date dob) {
        
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }
}
