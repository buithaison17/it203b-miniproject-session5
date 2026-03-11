package services;

import models.Drink;
import models.Food;
import models.MenuItem;
import presentation.FoodMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuItemService {
    List<MenuItem> list = new ArrayList<>();

    public MenuItemService() {
        // Dummy data
        list.add(new Food("F01", "Phở Bò", 50000, 100, "Bát"));
        list.add(new Food("F02", "Bún Chả", 45000, 80, "Đĩa"));
        list.add(new Drink("D01", "Trà Đá", 5000, 200, "Cốc"));
        list.add(new Drink("D02", "Cà Phê", 25000, 150, "Cốc"));
    }

    public void add(MenuItem item) {
        list.add(item);
        System.out.println("Thêm thành công");
    }

    public void delete(MenuItem item) {
        list.remove(item);
        System.out.println("Xóa thành công");
    }

    public List<MenuItem> getList() {
        return list;
    }

    public MenuItem findById(String id) {
        for (MenuItem item : list) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }
}
