package entity;

import javax.persistence.Entity;

@Entity
@javax.persistence.Table(name = "employee")
public class Employee extends Table {

    public Employee() {
    }

    public Employee(String firstName, String lastName, String company) {
        super(firstName, lastName, company);
    }
}
