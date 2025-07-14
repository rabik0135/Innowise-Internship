package com.rabinchuk;

import com.rabinchuk.model.Order;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = DataGenerator.generateOrders();

        System.out.println("1. - " + OrderAnalyzer.getUniqueCities(orders));
        System.out.println("2. - " + OrderAnalyzer.getTotalIncome(orders));
        System.out.println("3. - " + OrderAnalyzer.getMostPopularProduct(orders));
        System.out.println("4 - " + OrderAnalyzer.getAverageCheck(orders));
        System.out.println("5 - " + OrderAnalyzer.getFrequentCustomers(orders));
    }
}