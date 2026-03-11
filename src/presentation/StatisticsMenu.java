package presentation;

import utils.Input;

public class StatisticsMenu {
    public void menu() {
        int choice;
        do {
            System.out.println("\n--- THỐNG KÊ/ TÌM KIẾM ---");
            System.out.println("1. Tìm món theo tên");
            System.out.println("2. Tìm món theo khoảng giá");
            System.out.println("3. Doanh thu theo ngày");
            System.out.println("4. Doanh thu theo tháng");
            System.out.println("5. Liệt kê món bán chạy nhất");
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
