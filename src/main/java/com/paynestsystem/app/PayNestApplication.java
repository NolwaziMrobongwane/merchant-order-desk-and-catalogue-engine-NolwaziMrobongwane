package com.paynestsystem.app;

import java.math.BigDecimal;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.service.OrderService;
import com.paynestsystem.service.ReceiptPrinter;

public class PayNestApplication {

    public static void main(String[] args) {

        Product laptop = new Product (1, "Laptop", new BigDecimal("12000.00"));

        Product mouse = new Product(2, "Mouse", new BigDecimal("250.00"));

        Customer customer = new Customer(1, "Nolwazi", "nolwazi.mrobongwane@umuzi.org");

        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        OrderService orderService = new OrderService(receiptPrinter);

        Order order = orderService.createOrder(1001, customer);

        order.addItem(laptop, 1);
        order.addItem(mouse, 2);

    }
}
