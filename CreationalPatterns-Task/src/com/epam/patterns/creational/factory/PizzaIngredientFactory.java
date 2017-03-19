package com.epam.patterns.creational.factory;


import com.epam.patterns.creational.ingredients.Cheese;
import com.epam.patterns.creational.ingredients.Dough;
import com.epam.patterns.creational.ingredients.Pepperoni;
import com.epam.patterns.creational.ingredients.Sauce;

public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Pepperoni createPepperoni();
}
