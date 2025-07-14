package com.rabinchuk.model;

import java.time.LocalDateTime;
import java.util.List;

public record Order(
        String orderId,
        LocalDateTime orderDate,
        Customer customer,
        List<OrderItem> items,
        OrderStatus status) {
}
