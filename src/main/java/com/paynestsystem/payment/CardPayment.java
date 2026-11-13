package com.paynestsystem.payment;

import java.math.BigDecimal;

public class CardPayment implements PaymentMethod {
    @Override
    public boolean processPayment(BigDecimal amount) {
        validateAmount(amount);

        BigDecimal cardLimit = new BigDecimal("10000.00");
        if (amount.compareTo(cardLimit) > 0) {
            System.out.println("Card payment declined: transaction limit exceeded.");
            return false;
        }

        System.out.println("Processing Card Payment for R" + amount.setScale(2, java.math.RoundingMode.HALF_UP));
        return true;
    }

    @Override
    public String getPaymentType() {
        return "Card Payment";
    }
}
