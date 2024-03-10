package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._11JavaOOPRetakeExam18April2022.petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTest {

    PetStore petStore;
    Animal animal;
    @Before
    public void setUp() throws Exception {
        petStore = new PetStore();
        animal = new Animal("Specie1", 10, 100.00);
        petStore.addAnimal(animal);
    }

    @Test
    public void testGetAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        Assert.assertEquals(animals, petStore.getAnimals());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms() {
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        Assert.assertEquals(animals, petStore.findAllAnimalsWithMaxKilograms(5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddAnimalNull() throws IllegalArgumentException {
        Animal animal2 = null;
        petStore.addAnimal(animal2);
    }

    @Test
    public void testAddAnimal() {
        Animal animal2 = new Animal("Specie2", 20, 200.00);
        petStore.addAnimal(animal2);
        Assert.assertEquals(2, petStore.getCount());
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        Animal animal2 = new Animal("Specie2", 20, 200.00);
        Animal animal3 = new Animal("Specie3", 30, 300.00);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        Assert.assertEquals(animal3, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAllAnimalBySpecie() {
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        Assert.assertEquals(animals, petStore.findAllAnimalBySpecie("Specie1"));
    }
}