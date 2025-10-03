package com.supercoding.chapter_48;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Order {
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private OrderStatus status;
    private List<OrderItem> orderItems;

    public Order(int id, Customer customer, LocalDate orderDate, OrderStatus status, List<OrderItem> orderItems) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.orderItems = orderItems;
    }

    public OrderStatus getOrderStatus() {
        return status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Optional<Customer> getCustomer() {
        return Optional.ofNullable(customer);
    }
}
