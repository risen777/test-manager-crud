package ru.shumov.tm.repository;

import javax.persistence.EntityManagerFactory;

public abstract class AbstractRepository {

    protected EntityManagerFactory emf;

    public AbstractRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public AbstractRepository() {

    }
}
