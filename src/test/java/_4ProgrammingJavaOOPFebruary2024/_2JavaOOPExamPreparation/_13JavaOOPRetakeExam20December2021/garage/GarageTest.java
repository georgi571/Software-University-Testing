package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._13JavaOOPRetakeExam20December2021.garage;

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
        car = new Car("Car1", 200, 20000.00);
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
        Car car2 = new Car("Car2", 150, 21000.00);
        garage.addCar(car2);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Assert.assertEquals(cars, garage.findAllCarsWithMaxSpeedAbove(180));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCarNull() throws IllegalArgumentException {
        Car car2 = null;
        garage.addCar(car2);
    }

    @Test
    public void testAddCar() {
        Car car2 = new Car("Car2", 210, 21000.00);
        garage.addCar(car2);
        Assert.assertEquals(2, garage.getCount());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car car2 = new Car("Car2", 210, 21000.00);
        Car car3 = new Car("Car3", 220, 22000.00);
        garage.addCar(car2);
        garage.addCar(car3);
        Assert.assertEquals(car3, garage.getTheMostExpensiveCar());
    }

    @Test
    public void testFindAllCarsByBrand() {
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Car car2 = new Car("Car2", 210, 21000.00);
        Car car3 = new Car("Car3", 220, 22000.00);
        garage.addCar(car2);
        garage.addCar(car3);
        Assert.assertEquals(cars, garage.findAllCarsByBrand("Car1"));
    }
}