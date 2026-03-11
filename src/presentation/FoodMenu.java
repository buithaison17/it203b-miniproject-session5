package presentation;

import utils.Input;

public class FoodMenu {
    public void menu() {
        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ MÓN ĂN ---");
            System.out.println("1. Thêm món ăn/đồ uống");
            System.out.println("2. Sửa món ăn/đồ uống");
            System.out.println("3. Xóa món ăn/đồ uống");
            System.out.println("4. Tìm món theo tên");
            System.out.println("5. Tìm món theo khoảng giá");
            System.out.println("6. Hiển thị toàn bộ thực đơn");
            System.out.println("0. Quay lại");
            choice = Input.inputIntegerPositive("Chọn chức năng: ");
            switch (choice) {
                case 1:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }
}
