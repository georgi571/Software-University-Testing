package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._21JavaOOPRetakeExam22August2020.garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GarageTest {

    Garage garage;
    Car car;
    @Before
    public void setUp() throws Exception {
        garage = new Garage();
        car = new Car("Car1", 100, 10000.00);
        garage.addCar(car);
    }

    @Test
    public void testGetCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(cars, garage.getCars());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, garage.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Car car2 = new Car("Car2", 50, 5000.00);
        garage.addCar(car2);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(cars, garage.findAllCarsWithMaxSpeedAbove(60));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCarNull() throws IllegalArgumentException {
        Car car2 = null;
        garage.addCar(car2);
    }

    @Test
    public void testAddCar() {
        Car car2 = new Car("Car2", 50, 5000.00);
        garage.addCar(car2);
        Assert.assertEquals(2, garage.getCount());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car car2 = new Car("Car2", 50, 5000.00);
        garage.addCar(car2);
        Assert.assertEquals(car, garage.getTheMostExpensiveCar());
    }

    @Test
    public void testFindAllCarsByBrand() {
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(cars, garage.findAllCarsByBrand("Car1"));
    }
}