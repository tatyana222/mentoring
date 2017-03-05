package com.epam.patterns.creational.store;


import com.epam.patterns.creational.pizza.PizzaType;
import com.epam.patterns.creational.pizza.Pizza;

public abstract class PizzaStore {

    abstract Pizza createPizza(PizzaType type);

    public Pizza orderPizza(PizzaType type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
