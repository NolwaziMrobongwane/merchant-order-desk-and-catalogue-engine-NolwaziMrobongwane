package com.paynestsystem.app;

import java.math.BigDecimal;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;

import com.paynestsystem.payment.*;
import com.paynestsystem.service.OrderService;
import com.paynestsystem.service.ReceiptPrinter;

public class PayNestApplication {

    public static void main(String[] args) {

        //sample products
        Product laptop = new Product (1, "Laptop", new BigDecimal("12000.00"));

        Product mouse = new Product(2, "Mouse", new BigDecimal("250.00"));

        //create customer
        Customer customer = new Customer(1, "Nolwazi", "nolwazi.mrobongwane@umuzi.org");

        //set up services
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        OrderService orderService = new OrderService(receiptPrinter, paymentProcessor);

        //create order
        Order order = orderService.createOrder(1001, customer);

        order.addItem(laptop, 1);
        order.addItem(mouse, 2);

        //display receipt
        orderService.printReceipt(order);

        //choose payment method
        PaymentMethod paymentMethod = new WalletPayment();

        //process checkout
        orderService.checkout(order, paymentMethod);
    }
}
