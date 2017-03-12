package com.epam.patterns.structural;

import com.epam.patterns.structural.bridge.ORMFramework;
import com.epam.patterns.structural.bridge.ORMFrameworkImpl;
import com.epam.patterns.structural.bridge.persistence.Hibernate;
import com.epam.patterns.structural.bridge.persistence.MyBatis;
import com.epam.patterns.structural.bridge.persistence.PersistenceAPI;

public final class PersistenceProvider {

    public PersistenceProvider() {
    }

    public static ORMFramework getProvider(String provider) {
        System.out.println("Bridge example");

        ORMFramework ormFramework;
        switch (provider) {
            case "hibernate":
                ormFramework = prepareHibernatePersistenceAPI();
                break;
            case "myBatis":
                PersistenceAPI myBatisPersistenceAPI = new MyBatis();
                ormFramework = new ORMFrameworkImpl(myBatisPersistenceAPI);
                break;
            default:
                System.out.println("Unknown persistence API. Hibernate will be used by default.");
                ormFramework = prepareHibernatePersistenceAPI();
                break;
        }
        return ormFramework;
    }

    private static ORMFramework prepareHibernatePersistenceAPI() {
        PersistenceAPI hibernatePersistenceAPI = new Hibernate();
        return new ORMFrameworkImpl(hibernatePersistenceAPI);
    }
}
