package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._08JavaOOPRegularExam10December2022.toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ToyStoreTest {

    ToyStore toyStore;
    Toy toy;
    @Before
    public void setUp() throws Exception {
        toyStore = new ToyStore();
        toy = new Toy("Toy", "1");
        toyStore.addToy("A", toy);
    }

    @Test
    public void testConstructor() {
        ToyStore toyStore2 = new ToyStore();
        Map<String, Toy> toys = new HashMap<>();
        toys.put("A", null);
        toys.put("B", null);
        toys.put("C", null);
        toys.put("D", null);
        toys.put("E", null);
        toys.put("F", null);
        toys.put("G", null);
        Assert.assertEquals(toys, toyStore2.getToyShelf());
    }

    @Test
    public void testGetToyShelf() {
        Map<String, Toy> toys = new HashMap<>();
        toys.put("A", toy);
        toys.put("B", null);
        toys.put("C", null);
        toys.put("D", null);
        toys.put("E", null);
        toys.put("F", null);
        toys.put("G", null);
        Assert.assertEquals(toys, toyStore.getToyShelf());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddToyInvalidShelf() throws OperationNotSupportedException {
        Toy toy2 = new Toy("Toy2", "2");
        toyStore.addToy("T", toy2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddToyExistingShelf() throws OperationNotSupportedException {
        Toy toy2 = new Toy("Toy2", "2");
        toyStore.addToy("A", toy2);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddToyExistingToy() throws OperationNotSupportedException {
        toyStore.addToy("B", toy);
    }

    @Test
    public void testAddToy() throws OperationNotSupportedException {
        Toy toy2 = new Toy("Toy2", "2");
        toyStore.addToy("B", toy2);
        Assert.assertEquals(toy2, toyStore.getToyShelf().get("B"));
        Assert.assertEquals("Toy: 1 placed successfully!", String.format("Toy: 1 placed successfully!", toy2.getToyId()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyInvalidShelf() throws IllegalArgumentException{
        toyStore.removeToy("T", toy);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyInvalidToy() throws IllegalArgumentException {
        Toy toy2 = new Toy("Toy2", "2");
        toyStore.removeToy("A", toy2);
    }

    @Test
    public void testRemoveToy() {
        Assert.assertEquals("Remove toy:1 successfully!", toyStore.removeToy("A", toy));
        Assert.assertNull(toyStore.getToyShelf().get("A"));
    }

}