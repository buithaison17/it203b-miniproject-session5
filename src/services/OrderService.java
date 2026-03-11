package services;

import models.MenuItem;
import models.Order;

import java.util.Map;

public class OrderService {

    // Tính tổng tiền đơn hàng
    public double calculateTotal(Order order) {

        if (order == null || order.getItems().isEmpty()) {
            return 0;
        }

        return order.getItems()
                .entrySet()
                .stream()
                .mapToDouble(entry ->
                        entry.getKey().calculatePrice() * entry.getValue())
                .sum();
    }

    // Hiển thị chi tiết đơn hàng
    public void displayOrder(Order order) {

        if (order == null) {
            System.out.println("Không tìm thấy đơn hàng.");
            return;
        }

        System.out.println("\n===== ORDER " + order.getOrderId() + " =====");

        if (order.getItems().isEmpty()) {
            System.out.println("Đơn hàng chưa có món.");
            return;
        }

        for (Map.Entry<MenuItem, Integer> entry : order.getItems().entrySet()) {

            MenuItem item = entry.getKey();
            int quantity = entry.getValue();

            double itemTotal = item.calculatePrice() * quantity;

            System.out.printf("%-20s x%d : %.0f\n",
                    item.getName(),
                    quantity,
                    itemTotal);
        }

        System.out.println("-----------------------------");

        double total = calculateTotal(order);

        System.out.println("TOTAL: " + total);
        System.out.println("ORDER DATE: " + order.getOrderDate());
    }
}