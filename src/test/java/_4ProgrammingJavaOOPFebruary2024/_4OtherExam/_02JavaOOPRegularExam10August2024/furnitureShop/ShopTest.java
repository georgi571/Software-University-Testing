package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024.furnitureShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

    private Shop shop;
    private Furniture furniture1;
    private Furniture furniture2;
    private Furniture furniture3;

    @BeforeEach
    void setUp() {
        shop = new Shop("MyShop", 3);
        furniture1 = new Furniture("Table", "Wooden", 100);
        furniture2 = new Furniture("Chair", "Plastic", 50);
        furniture3 = new Furniture("Sofa", "Leather", 200);
    }

    @Test
    void testAddFurniture() {
        shop.addFurniture(furniture1);
        assertEquals(1, shop.getCount());
        assertTrue(shop.getFurnitures().contains(furniture1));
    }

    @Test
    void testAddFurniture_NullFurniture() {
        assertThrows(IllegalArgumentException.class, () -> shop.addFurniture(null));
    }

    @Test
    void testAddFurniture_DuplicateFurniture() {
        shop.addFurniture(furniture1);
        assertThrows(IllegalArgumentException.class, () -> shop.addFurniture(furniture1));
    }

    @Test
    void testAddFurniture_NoMorePlaces() {
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        Furniture furniture4 = new Furniture("Desk", "Metal", 150);
        assertThrows(IllegalArgumentException.class, () -> shop.addFurniture(furniture4));
    }

    @Test
    void testRemoveFurniture() {
        shop.addFurniture(furniture1);
        assertTrue(shop.removeFurniture(furniture1.getType()));
        assertEquals(0, shop.getCount());
    }

    @Test
    void testRemoveFurniture_NonExistent() {
        shop.addFurniture(furniture1);
        assertFalse(shop.removeFurniture("NonExistent"));
    }

    @Test
    void testGetCheapestFurniture() {
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        assertEquals("Chair", shop.getCheapestFurniture());
    }

    @Test
    void testGetCapacity() {
        assertEquals(3, shop.getCapacity());
    }

    @Test
    void testSetCapacity_Invalid() {
        assertThrows(IllegalArgumentException.class, () -> shop.setCapacity(-1));
    }

    @Test
    void testSetCapacity_Valid() {
        shop.setCapacity(5);
        assertEquals(5, shop.getCapacity());
    }

    @Test
    void testFindAllFurnitureByType() {
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        List<Furniture> woodenFurniture = shop.findAllFurnitureByType("Wooden");
        assertEquals(1, woodenFurniture.size());
        assertTrue(woodenFurniture.contains(furniture1));
    }
}