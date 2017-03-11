package com.epam.patterns.structural.adapter.cards;

import java.math.BigDecimal;
import java.util.Date;

public interface PayDCreditCard {

    String getCustomerCardNumber();
    String getOwnerName();
    Date getExpirationDate();
    Integer getCvvNumber();
    BigDecimal getTotalAmount();

    void setCustomerCardNumber(String customerCardNumber);
    void setOwnerName(String ownerName);
    void setExpirationDate(Date expirationDate);
    void setCvvNumber(Integer cVVNumber);
    void setTotalAmount(BigDecimal totalAmount);
}