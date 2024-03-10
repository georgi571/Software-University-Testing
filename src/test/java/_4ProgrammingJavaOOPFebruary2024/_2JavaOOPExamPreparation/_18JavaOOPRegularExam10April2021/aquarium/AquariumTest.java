package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._18JavaOOPRegularExam10April2021.aquarium;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023.robots.Service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTest {

    Aquarium aquarium;
    Fish fish;
    @Before
    public void setUp() throws Exception {
        aquarium = new Aquarium("Aquarium1", 2);
        fish = new Fish("Fish1");
        aquarium.add(fish);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Aquarium1", aquarium.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, aquarium.getCapacity());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNoSpace() throws IllegalArgumentException {
        Fish fish2 = new Fish("Fish2");
        Fish fish3 = new Fish("Fish3");
        aquarium.add(fish2);
        aquarium.add(fish3);
    }

    @Test
    public void testAdd() {
        Fish fish2 = new Fish("Fish2");
        aquarium.add(fish2);
        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveInvalid() throws IllegalArgumentException {
        aquarium.remove("Fish2");
    }

    @Test
    public void testRemove() {
        aquarium.remove("Fish1");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSellFishInvalid() throws IllegalArgumentException {
        aquarium.sellFish("Fish2");
    }

    @Test
    public void testSellFish() {
        aquarium.sellFish("Fish1");
        Assert.assertFalse(fish.isAvailable());
    }

    @Test
    public void testReport() {
        Assert.assertEquals("Fish available at Aquarium1: Fish1", aquarium.report());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityInvalid() throws IllegalArgumentException {
        Aquarium aquarium2 = new Aquarium("Aquarium2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        Aquarium aquarium2 = new Aquarium("Aquarium2", 5);
        Assert.assertEquals(5, aquarium2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        Aquarium aquarium2 = new Aquarium("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Aquarium aquarium2 = new Aquarium(null, 5);
    }

    @Test
    public void testSetName() {
        Aquarium aquarium2 = new Aquarium("Aquarium2", 5);
        Assert.assertEquals("Aquarium2", aquarium2.getName());
    }
}