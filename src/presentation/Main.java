package presentation;

import utils.Input;

public class Main {
    private static final FoodMenu foodMenu = new FoodMenu();
    private static final OrderMenu orderMenu = new OrderMenu();
    private static final StatisticsMenu statisticsMenu = new StatisticsMenu();

    static void main() {
        int choice;
        do {
            System.out.println("\n===== MENU QUẢN LÝ CỬA HÀNG =====");
            System.out.println("1. Quản lý món ăn");
            System.out.println("2. Quản đơn hàng");
            System.out.println("3. Thống kê");
            System.out.println("0. Thoát");
            choice = Input.inputIntegerPositive("Chọn chức năng: ");
            switch (choice) {
                case 1:
                    foodMenu.menu();
                    break;
                case 2:
                    orderMenu.menu();
                    break;
                case 3:
                    statisticsMenu.menu();
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ");
                    break;
            }
        }
        while (choice != 0);
    }
}
