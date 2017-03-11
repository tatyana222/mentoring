package com.epam.patterns.structural.adapter.cards;

import java.math.BigDecimal;
import java.util.Date;

public class PayDCreditCardImpl implements PayDCreditCard {

    private String customerCardNumber;
    private String ownerName;
    private Date expirationDate;
    private Integer cvvNumber;
    private BigDecimal totalAmount;

    @Override
    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    @Override
    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public Integer getCvvNumber() {
        return cvvNumber;
    }

    @Override
    public void setCvvNumber(Integer cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    @Override
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    @Override
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}