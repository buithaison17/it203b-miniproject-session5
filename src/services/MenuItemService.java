package services;

import models.MenuItem;
import presentation.FoodMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuItemService {
    List<MenuItem> list = new ArrayList<>();

    public void add(MenuItem item) {
        list.add(item);
        System.out.println("Thêm thành công");
    }

    public void delete(MenuItem item) {
        list.remove(item);
        System.out.println("Xóa thành công");
    }



}
