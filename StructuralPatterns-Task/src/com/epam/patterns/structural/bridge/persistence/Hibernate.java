package com.epam.patterns.structural.bridge.persistence;

// Concrete Implementor
public class Hibernate implements PersistenceAPI {

    @Override
    public void persist(Object object) {
        System.out.println("Saving " + object + " in Hibernate specific way");
    }

    @Override
    public Object find(Long id) {
        System.out.println("Finding object by id " + id + " in Hibernate specific way");
        return new Object();
    }

    @Override
    public Object merge(Object object) {
        System.out.println("Merging " + object + " in Hibernate specific way");
        return new Object();
    }
}