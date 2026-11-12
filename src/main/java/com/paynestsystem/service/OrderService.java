package com.paynestsystem.service;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;

public class OrderService {

    private final ReceiptPrinter receiptPrinter;

    public OrderService(ReceiptPrinter receiptPrinter) {
        if (receiptPrinter == null) {
            throw new IllegalArgumentException(
                    "Receipt printer cannot be null."
            );
        }
        this.receiptPrinter = receiptPrinter;
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
}
