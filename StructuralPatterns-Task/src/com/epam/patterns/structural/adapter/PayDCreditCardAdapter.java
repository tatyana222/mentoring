package com.epam.patterns.structural.adapter;

import com.epam.patterns.structural.adapter.cards.PayDCreditCard;
import com.epam.patterns.structural.adapter.cards.XPayCreditCard;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PayDCreditCardAdapter implements XPayCreditCard {

    private PayDCreditCard payDCreditCard;

    public PayDCreditCardAdapter(PayDCreditCard payDCreditCard) {
        this.payDCreditCard = payDCreditCard;
    }

    @Override
    public String getCreditCardNumber() {
        return payDCreditCard.getCustomerCardNumber();
    }

    @Override
    public String getCustomerName() {
        return payDCreditCard.getOwnerName();
    }

    @Override
    public Calendar getExpirationDate() {
        Date expirationDate = payDCreditCard.getExpirationDate();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(expirationDate);
        return gregorianCalendar;
    }

    @Override
    public Short getCVVNumber() {
        return payDCreditCard.getCvvNumber().shortValue();
    }

    @Override
    public Double getAmount() {
        return payDCreditCard.getTotalAmount().doubleValue();
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        this.payDCreditCard.setCustomerCardNumber(creditCardNumber);
    }

    @Override
    public void setCustomerName(String customerName) {
        this.payDCreditCard.setOwnerName(customerName);
    }

    @Override
    public void setExpirationDate(Calendar expirationDate) {
        this.payDCreditCard.setExpirationDate(expirationDate.getTime());
    }

    @Override
    public void setCVVNumber(Short cardCVVNumber) {
        this.payDCreditCard.setCvvNumber(cardCVVNumber.intValue());
    }

    @Override
    public void setAmount(Double amount) {
        this.payDCreditCard.setTotalAmount(BigDecimal.valueOf(amount));
    }
}