////////////////////////////////////////////////////////////////////
// [Matteo] [Tossuto] [1193493]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import java.time.LocalDate;

public class User {

    private final String name, surname;
    private final LocalDate dob;

    public User(String name, String surname, LocalDate dob) {
        
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

    public LocalDate getDob() {
        return dob;
    }
}
