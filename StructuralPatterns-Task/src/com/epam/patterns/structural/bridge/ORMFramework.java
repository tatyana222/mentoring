package com.epam.patterns.structural.bridge;

// Abstraction
public interface ORMFramework {

    void save(Object object);

    Object get(Long id);

    void delete(Long id);
}