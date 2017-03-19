package com.epam.patterns.creational.store;


import com.epam.patterns.creational.pizza.PizzaType;
import com.epam.patterns.creational.factory.NaplesPizzaIngredientFactory;
import com.epam.patterns.creational.factory.PizzaIngredientFactory;
import com.epam.patterns.creational.pizza.*;

public class NaplesPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaType type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NaplesPizzaIngredientFactory();

        switch (type) {
            case MARGHERITA:
                pizza = new MargheritaPizza(pizzaIngredientFactory);
                break;
            case CAPRICCIOSA:
                pizza = new CapricciosaPizza(pizzaIngredientFactory);
                break;
            case BOLOGNESE:
                pizza = new BolognesePizza(pizzaIngredientFactory);
                break;
            case RUCOLLA:
                pizza = new RucollaPizza(pizzaIngredientFactory);
                break;
            default:
                break;
        }
        return pizza;
    }
}
