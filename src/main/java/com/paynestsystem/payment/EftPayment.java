package com.paynestsystem.payment;

import java.math.BigDecimal;

public class EftPayment implements PaymentMethod {
    @Override
    public boolean processPayment(BigDecimal amount) {
        validateAmount(amount);
        System.out.println("Processing EFT Payment for R" + amount.setScale(2, java.math.RoundingMode.HALF_UP));
        return true;
    }
    @Override
    public String getPaymentType() {
        return "EFT Payment";
    }
}
