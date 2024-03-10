package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._14JavaOOPRegularExam11December2021.cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTest {

    House house;
    Cat cat;
    @Before
    public void setUp() throws Exception {
        house = new House("House1", 2);
        cat = new Cat("Cat1");
        house.addCat(cat);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("House1", house.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, house.getCapacity());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCatNoSpace() throws IllegalArgumentException {
        Cat cat2 = new Cat("Cat2");
        Cat cat3 = new Cat("Cat3");
        house.addCat(cat2);
        house.addCat(cat3);
    }

    @Test
    public void testAddCat() {
        Cat cat2 = new Cat("Cat2");
        house.addCat(cat2);
        Assert.assertEquals(2, house.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveCatInvalid() throws IllegalArgumentException {
        house.removeCat("Cat2");
    }

    @Test
    public void testRemoveCat() {
        house.removeCat("Cat1");
        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleInvalid() throws IllegalArgumentException {
        house.catForSale("Cat2");
    }

    @Test
    public void testCatForSale() {
        house.catForSale("Cat1");
        Assert.assertFalse(cat.isHungry());
    }

    @Test
    public void testStatistics() {
        Assert.assertEquals("The cat Cat1 is in the house House1!", house.statistics());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityInvalid() throws IllegalArgumentException {
        House house2 = new House("House2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        House house2 = new House("House2", 5);
        Assert.assertEquals(5, house2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        House house2 = new House("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        House house2 = new House(null, 5);
    }

    @Test
    public void testSetName() {
        House house2 = new House("House2", 5);
        Assert.assertEquals("House2", house2.getName());
    }
}