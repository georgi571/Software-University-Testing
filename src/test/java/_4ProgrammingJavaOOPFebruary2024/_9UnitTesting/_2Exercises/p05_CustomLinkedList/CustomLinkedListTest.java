package _4ProgrammingJavaOOPFebruary2024._9UnitTesting._2Exercises.p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private static final String ELEMENT = "Cross Marian";
    private CustomLinkedList<String> customLinkedList;
    private static final int INDEX_FOR_EMPTY_LIST = 0;
    private static final int INDEX_OUT_OF_LIST = 3;
    private static final int VALID_INDEX = 0;
    private static final String ADD_ELEMENT = "Klaud Nine";
    private static final int GET_INDEX_OF_ADD_ELEMENT = 1;

    @Before
    public void prepareCustomLinkedList() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(ELEMENT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyLinkedListThrowException() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(INDEX_FOR_EMPTY_LIST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void indexGreaterThanElementsThrowException() {
        customLinkedList.get(INDEX_OUT_OF_LIST);
    }

    @Test
    public void elementsInLinkedListAndValidIndex() {
        Assert.assertEquals(customLinkedList.get(VALID_INDEX), ELEMENT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyLinkedListInvalidIndexThrowException() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.set(INDEX_OUT_OF_LIST, ADD_ELEMENT);
    }

    @Test
    public void validIndexSetElementOnIndex() {
        customLinkedList.set(VALID_INDEX, ADD_ELEMENT);
        Assert.assertEquals(customLinkedList.get(VALID_INDEX), ADD_ELEMENT);
    }

    @Test
    public void addElementToNotEmptyList() {
        customLinkedList.add(ADD_ELEMENT);
        Assert.assertEquals(customLinkedList.get(GET_INDEX_OF_ADD_ELEMENT), ADD_ELEMENT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtOnEmptyListThrowException() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.removeAt(INDEX_FOR_EMPTY_LIST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtInvalidIndexThrowException(){
        customLinkedList.removeAt(INDEX_OUT_OF_LIST);
    }
}