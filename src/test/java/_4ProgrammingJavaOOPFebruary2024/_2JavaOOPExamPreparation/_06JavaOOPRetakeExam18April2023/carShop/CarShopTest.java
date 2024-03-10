package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023.carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarShopTest {

    CarShop carShop;
    Car car;
    @Before
    public void setUp() throws Exception {
        carShop = new CarShop();
        car = new Car("Car1", 100, 1000);
        carShop.add(car);
    }

    @Test
    public void getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(cars, carShop.getCars());
    }

    @Test
    public void getCount() {
        Assert.assertEquals(1, carShop.getCount());
    }

    @Test
    public void findAllCarsWithMaxHorsePower() {
        List<Car> cars = new ArrayList<>();
        for (Car carShopCar : carShop.getCars()) {
            if (carShopCar.getHorsePower() > 50) {
                cars.add(carShopCar);
            }
        }
        Assert.assertEquals(cars, carShop.findAllCarsWithMaxHorsePower(50));
    }

    @Test (expected = NullPointerException.class)
    public void testAddCarNull() throws NullPointerException {
        Car car2 = null;
        carShop.add(car2);
    }

    @Test
    public void testAdd() {
        Car car2 = new Car("Car2", 200, 2000);
        carShop.add(car2);
        Assert.assertEquals(2, carShop.getCount());
    }

    @Test
    public void testRemoveFalse() {
        Car car2 = new Car("Car2", 200, 2000);
        Assert.assertFalse(carShop.remove(car2));
    }

    @Test
    public void testRemoveTrue() {
        Assert.assertTrue(carShop.remove(car));
    }

    @Test
    public void getTheMostLuxuryCar() {
        Car car2 = new Car("Car2", 200, 2000);
        Car car3 = new Car("Car3", 300, 3000);
        carShop.add(car2);
        carShop.add(car3);
        Car luxoryCar = null;
        Assert.assertEquals(car3, carShop.getTheMostLuxuryCar());
    }

    @Test
    public void findAllCarByModel() {
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(cars, carShop.findAllCarByModel("Car1"));
    }


}