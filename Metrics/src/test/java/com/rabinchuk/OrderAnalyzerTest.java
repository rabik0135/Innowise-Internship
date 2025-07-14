package com.rabinchuk;

import com.rabinchuk.model.Customer;
import com.rabinchuk.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderAnalyzerTest {

    private List<Order> orders;

    @BeforeEach
    void setUp() {
        orders = DataGenerator.generateOrders();
    }

    @Test
    public void testGetUniqueCities() {
        Set<String> actualCities = OrderAnalyzer.getUniqueCities(orders);
        Set<String> expectedCities = Set.of("Москва", "Санкт-Петербург", "Минск", "Гродно");
        assertEquals(4, actualCities.size());
        assertEquals(expectedCities, actualCities);
    }

    @Test
    public void testGetTotalIncome() {
        double totalIncome = OrderAnalyzer.getTotalIncome(orders);
        assertEquals(416_500, totalIncome);
    }

    @Test
    public void testGetMostPopularProduct() {
        Optional<String> mostPopularProduct = OrderAnalyzer.getMostPopularProduct(orders);
        assertEquals("Java для начинающих",  mostPopularProduct.get());
    }

    @Test
    public void testGetAverageCheck() {
        Integer expectedAverageCheck = 69_417;
        assertEquals(expectedAverageCheck, OrderAnalyzer.getAverageCheck(orders).getAsInt());
    }

    @Test
    public void testGetFrequentCustomers() {
        List<Customer> customers = OrderAnalyzer.getFrequentCustomers(orders);
        assertEquals(1, customers.size());

        Customer customerActual = customers.getFirst();
        Customer customerExpected = new Customer("C001", "Иван Петров", "ivan@example.com",
                LocalDateTime.of(2022, 1, 15, 10, 0), 32, "Москва");
        assertEquals(customerExpected, customerActual);
    }
}
