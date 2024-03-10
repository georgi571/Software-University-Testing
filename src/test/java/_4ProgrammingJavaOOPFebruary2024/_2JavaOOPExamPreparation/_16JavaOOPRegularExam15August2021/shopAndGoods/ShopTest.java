package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._16JavaOOPRegularExam15August2021.shopAndGoods;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ShopTest {

    Shop shop;
    Goods goods;
    @Before
    public void setUp() throws Exception {
        shop = new Shop();
        goods = new Goods("Goods1", "Code1");
        shop.addGoods("Shelves1", goods);
    }

    @Test
    public void testGetShelves() {
        Map<String, Goods> shelves = new HashMap<>();
        shelves.put("Shelves1", goods);
        shelves.put("Shelves2", null);
        shelves.put("Shelves3", null);
        shelves.put("Shelves4", null);
        shelves.put("Shelves5", null);
        shelves.put("Shelves6", null);
        shelves.put("Shelves7", null);
        shelves.put("Shelves8", null);
        shelves.put("Shelves9", null);
        shelves.put("Shelves10", null);
        shelves.put("Shelves11", null);
        shelves.put("Shelves12", null);
        Assert.assertEquals(shelves, shop.getShelves());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoodsInvalidShelf() throws OperationNotSupportedException, IllegalArgumentException {
        Goods goods2 = new Goods("Goods2", "Code2");
        shop.addGoods("Shelves13", goods2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoodsExistingGoodsInShelf() throws OperationNotSupportedException, IllegalArgumentException {
        Goods goods2 = new Goods("Goods2", "Code2");
        shop.addGoods("Shelves1", goods2);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddGoodsExistingGoods() throws OperationNotSupportedException, IllegalArgumentException {
        shop.addGoods("Shelves2", goods);
    }

    @Test
    public void testAddGoods() throws OperationNotSupportedException, IllegalArgumentException {
        Goods goods2 = new Goods("Goods2", "Code2");
        shop.addGoods("Shelves2", goods2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveGoodsInvalidShelves() {
        shop.removeGoods("Shelves13", goods);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveGoodsInvalidGoods() {
        Goods goods2 = new Goods("Goods2", "Code2");
        shop.removeGoods("Shelves1", goods2);
    }

    @Test
    public void testRemoveGoods() {
        Assert.assertEquals("Goods: Code1 is removed successfully!", shop.removeGoods("Shelves1", goods));
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }
}