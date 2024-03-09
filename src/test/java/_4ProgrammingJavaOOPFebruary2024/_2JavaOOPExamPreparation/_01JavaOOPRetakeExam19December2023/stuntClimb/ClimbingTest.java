package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023.stuntClimb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingTest {
    Climbing climbing;
    RockClimber rockClimber;

    @Before
    public void setUp() throws Exception {
        climbing = new Climbing("Mountain1", 2);
        rockClimber = new RockClimber("rock1", 1.50);
        climbing.addRockClimber(rockClimber);
    }

    @Test
    public void getCount() {
        Assert.assertEquals(1, climbing.getCount());
    }

    @Test
    public void getName() {
        Assert.assertEquals("Mountain1", climbing.getName());
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(2, climbing.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRockClimberNoFreeSpace() throws IllegalArgumentException{
        RockClimber rockClimber2 = new RockClimber("rock2", 2.50);
        RockClimber rockClimber3 = new RockClimber("rock3", 3.50);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRockClimberExisting() throws IllegalArgumentException{
        RockClimber rockClimber2 = new RockClimber("rock1", 2.50);
        climbing.addRockClimber(rockClimber2);
    }

    @Test
    public void addRockClimber() {
        RockClimber rockClimber2 = new RockClimber("rock2", 2.50);
        climbing.addRockClimber(rockClimber2);
    }

    @Test
    public void removeRockClimberInvalid() {
        boolean isRemoved = climbing.removeRockClimber("rock2");
        Assert.assertFalse(isRemoved);
    }

    @Test
    public void removeRockClimber() {
        boolean isRemoved = climbing.removeRockClimber("rock1");
        Assert.assertTrue(isRemoved);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Climbing climbing2 = new Climbing(null, 2);
    }

    @Test
    public void testSetName() {
        Climbing climbing2 = new Climbing("Mountain2", 2);
        Assert.assertEquals("Mountain2", climbing2.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityZero() throws IllegalArgumentException{
        Climbing climbing2 = new Climbing("Mountain2", -1);
    }

    @Test
    public void testSetCapacityTwo() {
        Climbing climbing2 = new Climbing("Mountain2", 2);
        Assert.assertEquals(2, climbing2.getCapacity());
    }
}