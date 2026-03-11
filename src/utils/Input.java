package utils;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    // Giữ lại phương thức cũ cho các chức năng khác nếu cần
    public static String inputString(String title) {
        while (true) {
            System.out.print(title);
            String str = sc.nextLine();
            if (str.isBlank()) {
                System.out.println("Không được để trống");
            } else if (str.length() < 6) {
                System.out.println("Tối thiểu 6 kí tự");
            } else {
                return str;
            }
        }
    }

    // Phương thức mới không có validation phức tạp
    public static String inputString(String title, boolean allowBlank) {
        System.out.print(title);
        String str = sc.nextLine();
        if (!allowBlank && str.isBlank()) {
            System.out.println("Không được để trống.");
            return inputString(title, allowBlank);
        }
        return str;
    }


    public static int inputIntegerPositive(String title) {
        while (true) {
            System.out.print(title);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    System.out.println("Vui lòng nhập số lớn hơn 0");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không đúng định dạng hãy nhập lại");
            }

        }
    }

    public static int inputInteger(String title, int min, int max) {
        while (true) {
            System.out.print(title);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num < min || num > max) {
                    System.out.println("Vui lòng nhập số trong khoảng từ " + min + " đến " + max + ".");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không đúng định dạng. Vui lòng nhập lại một số.");
            }
        }
    }


    public static double inputDoublePositive(String title) {
        while (true) {
            System.out.print(title);
            try {
                double num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    System.out.println("Vui lòng nhập số lớn hơn 0");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập không đúng định dạng hãy nhập lại");
            }
        }
    }
}
