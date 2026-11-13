package com.paynestsystem.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WalletPayment implements PaymentMethod {
    //Add wallet balance
    private BigDecimal balance;

    //Add a constructor to set a balance
    public WalletPayment() {
        this(new BigDecimal("20000.00"));
    }
    public WalletPayment(BigDecimal balance) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Wallet balance cannot be negative or null");
        }
        this.balance = balance;
    }
    @Override
    public boolean processPayment(BigDecimal amount) {
        validateAmount(amount);
        if (amount.compareTo(balance) > 0) {
            System.out.println("Wallet payment failed: insufficient balance.");
            return false;
        }
        balance = balance.subtract(amount);

        System.out.println("Process wallet payment for R" + amount.setScale(2, RoundingMode.HALF_UP));
        return true;
    }
    @Override
    public String getPaymentType() {
        return "Wallet Payment";
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
