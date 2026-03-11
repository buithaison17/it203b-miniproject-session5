package services;

import models.MenuItem;
import models.Order;
import java.time.LocalDateTime;
import java.util.*;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();

    // Tạo đơn hàng mới với ID nhập từ người dùng
    public void createOrder(String orderId) {
        Order newOrder = new Order(orderId, new HashMap<>(), LocalDateTime.now());
        orders.add(newOrder);
        System.out.println("Tạo đơn hàng " + orderId + " thành công!");
    }

    // Tìm đơn hàng theo ID
    public Order findOrderById(String id) {
        return orders.stream()
                .filter(o -> o.getOrderId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    // Thêm món vào đơn hàng cụ thể
    public void addItemToOrder(String orderId, MenuItem item, int quantity) {
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Lỗi: Không tìm thấy đơn hàng!");
            return;
        }

        if (item.getStock() < quantity) {
            System.out.println("Lỗi: Kho không đủ (Hiện có: " + item.getStock() + ")");
            return;
        }

        int currentQty = order.getItems().getOrDefault(item, 0);
        order.getItems().put(item, currentQty + quantity);
        item.setStock(item.getStock() - quantity); // Cập nhật kho

        System.out.println("Đã thêm " + quantity + " " + item.getName() + " vào đơn " + orderId);
    }

    // Cập nhật trạng thái đơn hàng
    public void updateStatus(String orderId, String newStatus) {
        Order order = findOrderById(orderId);
        if (order != null) {
            order.setStatus(newStatus.toUpperCase());
            System.out.println("Cập nhật trạng thái thành " + newStatus + " cho đơn " + orderId);
        } else {
            System.out.println("Không tìm thấy đơn hàng.");
        }
    }

    // Tính tổng tiền
    public double calculateTotal(Order order) {
        if (order == null || order.getItems().isEmpty()) return 0;
        return order.getItems().entrySet().stream()
                .mapToDouble(e -> e.getKey().calculatePrice() * e.getValue())
                .sum();
    }

    // Hiển thị chi tiết 1 đơn hàng
    public void displayOrder(Order order) {
        if (order == null) return;
        System.out.println("\n--- ĐƠN HÀNG: " + order.getOrderId() + " [" + order.getStatus() + "] ---");
        order.getItems().forEach((item, qty) -> {
            System.out.printf("- %-15s x%d : %.0f\n", item.getName(), qty, (item.calculatePrice() * qty));
        });
        System.out.println("Tổng cộng: " + calculateTotal(order));
        System.out.println("Ngày tạo: " + order.getOrderDate());
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}