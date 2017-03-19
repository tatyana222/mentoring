package com.epam.patterns.creational.pizza;


import com.epam.patterns.creational.factory.PizzaIngredientFactory;

public class CapricciosaPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public CapricciosaPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Capricciosa Pizza...");
        name = "Capricciosa";
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        pepperoni = pizzaIngredientFactory.createPepperoni();
    }
}
