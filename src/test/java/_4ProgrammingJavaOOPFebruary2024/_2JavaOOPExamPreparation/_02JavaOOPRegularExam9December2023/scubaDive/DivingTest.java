package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023.scubaDive;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivingTest {

    Diving diving;
    DeepWaterDiver diver;
    @Before
    public void setUp() throws Exception {
        diving = new Diving("Diving1", 2);
        diver = new DeepWaterDiver("Diver1", 1.5);
        diving.addDeepWaterDiver(diver);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, diving.getCount());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Diving1", diving.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, diving.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddDeepWaterDiverNoSize() throws IllegalArgumentException {
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("Diver2", 2.5);
        DeepWaterDiver deepWaterDiver3 = new DeepWaterDiver("Diver3", 3.5);
        diving.addDeepWaterDiver(deepWaterDiver2);
        diving.addDeepWaterDiver(deepWaterDiver3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddDeepWaterDiverExist() throws IllegalArgumentException {
        diving.addDeepWaterDiver(diver);
    }

    @Test
    public void testAddDeepWaterDiver() {
        DeepWaterDiver deepWaterDiver2 = new DeepWaterDiver("Diver2", 2.5);
        diving.addDeepWaterDiver(deepWaterDiver2);
        Assert.assertEquals(2, diving.getCount());
    }

    @Test
    public void testRemoveDeepWaterDiverInvalid() {
        Assert.assertFalse(diving.removeDeepWaterDiver("Diver2"));
    }

    @Test
    public void testRemoveDeepWaterDiver() {
        Assert.assertTrue(diving.removeDeepWaterDiver("Diver1"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetInvalidCapacity() throws IllegalArgumentException {
        Diving diving2 = new Diving("Diving2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        Diving diving2 = new Diving("Diving2", 5);
        Assert.assertEquals(5, diving2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        Diving diving2 = new Diving("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Diving diving2 = new Diving(null, 5);
    }

    @Test
    public void testSetName() {
        Diving diving2 = new Diving("Diving2", 5);
        Assert.assertEquals("Diving2", diving2.getName());
    }
}