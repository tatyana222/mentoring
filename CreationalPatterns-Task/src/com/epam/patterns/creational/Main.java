package com.epam.patterns.creational;

import com.epam.patterns.creational.store.NaplesPizzaStore;
import com.epam.patterns.creational.store.RomePizzaStore;

import static com.epam.patterns.creational.pizza.PizzaType.*;

public class Main {

    public static void main(String[] args) {
        NaplesPizzaStore naplesPizzaStore = new NaplesPizzaStore();
        RomePizzaStore romePizzaStore = new RomePizzaStore();

        naplesPizzaStore.orderPizza(MARGHERITA);
        romePizzaStore.orderPizza(MARGHERITA);

        naplesPizzaStore.orderPizza(CAPRICCIOSA);
        romePizzaStore.orderPizza(CAPRICCIOSA);

        naplesPizzaStore.orderPizza(BOLOGNESE);
        romePizzaStore.orderPizza(BOLOGNESE);

        naplesPizzaStore.orderPizza(RUCOLLA);
        romePizzaStore.orderPizza(RUCOLLA);
    }
}