package presentation;

import services.StatisticsService;
import utils.Input;

import java.time.LocalDate;

public class StatisticsMenu {

    private StatisticsService statisticsService;

    public StatisticsMenu(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

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

                case 3:
                    LocalDate date = Input.inputDate("Nhập ngày (yyyy-MM-dd): ");
                    double revenueDay = statisticsService.getRevenueByDate(date);
                    System.out.println("Doanh thu ngày " + date + " : " + revenueDay);
                    break;

                case 4:
                    int month = Input.inputIntegerPositive("Nhập tháng: ");
                    int year = Input.inputIntegerPositive("Nhập năm: ");
                    double revenueMonth = statisticsService.getRevenueByMonth(month, year);
                    System.out.println("Doanh thu tháng " + month + "/" + year + " : " + revenueMonth);
                    break;

                default:
                    break;
            }

        } while (choice != 0);
    }
}