package br.dev.webit.desktop.model;

import java.util.Collection;
import java.util.Optional;

public interface DepartmentRepository {

    static final String FIND_ALL = "Department.findAll";

    String nextIdentity();

    Optional<Department> find(String code);

    Collection<Department> findAll();

    void put(Department dept);

    void remove(Department dept);

}
