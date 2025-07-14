package com.rabinchuk;

import com.rabinchuk.model.Customer;
import com.rabinchuk.model.Order;
import com.rabinchuk.model.OrderItem;
import com.rabinchuk.model.OrderStatus;

import java.util.*;
import java.util.stream.Collectors;

public class OrderAnalyzer {

    public static Set<String> getUniqueCities(List<Order> orders) {
        return orders.stream()
                .map(order -> order.customer().city())
                .collect(Collectors.toSet());
    }

    public static double getTotalIncome(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.status() == OrderStatus.DELIVERED)
                .flatMap(order -> order.items().stream())
                .mapToDouble(item -> item.price() * item.quantity())
                .sum();
    }

    public static Optional<String> getMostPopularProduct(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.items().stream())
                .collect(Collectors.groupingBy(
                        OrderItem::productName,
                        Collectors.summingInt(OrderItem::quantity)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public static OptionalInt getAverageCheck(List<Order> orders) {
        OptionalDouble average = orders.stream()
                .filter(order -> order.status() == OrderStatus.DELIVERED)
                .mapToDouble(order -> order.items().stream()
                        .mapToDouble(item -> item.price() * item.quantity())
                        .sum())
                .average();
        if (average.isPresent()) {
            return OptionalInt.of((int) Math.round(average.getAsDouble()));
        } else {
            return OptionalInt.empty();
        }
    }

    public static List<Customer> getFrequentCustomers(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::customer,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
