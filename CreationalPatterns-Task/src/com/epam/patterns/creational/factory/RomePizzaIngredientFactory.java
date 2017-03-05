package com.epam.patterns.creational.factory;


import com.epam.patterns.creational.ingredients.*;

public class RomePizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new CrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new TomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SpicyPepperoni();
    }
}
