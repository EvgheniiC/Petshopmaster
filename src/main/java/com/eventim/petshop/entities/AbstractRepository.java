package com.eventim.petshop.entities;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

abstract class AbstractRepository {

    @PersistenceContext(name = "petshop_db")
    EntityManager entityManager;

    public <E> Query getQuery(Class<E> clazz, String namedQueryName, Object[] parameter) {
        Query namedQuery = entityManager.createNamedQuery(namedQueryName, clazz);
        for (int index = 0; index < parameter.length; index++) {
            namedQuery.setParameter(index + 1, parameter[index]);
        }
        return namedQuery;
    }

    <E> E find(Class<E> clazz, String namedQueryName, Object... parameter) {
        Query namedQuery = getQuery(clazz, namedQueryName, parameter);
        return (E) namedQuery.getSingleResult();
    }


    <E> List<E> findAll(Class<E> clazz, String namedQueryName, Object... parameter) {
        Query namedQuery = getQuery(clazz, namedQueryName, parameter);
        return namedQuery.getResultList();
    }

}


