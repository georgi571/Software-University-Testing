package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._09JavaOOPRetakeExam22August2022.archeologicalExcavations;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023.robots.Service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTest {

    Excavation excavation;
    Archaeologist archaeologist;
    @Before
    public void setUp() throws Exception {
        excavation = new Excavation("Excavation1", 2);
        archaeologist = new Archaeologist("Archaeologist1", 10.5);
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Excavation1", excavation.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, excavation.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddArchaeologistNoSpace() throws IllegalArgumentException {
        Archaeologist archaeologist2 = new Archaeologist("Archaeologist2", 11.5);
        Archaeologist archaeologist3= new Archaeologist("Archaeologist3", 12.5);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddArchaeologistExisting() throws IllegalArgumentException {
        excavation.addArchaeologist(archaeologist);
    }

    @Test
    public void testAddArchaeologist() {
        Archaeologist archaeologist2 = new Archaeologist("Archaeologist2", 11.5);
        excavation.addArchaeologist(archaeologist2);
        Assert.assertEquals(2, excavation.getCount());
    }

    @Test
    public void testRemoveArchaeologistFalse() {
        Assert.assertFalse(excavation.removeArchaeologist("Archaeologist2"));
    }

    @Test
    public void testRemoveArchaeologistTrue() {
        Assert.assertTrue(excavation.removeArchaeologist("Archaeologist1"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityInvalid() throws IllegalArgumentException {
        Excavation excavation2 = new Excavation("Excavation2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        Excavation excavation2 = new Excavation("Excavation2", 5);
        Assert.assertEquals(5, excavation2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        Excavation excavation2 = new Excavation("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Excavation excavation2 = new Excavation(null, 5);
    }

    @Test
    public void testSetName() {
        Excavation excavation2 = new Excavation("Excavation2", 5);
        Assert.assertEquals("Excavation2", excavation2.getName());
    }
}