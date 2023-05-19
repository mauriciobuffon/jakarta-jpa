package br.dev.webit.desktop.model;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeRepository {

    static final String FIND_ALL = "Employee.findAll";

    Optional<Employee> find(Integer id);

    Collection<Employee> findAll();

    void put(Employee emp);

    void remove(Employee emp);

}
