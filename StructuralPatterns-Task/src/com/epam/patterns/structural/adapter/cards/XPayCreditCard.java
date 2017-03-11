package com.epam.patterns.structural.adapter.cards;

import java.util.Calendar;

public interface XPayCreditCard {

    String getCreditCardNumber();
    String getCustomerName();
    Calendar getExpirationDate();
    Short getCVVNumber();
    Double getAmount();

    void setCreditCardNumber(String creditCardNumber);
    void setCustomerName(String customerName);
    void setExpirationDate(Calendar expirationDate);
    void setCVVNumber(Short cardCVVNumber);
    void setAmount(Double amount);
}