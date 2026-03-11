package services;

import models.MenuItem;
import models.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private Order currentOrder = null;

    public void createOrder() {
        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        currentOrder = new Order(orderId, new HashMap<>(), LocalDateTime.now());
        orders.add(currentOrder);
        System.out.println("Da tao don hang moi: " + orderId);
    }

    public void addItemToCurrentOrder(MenuItem item, int quantity) {
        if (currentOrder == null) {
            System.out.println("Loi: Can tao don hang truoc!");
            return;
        }

        if (item.getStock() < quantity) {
            System.out.println("Loi: Khong du hang trong kho!");
            return;
        }

        int currentQty = currentOrder.getItems().getOrDefault(item, 0);
        currentOrder.getItems().put(item, currentQty + quantity);
        item.setStock(item.getStock() - quantity);

        System.out.println("Da them: " + item.getName() + " (SL: " + quantity + ")");
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}