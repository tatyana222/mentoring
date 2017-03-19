package com.epam.patterns.structural;

import com.epam.patterns.structural.adapter.PayDCreditCardAdapter;
import com.epam.patterns.structural.adapter.cards.PayDCreditCardImpl;
import com.epam.patterns.structural.adapter.cards.XPayCreditCard;

import java.math.BigDecimal;
import java.util.Date;

public final class AdapterExample {

    private AdapterExample() {
    }

    public static void showAdapter() {
        System.out.println("Adapter example");
        System.out.println("Now we have new payment vendor - PayD");
        PayDCreditCardImpl payDCreditCard = preparePayDCreditCard();

        System.out.println("But we have legacy system and everything is adapted here for XPay payment vendor that has legacy API");
        System.out.println("So we create an adapter to make existing functionality work with new vendor");

        XPayCreditCard adapter = new PayDCreditCardAdapter(payDCreditCard);
        testXPayCreditCard(adapter);
    }

    private static PayDCreditCardImpl preparePayDCreditCard() {
        PayDCreditCardImpl payDCreditCard = new PayDCreditCardImpl();
        payDCreditCard.setCustomerCardNumber("5555 5555 5555 5555");
        payDCreditCard.setOwnerName("Owner Name");
        payDCreditCard.setCvvNumber(777);
        payDCreditCard.setExpirationDate(new Date());
        payDCreditCard.setTotalAmount(new BigDecimal("10000"));
        return payDCreditCard;
    }

    private static void testXPayCreditCard(XPayCreditCard adapter) {
        System.out.print("Credit card number: ");
        System.out.println(adapter.getCreditCardNumber());
        System.out.print("Customer name: ");
        System.out.println(adapter.getCustomerName());
        System.out.print("CVV number: ");
        System.out.println(adapter.getCVVNumber());
        System.out.print("Expiration date: ");
        System.out.println(adapter.getExpirationDate().getTime());
        System.out.print("Amount: ");
        System.out.println(adapter.getAmount());
    }
}