package services;

import models.Drink;
import models.Food;
import models.MenuItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuItemServiceTest {

    // Test thêm món vào menu
    @Test
    void testAddMenuItem() {

        MenuItemService service = new MenuItemService();

        MenuItem food = new Food("F01", "Burger", 50000, 10, "fastfood");

        service.add(food);

        assertEquals(1, service.list.size());
        assertEquals("Burger", service.list.get(0).getName());
    }

    // Test xóa món khỏi menu
    @Test
    void testDeleteMenuItem() {

        MenuItemService service = new MenuItemService();

        MenuItem food = new Food("F01", "Burger", 50000, 10, "fastfood");

        service.add(food);
        service.delete(food);

        assertEquals(0, service.list.size());
    }

    // Test xóa khi danh sách rỗng
    @Test
    void testDeleteItemNotExist() {

        MenuItemService service = new MenuItemService();

        MenuItem food = new Food("F01", "Burger", 50000, 10, "fastfood");

        service.delete(food);

        assertEquals(0, service.list.size());
    }

    // Test tính giá Food loại healthy (+10%)
    @Test
    void testFoodCalculatePriceHealthy() {

        Food food = new Food("F02", "Salad", 40000, 10, "healthy");

        double price = food.calculatePrice();

        assertEquals(44000, price);
    }

    // Test tính giá Drink size L
    @Test
    void testDrinkCalculatePriceSizeL() {

        Drink drink = new Drink("D01", "Coca", 15000, 10, "L");

        double price = drink.calculatePrice();

        assertEquals(25000, price);
    }
}
