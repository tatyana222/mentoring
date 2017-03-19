package com.epam.patterns.creational.pizza;


import com.epam.patterns.creational.factory.PizzaIngredientFactory;

public class BolognesePizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public BolognesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Bolognese Pizza...");
        name = "Bolognese";
        dough = pizzaIngredientFactory.createDough();
        cheese = pizzaIngredientFactory.createCheese();
        pepperoni = pizzaIngredientFactory.createPepperoni();
    }
}
