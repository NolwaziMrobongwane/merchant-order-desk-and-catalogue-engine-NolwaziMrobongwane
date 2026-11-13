package com.paynestsystem.service;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.payment.PaymentMethod;
import com.paynestsystem.payment.PaymentProcessor;
import java.math.BigDecimal;

public class OrderService {

    private final ReceiptPrinter receiptPrinter;
    private final PaymentProcessor paymentProcessor;

    public OrderService(ReceiptPrinter receiptPrinter, PaymentProcessor paymentProcessor) {
        if (receiptPrinter == null) {
            throw new IllegalArgumentException(
                    "Receipt printer cannot be null."
            );
        }
        this.receiptPrinter = receiptPrinter;
        this.paymentProcessor = paymentProcessor;
    }

    public Order createOrder(int orderId, Customer customer) {
        return new Order(orderId, customer);
    }

    public void printReceipt(Order order) {
        if (order == null) {
            throw new IllegalArgumentException(
                    "Order cannot be null."
            );
        }

        receiptPrinter.printReceipt(order);
    }
    public boolean checkout(Order order, PaymentMethod paymentMethod) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }

        BigDecimal total = order.calculateTotal();
        boolean successful = paymentProcessor.processPayment( paymentMethod, total);

        if (successful) {
            System.out.println("Order #" + order.getId() + " has been processed successfully.");
        }
        else  {
            System.out.println("Order #" + order.getId() + " payment failed.");
        }
        return successful;
    }
}
