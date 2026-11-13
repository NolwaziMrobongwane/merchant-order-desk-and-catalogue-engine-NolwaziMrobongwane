package com.paynestsystem.payment;

import java.math.BigDecimal;

public class PaymentProcessor {
    public boolean processPayment(
            PaymentMethod method,
            BigDecimal amount) {
        if (method == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
        boolean success = method.processPayment(amount);

        if (success) {
            System.out.println("Payment successful via " + method.getPaymentType());
            System.out.println("Amount: R" + amount.setScale(2, java.math.RoundingMode.HALF_UP));
        }
        else {
            System.out.println("Payment failed via " + method.getPaymentType());
        }
        return success;
    }
}
