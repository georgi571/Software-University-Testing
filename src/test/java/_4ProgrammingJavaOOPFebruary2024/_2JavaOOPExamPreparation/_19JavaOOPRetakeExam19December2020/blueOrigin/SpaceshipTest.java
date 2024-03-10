package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020.blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTest {

    Spaceship spaceship;
    Astronaut astronaut;
    @Before
    public void setUp() throws Exception {
        spaceship = new Spaceship("Spaceship1", 2);
        astronaut = new Astronaut("Astronaut1", 10.00);
        spaceship.add(astronaut);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Spaceship1", spaceship.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, spaceship.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNoSpace() throws IllegalArgumentException {
        Astronaut astronaut2 = new Astronaut("Astronaut2", 20.00);
        Astronaut astronaut3 = new Astronaut("Astronaut3", 30.00);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddExist() throws IllegalArgumentException {
        spaceship.add(astronaut);
    }

    @Test
    public void testAdd() {
        Astronaut astronaut2 = new Astronaut("Astronaut2", 20.00);
        spaceship.add(astronaut2);
    }

    @Test
    public void testRemoveFalse() {
        Assert.assertFalse(spaceship.remove("Astronaut2"));
    }

    @Test
    public void testRemoveTrue() {
        Assert.assertTrue(spaceship.remove("Astronaut1"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityInvalid() throws IllegalArgumentException {
        Spaceship spaceship2 = new Spaceship("Spaceship2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        Spaceship spaceship2 = new Spaceship("Spaceship2", 5);
        Assert.assertEquals(5, spaceship2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        Spaceship spaceship2 = new Spaceship("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Spaceship spaceship2 = new Spaceship(null, 5);
    }

    @Test
    public void testSetName() {
        Spaceship spaceship2 = new Spaceship("Spaceship2", 5);
        Assert.assertEquals("Spaceship2", spaceship2.getName());
    }
}