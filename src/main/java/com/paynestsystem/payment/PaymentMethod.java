package com.paynestsystem.payment;

import java.math.BigDecimal;

public interface PaymentMethod {
    boolean processPayment(BigDecimal amount);
    String getPaymentType();
}
