package com.epam.patterns.structural.facade;

import com.epam.patterns.structural.facade.product.Product;
import com.epam.patterns.structural.facade.services.InventoryService;
import com.epam.patterns.structural.facade.services.PaymentService;
import com.epam.patterns.structural.facade.services.ShippingService;

public class OrderServiceFacadeImpl implements OrderServiceFacade {

    // Make Facade Singleton as recommended
    private static volatile OrderServiceFacade instance;

    private OrderServiceFacadeImpl() {
    }

    public static OrderServiceFacade getInstance() {
        if (instance == null)
            synchronized (OrderServiceFacadeImpl.class) {
                if (instance == null)
                    instance = new OrderServiceFacadeImpl();
            }
        return instance;
    }

    @Override
    public boolean order(Long productId) {
        boolean orderFulfilled = false;
        Product product = new Product();
        product.setId(productId);

        if (InventoryService.isAvailable(product)) {
            System.out.println("Product with ID " + productId + " is available");
            boolean paymentConfirmed = PaymentService.makePayment();
            if (paymentConfirmed) {
                System.out.println("Payment confirmed...");
                ShippingService.shipProduct(product);
                System.out.println("Product shipped...");
                orderFulfilled = true;
            }
        }
        return orderFulfilled;
    }
}