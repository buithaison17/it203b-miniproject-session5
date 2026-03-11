package presentation;

import models.MenuItem;
import services.MenuItemService;
import services.OrderService;
import utils.Input;

public class OrderMenu {
    private final OrderService orderService = new OrderService();
    private final MenuItemService menuItemService = new MenuItemService();

    public void menu() {
        int choice;
        do {
            System.out.println("\n--- QUAN LY DON HANG ---");
            System.out.println("1. Tao don hang moi");
            System.out.println("2. Them mon vao gio hang");
            System.out.println("3. Tinh tong tien");
            System.out.println("4. Xem lich su don hang");
            System.out.println("0. Quay lai");

            choice = Input.inputIntegerPositive("Chon chuc nang: ");

            switch (choice) {
                case 1:
                    orderService.createOrder();
                    break;
                case 2:
                    handleAddItem();
                    break;
                case 3:
                case 4:
                    System.out.println("Chuc nang dang phat trien.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }

    private void handleAddItem() {
        if (orderService.getCurrentOrder() == null) {
            System.out.println("Thong bao: Vui long chon '1. Tao don hang' truoc.");
            return;
        }

        System.out.println("\n--- DANH SACH THUC DON ---");
        System.out.printf("%-10s | %-20s | %-10s | %-8s\n", "ID", "Ten mon", "Gia", "Ton kho");
        System.out.println("------------------------------------------------------------");

        for (MenuItem item : menuItemService.getList()) {
            System.out.printf("%-10s | %-20s | %-10.0f | %-8d\n",
                    item.getId(), item.getName(), item.getPrice(), item.getStock());
        }

        String itemId = Input.inputString("Nhap ID mon: ", false);
        MenuItem selectedItem = menuItemService.findById(itemId);

        if (selectedItem == null) {
            System.out.println("Loi: ID khong ton tai.");
            return;
        }

        if (selectedItem.getStock() <= 0) {
            System.out.println("Loi: San pham da het hang.");
            return;
        }

        int quantity = Input.inputInteger("Nhap so luong: ", 1, selectedItem.getStock());
        orderService.addItemToCurrentOrder(selectedItem, quantity);
    }
}