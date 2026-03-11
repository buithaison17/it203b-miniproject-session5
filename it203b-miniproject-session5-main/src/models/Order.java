package models;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private String orderId;
    private Map<MenuItem, Integer> items;
    private LocalDateTime orderDate;
    private String status;

    public Order(String orderId, Map<MenuItem, Integer> items, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.items = items;
        this.orderDate = orderDate;
        this.status = "PENDING"; // Mặc định khi tạo mới
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    public void setItems(Map<MenuItem, Integer> items) {
        this.items = items;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}