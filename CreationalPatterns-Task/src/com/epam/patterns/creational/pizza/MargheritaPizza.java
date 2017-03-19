package com.epam.patterns.creational.pizza;


import com.epam.patterns.creational.factory.PizzaIngredientFactory;

public class MargheritaPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public MargheritaPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Margherita Pizza...");
        name = "Margherita";
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }
}
