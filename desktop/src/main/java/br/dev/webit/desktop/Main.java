package br.dev.webit.desktop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        try (final EntityManagerFactory factory = Persistence.createEntityManagerFactory("br.dev.webit.desktop")) {
            try (final EntityManager em = factory.createEntityManager()) {

                System.out.println(em.createQuery("SELECT COUNT(d) FROM Department d", Long.class).getSingleResult());
                System.out.println(em.createQuery("SELECT COUNT(e) FROM Employee e", Long.class).getSingleResult());
            }
        }
    }
}
