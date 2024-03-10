package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020.computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTest {

    ComputerManager computerManager;
    Computer computer;

    @Before
    public void setUp() throws Exception {
        computerManager = new ComputerManager();
        computer = new Computer("Computer1", "Model1", 1000.00);
        computerManager.addComputer(computer);
    }

    @Test
    public void testGetComputers() {
        List<Computer> computers = new ArrayList<>();
        computers.add(computer);
        Assert.assertEquals(computers, computerManager.getComputers());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerNull() throws IllegalArgumentException {
        Computer computer2 = null;
        computerManager.addComputer(computer2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerExist() throws IllegalArgumentException {
        computerManager.addComputer(computer);
    }

    @Test
    public void testAddComputer() {
        Computer computer2 = new Computer("Computer2", "Model2", 1000.00);
        computerManager.addComputer(computer2);
        Assert.assertEquals(2, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerNullManufacturer() throws IllegalArgumentException {
        computerManager.removeComputer(null, "Model1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerNullModel() throws IllegalArgumentException {
        computerManager.removeComputer("Computer1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerInvalid() throws IllegalArgumentException {
        computerManager.removeComputer("Computer2", "Model2");
    }

    @Test
    public void testRemoveComputer() {
        computerManager.removeComputer("Computer1", "Model1");
        Assert.assertEquals(0, computerManager.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerNull() throws IllegalArgumentException {
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturer() {
        List<Computer> computers = new ArrayList<>();
        computers.add(computer);
        Assert.assertEquals(computers, computerManager.getComputersByManufacturer("Computer1"));
    }
}