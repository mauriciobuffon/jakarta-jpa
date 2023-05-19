package br.dev.webit.desktop.service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import br.dev.webit.desktop.model.Department;
import br.dev.webit.desktop.model.DepartmentRepository;
import jakarta.persistence.EntityManager;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private EntityManager em;

    public DepartmentRepositoryImpl(EntityManager em) {
        this.em = Objects.requireNonNull(em);
    }

    @Override
    public String nextIdentity() {
        StringBuilder code = new StringBuilder();

        final char capitalLetter = (char) (Math.floor(Math.random() * (0x5b - 0x41)) + 0x41);
        code.append(capitalLetter);

        for (int i = 0; i < 3; i++) {
            final char digit = (char) (Math.floor(Math.random() * (0x3a - 0x30)) + 0x30);
            code.append(digit);
        }

        return code.toString();
    }

    @Override
    public Optional<Department> find(String code) {
        return Optional.ofNullable(em.find(Department.class, code));
    }

    @Override
    public Collection<Department> findAll() {
        return em.createNamedQuery(FIND_ALL, Department.class).getResultList();
    }

    @Override
    public void put(Department dept) {
        em.persist(dept);
    }

    @Override
    public void remove(Department dept) {
        em.remove(dept);
    }
}
