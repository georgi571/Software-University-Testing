package _4ProgrammingJavaOOPFebruary2024._9UnitTesting._2Exercises.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public Database database;
    private static final Integer[] NUMBERS = {7, 45, 34, 12, 98, 23};
    private static final int SIZE_MORE_THAN_16 = 17;
    private static final int SIZE_LESS_THAN_1 = 0;
    private static final int ELEMENT_TO_ADD = 67;
    private static final int LAST_ELEMENT_AFTER_REMOVE_ELEMENT = NUMBERS[NUMBERS.length - 2];

    @Before
    public void prepareDateBase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasCreateValidObject() {
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, NUMBERS.length);
        for (int i = 0; i < elements.length; i++) {
            Assert.assertEquals(elements[i], NUMBERS[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[SIZE_MORE_THAN_16];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[SIZE_LESS_THAN_1];
        new Database(numbers);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(ELEMENT_TO_ADD);
        Assert.assertEquals(database.getElements().length, NUMBERS.length + 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(ELEMENT_TO_ADD));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements().length, NUMBERS.length - 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(LAST_ELEMENT_AFTER_REMOVE_ELEMENT));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowEmptyDataBase() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

}