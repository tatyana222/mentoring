package com.epam.patterns.creational.pizza;


import com.epam.patterns.creational.ingredients.Cheese;
import com.epam.patterns.creational.ingredients.Dough;
import com.epam.patterns.creational.ingredients.Pepperoni;
import com.epam.patterns.creational.ingredients.Sauce;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Pepperoni pepperoni;

    public abstract void prepare();

    public void bake() {
        System.out.println("Baking pizza...");
    }

    public void cut() {
        System.out.println("Cutting pizza...");
    }

    public void box() {
        System.out.println("Boxing pizza...");
    }
}