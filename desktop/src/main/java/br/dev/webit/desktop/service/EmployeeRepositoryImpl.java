package br.dev.webit.desktop.service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import br.dev.webit.desktop.model.Employee;
import br.dev.webit.desktop.model.EmployeeRepository;
import jakarta.persistence.EntityManager;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager em;

    public EmployeeRepositoryImpl(EntityManager em) {
        this.em = Objects.requireNonNull(em);
    }

    @Override
    public Optional<Employee> find(Integer id) {
        return Optional.ofNullable(em.find(Employee.class, id));
    }

    @Override
    public Collection<Employee> findAll() {
        return em.createNamedQuery(FIND_ALL, Employee.class).getResultList();
    }

    @Override
    public void put(Employee emp) {
        em.persist(emp);
    }

    @Override
    public void remove(Employee emp) {
        em.remove(emp);
    }
}
