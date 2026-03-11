package presentation;

import utils.Input;

public class OrderMenu {
    public void menu() {
        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ ĐƠN HÀNG ---");
            System.out.println("1. Tạo đơn hàng mới");
            System.out.println("2. Thêm món vào giỏ hàng");
            System.out.println("3. Tính tổng tiền đơn hàng");
            System.out.println("4. Hiển thị tất cả đơn hàng");
            System.out.println("0. Quay lại");
            choice = Input.inputIntegerPositive("Nhập chức năng: ");
            switch (choice) {
                case 1:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }
}
