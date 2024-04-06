package _4ProgrammingJavaOOPFebruary2024._3Exam._JavaOOPRegularExam6April2024.busyWaiters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTests {
    Restaurant restaurant;
    int capacity;
    String name;
    FullTimeWaiter waiter1;
    FullTimeWaiter waiter2;

    @Before
    public void setUp() throws Exception {
        name = "BestRestaurant";
        capacity = 3;
        restaurant = new Restaurant(name, capacity);
        waiter1 = new FullTimeWaiter("Waiter1", 8);
        waiter2 = new FullTimeWaiter("Waiter2", 5);
        restaurant.addFullTimeWaiter(waiter1);
        restaurant.addFullTimeWaiter(waiter2);

    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(3, restaurant.getCapacity());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("BestRestaurant", restaurant.getName());
    }

    @Test
    public void testGetWaiters() {
        List<FullTimeWaiter> waiters = new ArrayList<>();
        waiters.add(waiter1);
        waiters.add(waiter2);
        Assert.assertEquals(waiters, restaurant.getWaiters());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(2, restaurant.getWaiters().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFullTimeWaiterNoCapacity() throws IllegalArgumentException {
        FullTimeWaiter waiter3 = new FullTimeWaiter("Waiter3", 4);
        FullTimeWaiter waiter4 = new FullTimeWaiter("Waiter4", 2);
        restaurant.addFullTimeWaiter(waiter3);
        restaurant.addFullTimeWaiter(waiter4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFullTimeWaiterAlreadyExist() throws IllegalArgumentException {
        FullTimeWaiter waiter3 = new FullTimeWaiter("Waiter2", 5);
        restaurant.addFullTimeWaiter(waiter3);
    }

    @Test
    public void testAddFullTimeWaiter() {
        FullTimeWaiter waiter3 = new FullTimeWaiter("Waiter3", 4);
        restaurant.addFullTimeWaiter(waiter3);
        Assert.assertEquals(3, restaurant.getWaiters().size());
    }

    @Test
    public void testRemoveFullTimeFalse() {
        Assert.assertFalse(restaurant.removeFullTimeWaiter("Waiter5"));
    }

    @Test
    public void testRemoveFullTimeTrue() {
        Assert.assertTrue(restaurant.removeFullTimeWaiter("Waiter2"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetInvalidCapacity() throws IllegalArgumentException{
        Restaurant restaurant2 = new Restaurant("Restaurant2", -1);
    }

    @Test
    public void testSetValidCapacity(){
        Restaurant restaurant2 = new Restaurant("Restaurant2", 2);
        Assert.assertEquals(2, restaurant2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetInvalidNameNull() throws NullPointerException{
        Restaurant restaurant2 = new Restaurant(null, 2);
    }

    @Test (expected = NullPointerException.class)
    public void testSetInvalidName() throws NullPointerException{
        Restaurant restaurant2 = new Restaurant("", 2);
    }

    @Test
    public void testSetValidName(){
        Restaurant restaurant2 = new Restaurant("Restaurant2", 2);
        Assert.assertEquals("Restaurant2", restaurant2.getName());
    }
}