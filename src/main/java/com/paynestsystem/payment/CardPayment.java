package com.paynestsystem.payment;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0.");
        }
        System.out.println("Processing Card Payment for R" + amount.setScale(2, java.math.RoundingMode.HALF_UP));
        return true;
    }
    @Override
    public String getPaymentType() {
        return "Card Payment";
    }
}
