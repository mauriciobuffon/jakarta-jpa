package br.dev.webit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.dev.webit.desktop.model.DepartmentRepository;
import br.dev.webit.desktop.service.DepartmentRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DepartmentRepositoryTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private DepartmentRepository repository;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("br.dev.webit.desktop");
        em = emf.createEntityManager();
    }

    @AfterAll
    static void afterAll() {
        em.close();
        emf.close();
    }

    @BeforeEach
    void beforeEach() {
        repository = new DepartmentRepositoryImpl(em);
    }

    @AfterEach
    void afterEach() {
    }

    @Test
    void totalNumberOfDepartments() {
        final long count = em.createQuery("SELECT COUNT(d) FROM Department d", Long.class).getSingleResult();
        final long size = repository.findAll().size();
        assertEquals(count, size);
    }
}
