package com.paynestsystem.payment;

import java.math.BigDecimal;

public class EftPayment implements PaymentMethod {
    @Override
    public boolean processPayment(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
        System.out.println("Processing EFT Payment for R" + amount.setScale(2, java.math.RoundingMode.HALF_UP));
        return true;
    }
    @Override
    public String getPaymentType() {
        return "EFT Payment";
    }
}
