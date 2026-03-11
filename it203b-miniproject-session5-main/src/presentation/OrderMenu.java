package presentation;

import models.Order;
import services.OrderService;
import utils.Input;
import java.util.List;

public class OrderMenu {
    // Để đồng bộ dữ liệu, Service này nên được truyền từ Main
    // hoặc khởi tạo 1 lần duy nhất trong ứng dụng.
    private OrderService orderService = new OrderService();

    public void menu() {
        int choice;
        do {
            System.out.println("\n========= QUẢN LÝ ĐƠN HÀNG =========");
            System.out.println("1. Tạo đơn hàng mới");
            System.out.println("2. Thêm món vào đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Hiển thị tất cả đơn hàng");
            System.out.println("0. Quay lại");
            System.out.println("====================================");

            choice = Input.inputIntegerPositive("Nhập lựa chọn: ");

            switch (choice) {
                case 1:
                    String id = Input.inputString("Nhập ID đơn hàng cần tạo: ");
                    orderService.createOrder(id);
                    break;
                case 2:
                    addFoodToOrder();
                    break;
                case 3:
                    updateStatusUI();
                    break;
                case 4:
                    displayAll();
                    break;
                case 0:
                    System.out.println("Đang quay lại menu chính...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private void addFoodToOrder() {
        String orderId = Input.inputString("Nhập ID đơn hàng: ");
        Order order = orderService.findOrderById(orderId);
        if (order == null) {
            System.out.println("Đơn hàng không tồn tại!");
            return;
        }

        // Lưu ý: Ở đây bạn cần MenuItemService để lấy MenuItem thực tế từ danh sách món ăn
        System.out.println("Chức năng chọn món cần kết nối với MenuItemService.");
        // Code mẫu nếu bạn đã có item:
        // MenuItem item = menuService.findItemById(id);
        // int qty = Input.inputIntegerPositive("Số lượng: ");
        // orderService.addItemToOrder(orderId, item, qty);
    }

    private void updateStatusUI() {
        String orderId = Input.inputString("Nhập ID đơn hàng: ");
        System.out.println("Các trạng thái: 1. PENDING | 2. PAID | 3. CANCELLED");
        int st = Input.inputIntegerPositive("Chọn trạng thái (1-3): ");

        String status = switch (st) {
            case 2 -> "PAID";
            case 3 -> "CANCELLED";
            default -> "PENDING";
        };

        orderService.updateStatus(orderId, status);
    }

    private void displayAll() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống.");
        } else {
            orders.forEach(orderService::displayOrder);
        }
    }
}