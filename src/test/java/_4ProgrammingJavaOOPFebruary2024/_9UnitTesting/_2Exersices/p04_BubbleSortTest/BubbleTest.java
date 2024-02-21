package _4ProgrammingJavaOOPFebruary2024._9UnitTesting._2Exersices.p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    public static final int[] NUMBERS = {34, 2, 0, 45, 76, 23, 1, 8, 897, 39, 54};
    public static final int[] EXPECTED_NUMBERS = {0, 1, 2, 8, 23, 34, 39, 45, 54, 76, 897};

    @Test
    public void testBubbleSort() {
        Bubble.sort(NUMBERS);
        Assert.assertArrayEquals(NUMBERS, EXPECTED_NUMBERS);
    }
}