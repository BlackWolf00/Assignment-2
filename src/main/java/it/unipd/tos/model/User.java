////////////////////////////////////////////////////////////////////
// [Matteo] [Tossuto] [1193493]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class User {

    private final String name, surname;
    private final LocalDate dob;
    private final LocalTime dl;

    public User(String name, String surname, LocalDate dob, LocalTime dl) {

        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.dl = dl;
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

    public LocalTime getDl() {
        return dl;
    }
}
