package com.epam.patterns.structural.bridge.persistence;

// Implementor interface
public interface PersistenceAPI {

    void persist(Object object);

    Object find(Long id);

    // We added new method that should be hidden from clients for now
    // We do not need to change client code when we add a method this way
    Object merge(Object object);
}