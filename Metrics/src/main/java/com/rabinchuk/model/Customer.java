package com.rabinchuk.model;

import java.time.LocalDateTime;

public record Customer(
        String customerId,
        String name,
        String email,
        LocalDateTime registeredAt,
        int age,
        String city) {
}
