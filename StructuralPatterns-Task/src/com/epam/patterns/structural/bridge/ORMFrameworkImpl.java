package com.epam.patterns.structural.bridge;

import com.epam.patterns.structural.bridge.persistence.PersistenceAPI;

// Refined abstraction
public class ORMFrameworkImpl implements ORMFramework {

    // Here we store reference to Implementor
    // This way we decouple abstraction from implementation and they can vary independently
    private PersistenceAPI persistenceAPI;

    public ORMFrameworkImpl(PersistenceAPI persistenceAPI) {
        this.persistenceAPI = persistenceAPI;
    }

    @Override
    public void save(Object object) {
        persistenceAPI.persist(object);
    }

    @Override
    public Object get(Long id) {
        return persistenceAPI.find(id);
    }

    @Override
    public void delete(Long id) {
        // We changed the abstraction (ORMFramework) by adding this method but we do not need to change implementation (PersistenceAPI)
        // Clients can use this method
        System.out.println("Deleting something");
    }
}