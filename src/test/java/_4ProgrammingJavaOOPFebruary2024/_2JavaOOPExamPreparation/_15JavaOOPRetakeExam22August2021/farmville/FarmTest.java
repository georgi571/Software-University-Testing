package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._15JavaOOPRetakeExam22August2021.farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmTest {

    Farm farm;
    Animal animal;
    @Before
    public void setUp() throws Exception {
        farm = new Farm("Farm1", 2);
        animal = new Animal("Animal1", 10.00);
        farm.add(animal);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Farm1", farm.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, farm.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNoSpace() throws IllegalArgumentException {
        Animal animal2 = new Animal("Animal2", 20.00);
        Animal animal3 = new Animal("Animal3", 30.00);
        farm.add(animal2);
        farm.add(animal3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddExisting() throws IllegalArgumentException {
        farm.add(animal);
    }

    @Test
    public void testAdd() {
        Animal animal2 = new Animal("Animal2", 20.00);
        farm.add(animal2);
        Assert.assertEquals(2, farm.getCount());
    }

    @Test
    public void testRemoveFalse() {
        Assert.assertFalse(farm.remove("Animal2"));
    }

    @Test
    public void testRemoveTrue() {
        Assert.assertTrue(farm.remove("Animal1"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityInvalid() throws IllegalArgumentException {
        Farm farm2 = new Farm("Farm2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        Farm farm2 = new Farm("Farm2", 5);
        Assert.assertEquals(5, farm2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        Farm farm2 = new Farm("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Farm farm2 = new Farm(null, 5);
    }

    @Test
    public void testSetName() {
        Farm farm2 = new Farm("Farm2", 5);
        Assert.assertEquals("Farm2", farm2.getName());
    }
}