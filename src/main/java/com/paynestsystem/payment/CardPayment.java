package com.paynestsystem.payment;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(BigDecimal amount) {
        validateAmount(amount);
        System.out.println("Processing Card Payment for R" + amount.setScale(2, java.math.RoundingMode.HALF_UP));
        return true;
    }
    @Override
    public String getPaymentType() {
        return "Card Payment";
    }
}
