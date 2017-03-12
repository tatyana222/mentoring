package com.epam.patterns.structural.facade.services;

import com.epam.patterns.structural.facade.product.Product;

public class InventoryService {

    public static boolean isAvailable(Product product){
        // Checks Warehouse database for product availability
        return true;
    }
}