package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023.robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTest {

    Service service;
    Robot robot;
    @Before
    public void setUp() throws Exception {
        service = new Service("Service1", 2);
        robot = new Robot("Robot1");
        service.add(robot);
    }

    @Test
    public void getName() {
        Assert.assertEquals("Service1", service.getName());
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(2, service.getCapacity());
    }

    @Test
    public void getCount() {
        Assert.assertEquals(1, service.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddRobotInFullService() throws IllegalArgumentException {
        Robot robot2 = new Robot("Robot2");
        Robot robot3 = new Robot("Robot3");
        service.add(robot2);
        service.add(robot3);
    }

    @Test
    public void testAdd() {
        Robot robot2 = new Robot("Robot2");
        service.add(robot2);
        Assert.assertEquals(2, service.getCount());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveInvalidRobot() throws IllegalArgumentException {
        service.remove("Robot2");
    }

    @Test
    public void testRemove() {
        service.remove("Robot1");
        Assert.assertEquals(0, service.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForSaleInvalidRobot() throws IllegalArgumentException{
        service.forSale("Robot2");
    }

    @Test
    public void testForSale() {
        service.forSale("Robot1");
        Assert.assertFalse(robot.isReadyForSale());
    }

    @Test
    public void testReport() {
        Assert.assertEquals("The robot Robot1 is in the service Service1!", service.report());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityInvalid() throws IllegalArgumentException {
        Service service2 = new Service("Service2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        Service service2 = new Service("Service2", 5);
        Assert.assertEquals(5, service2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        Service service2 = new Service("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Service service2 = new Service(null, 5);
    }

    @Test
    public void testSetName() {
        Service service2 = new Service("Service2", 5);
        Assert.assertEquals("Service2", service2.getName());
    }
}