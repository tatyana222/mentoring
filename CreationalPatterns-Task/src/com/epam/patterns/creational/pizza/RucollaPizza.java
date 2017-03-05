package com.epam.patterns.creational.pizza;


import com.epam.patterns.creational.factory.PizzaIngredientFactory;

public class RucollaPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public RucollaPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Rucolla Pizza...");
        name = "Rucolla";
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        pepperoni = pizzaIngredientFactory.createPepperoni();
    }
}
