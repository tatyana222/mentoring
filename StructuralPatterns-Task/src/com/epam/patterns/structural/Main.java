package com.epam.patterns.structural;

import com.epam.patterns.structural.bridge.ORMFramework;

public class Main {

    private static final String CONSOLE_SEPARATOR = "***********************************";

    public static void main(String[] args) {
        AdapterExample.showAdapter();

        System.out.println(CONSOLE_SEPARATOR);
        ORMFramework hibernate = PersistenceProvider.getProvider("hibernate");
        hibernate.save(new Object());
        hibernate.get(1L);
        hibernate.delete(3L);

        System.out.println(CONSOLE_SEPARATOR);
        ORMFramework myBatis = PersistenceProvider.getProvider("myBatis");
        myBatis.save(new Object());
        myBatis.get(2L);
        myBatis.delete(5L);

        System.out.println(CONSOLE_SEPARATOR);
    }
}