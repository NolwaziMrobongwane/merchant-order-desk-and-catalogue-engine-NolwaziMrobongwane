package com.paynestsystem.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.OrderItem;

public class ReceiptPrinter {
    
    public void printReceipt(Order order) {
        if(order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }

        Locale locale = Locale.forLanguageTag("en-ZA");
        NumberFormat currency =  NumberFormat.getCurrencyInstance(locale);

        currency.setMinimumFractionDigits(2);
        currency.setMaximumFractionDigits(2);
        
        System.out.println("======== PAYNEST RECEIPT ========");
        System.out.println("Order #: " + order.getId());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Email: " + order.getCustomer().getEmail());
        System.out.println("--------------------------------------");

        if (order.getOrderItems().isEmpty()) {
            System.out.println("No items in this order.");
        } else {
            for (OrderItem item : order.getOrderItems()) {
                BigDecimal itemTotal = item.calculateTotal();
                
                System.out.println(
                    item.getProduct().getName()
                    + " x "
                    + item.getQuantity()
                    + " = "
                    + currency.format(itemTotal)
                );
            }
        }

        System.out.println("--------------------------------------");
        System.out.println(
            "Total: "
            + currency.format(order.calculateTotal())
        );
        System.out.println("===================================");
    }
}
