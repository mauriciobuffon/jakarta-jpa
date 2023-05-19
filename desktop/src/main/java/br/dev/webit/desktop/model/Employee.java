package br.dev.webit.desktop.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate hireDate;
    private Map<LocalDate, String> titles;
    private LocalDateTime version;

    protected Employee() {
        this.titles = new HashMap<>();
    }

    public Employee(String firstName, String lastName, LocalDate hireDate) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Map<LocalDate, String> getTitles() {
        return Collections.unmodifiableMap(titles);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
