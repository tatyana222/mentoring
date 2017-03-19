package com.epam.patterns.structural.bridge.persistence;

// Concrete Implementor
public class MyBatis implements PersistenceAPI {

    @Override
    public void persist(Object object) {
        System.out.println("Saving " + object + " in MyBatis specific way");
    }

    @Override
    public Object find(Long id) {
        System.out.println("Finding object by id " + id + " in MyBatis specific way");
        return new Object();
    }

    @Override
    public Object merge(Object object) {
        System.out.println("Merging " + object + " in MyBatis specific way");
        return new Object();
    }
}