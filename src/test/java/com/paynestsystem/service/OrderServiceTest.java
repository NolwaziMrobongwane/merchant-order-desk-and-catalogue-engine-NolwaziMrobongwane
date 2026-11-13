package com.paynestsystem.service;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.payment.CardPayment;
import com.paynestsystem.payment.PaymentProcessor;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void shouldCheckoutOrderSuccessfully() {

        Customer customer = new Customer(
                1, "Nolwazi", "nolwazi@example.com"
        );

        Product laptop = new Product(
                1, "Laptop", new BigDecimal("12000.00")
        );

        Product mouse = new Product(
                2, "Mouse", new BigDecimal("250.00")
        );

        OrderService orderService = new OrderService(
                new ReceiptPrinter(),
                new PaymentProcessor()
        );

        Order order = orderService.createOrder(1001, customer);

        order.addItem(laptop, 1);
        order.addItem(mouse, 2);

        assertEquals(
                new BigDecimal("12500.00"),
                order.calculateTotal()
        );

        assertTrue(
                orderService.checkout(order, new CardPayment())
        );
    }
}