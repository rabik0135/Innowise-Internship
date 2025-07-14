package com.rabinchuk.model;

public record OrderItem(
        String productName,
        int quantity,
        double price,
        Category category) {
}
