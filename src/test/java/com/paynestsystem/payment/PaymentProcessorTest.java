package com.paynestsystem.payment;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {

    private final PaymentProcessor processor =
            new PaymentProcessor();

    @Test
    void shouldProcessCardPayment() {
        boolean result = processor.processPayment(
                new CardPayment(),
                new BigDecimal("500.00")
        );

        assertTrue(result);
    }

    @Test
    void shouldProcessEftPayment() {
        boolean result = processor.processPayment(
                new EftPayment(),
                new BigDecimal("500.00")
        );

        assertTrue(result);
    }

    @Test
    void shouldProcessWalletPayment() {
        boolean result = processor.processPayment(
                new WalletPayment(),
                new BigDecimal("500.00")
        );

        assertTrue(result);
    }

    @Test
    void shouldRejectNullPaymentMethod() {
        assertThrows(
                IllegalArgumentException.class,
                () -> processor.processPayment(
                        null,
                        new BigDecimal("500.00")
                )
        );
    }

    @Test
    void shouldRejectZeroAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> processor.processPayment(
                        new CardPayment(),
                        BigDecimal.ZERO
                )
        );
    }

    @Test
    void shouldRejectNegativeAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> processor.processPayment(
                        new CardPayment(),
                        new BigDecimal("-50.00")
                )
        );
    }

    //Add failure-path test
    @Test
    void shouldReturnFalseWhenWalletBalanceIsInsufficient(){
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        WalletPayment walletPayment = new WalletPayment(
                new BigDecimal("500.00")
        );
        boolean result = processor.processPayment(
                walletPayment, new BigDecimal("12500.00")
        );
        assertFalse(result);
    }
}



