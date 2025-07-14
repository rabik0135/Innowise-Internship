package com.rabinchuk;

import com.rabinchuk.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class DataGenerator {

    public static List<Order> generateOrders() {
        Customer customer1 = new Customer("C001", "Иван Петров", "ivan@example.com",
                LocalDateTime.of(2022, 1, 15, 10, 0), 32, "Москва");

        Customer customer2 = new Customer("C002", "Анна Сидорова", "anna@example.com",
                LocalDateTime.of(2021, 11, 5, 14, 30), 28, "Санкт-Петербург");

        Customer customer3 = new Customer("C003", "Сергей Иванов", "sergey@example.com",
                LocalDateTime.of(2023, 2, 20, 9, 15), 41, "Гродно");

        Customer customer4 = new Customer("C004", "Елена Кузнецова", "elena@example.com",
                LocalDateTime.of(2022, 5, 10, 16, 45), 35, "Москва");

        Customer customer5 = new Customer("C005", "Дмитрий Смирнов", "dmitry@example.com",
                LocalDateTime.of(2023, 1, 8, 11, 20), 29, "Минск");

        Order order1 = new Order("O001", LocalDateTime.of(2023, 3, 10, 12, 0),
                customer1,
                List.of(
                        new OrderItem("Ноутбук Lenovo", 1, 75000, Category.ELECTRONICS),
                        new OrderItem("Java для начинающих", 3, 1200, Category.BOOKS) // 3 книги
                ),
                OrderStatus.DELIVERED);

        Order order2 = new Order("O002", LocalDateTime.of(2023, 3, 12, 14, 30),
                customer2,
                List.of(
                        new OrderItem("Смартфон Samsung", 2, 45000, Category.ELECTRONICS),
                        new OrderItem("Платье летнее", 2, 5600, Category.CLOTHING),
                        new OrderItem("Туалетная вода", 1, 6700, Category.BEAUTY)
                ),
                OrderStatus.DELIVERED);

        Order order3 = new Order("O003", LocalDateTime.of(2023, 3, 15, 9, 45),
                customer3,
                List.of(
                        new OrderItem("Java для начинающих", 1, 1200, Category.BOOKS), // 1 книга
                        new OrderItem("Рубашка мужская", 1, 3500, Category.CLOTHING),
                        new OrderItem("Конструктор Lego", 1, 8900, Category.TOYS)
                ),
                OrderStatus.PROCESSING);

        Order order4 = new Order("O004", LocalDateTime.of(2023, 3, 18, 16, 20),
                customer4,
                List.of(
                        new OrderItem("Смартфон Samsung", 1, 45000, Category.ELECTRONICS),
                        new OrderItem("Сковорода", 1, 3200, Category.HOME)
                ),
                OrderStatus.SHIPPED);

        Order order5 = new Order("O005", LocalDateTime.of(2023, 3, 20, 11, 10),
                customer1,
                List.of(
                        new OrderItem("Ноутбук Lenovo", 1, 75000, Category.ELECTRONICS),
                        new OrderItem("Java для начинающих", 1, 1200, Category.BOOKS), // 1 книга
                        new OrderItem("Конструктор Lego", 1, 8900, Category.TOYS)
                ),
                OrderStatus.DELIVERED);

        Order order6 = new Order("O006", LocalDateTime.of(2023, 3, 22, 13, 25),
                customer2,
                List.of(
                        new OrderItem("Платье летнее", 2, 5600, Category.CLOTHING),
                        new OrderItem("Туалетная вода", 1, 6700, Category.BEAUTY)
                ),
                OrderStatus.NEW);

        Order order7 = new Order("O007", LocalDateTime.of(2023, 3, 25, 10, 50),
                customer1,
                List.of(
                        new OrderItem("Смартфон Samsung", 1, 45000, Category.ELECTRONICS),
                        new OrderItem("Рубашка мужская", 1, 3500, Category.CLOTHING)
                ),
                OrderStatus.DELIVERED);

        Order order8 = new Order("O008", LocalDateTime.of(2023, 3, 28, 15, 15),
                customer5,
                List.of(
                        new OrderItem("Java для начинающих", 1, 1200, Category.BOOKS), // 1 книга
                        new OrderItem("Сковорода", 1, 3200, Category.HOME)
                ),
                OrderStatus.CANCELLED);

        Order order9 = new Order("O009", LocalDateTime.of(2023, 4, 1, 12, 30),
                customer1,
                List.of(
                        new OrderItem("Ноутбук Lenovo", 1, 75000, Category.ELECTRONICS),
                        new OrderItem("Конструктор Lego", 1, 8900, Category.TOYS)
                ),
                OrderStatus.DELIVERED);

        Order order10 = new Order("O010", LocalDateTime.of(2023, 4, 5, 9, 0),
                customer1,
                List.of(
                        new OrderItem("Смартфон Samsung", 1, 45000, Category.ELECTRONICS),
                        new OrderItem("Java для начинающих", 1, 1200, Category.BOOKS), // 1 книга
                        new OrderItem("Платье летнее", 1, 5600, Category.CLOTHING)
                ),
                OrderStatus.PROCESSING);

        Order order11 = new Order("O011", LocalDateTime.of(2023, 4, 8, 14, 45),
                customer1,
                List.of(
                        new OrderItem("Наушники Sony", 1, 12500, Category.ELECTRONICS)
                ),
                OrderStatus.DELIVERED);

        return List.of(order1, order2, order3, order4, order5,
                order6, order7, order8, order9, order10, order11);
    }

}
