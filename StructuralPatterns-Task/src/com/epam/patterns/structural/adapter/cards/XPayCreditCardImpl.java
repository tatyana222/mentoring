package com.epam.patterns.structural.adapter.cards;

import java.util.Calendar;

public class XPayCreditCardImpl implements XPayCreditCard {

    private String creditCardNumber;
    private String customerName;
    private Calendar expirationDate;
    private Short cardCVVNumber;
    private Double amount;

    @Override
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    @Override
    public Calendar getExpirationDate() {
        return expirationDate;
    }

    @Override
    public Short getCVVNumber() {
        return cardCVVNumber;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void setCVVNumber(Short cardCVVNumber) {
        this.cardCVVNumber = cardCVVNumber;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}