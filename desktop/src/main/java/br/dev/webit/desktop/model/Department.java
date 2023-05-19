package br.dev.webit.desktop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Department {

    private String code;
    private String name;
    private List<Employee> employees;
    private Employee manager;
    private LocalDateTime version;

    protected Department() {
        this.employees = new ArrayList<>();
    }

    public Department(String code, String name) {
        this();
        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public Employee getManager() {
        return manager;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
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
        final Department other = (Department) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }
}
