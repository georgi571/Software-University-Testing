package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021.heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {

    HeroRepository heroRepository;
    Hero hero;
    @Before
    public void setUp() throws Exception {
        heroRepository = new HeroRepository();
        hero = new Hero("Hero1", 10);
        heroRepository.create(hero);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testCreateNone() throws NullPointerException {
        Hero hero2 = null;
        heroRepository.create(hero2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateExist() throws IllegalArgumentException {
        heroRepository.create(hero);
    }

    @Test
    public void testCreate() {
        Hero hero2 = new Hero("Hero2", 20);
        Assert.assertEquals("Successfully added hero Hero2 with level 20", heroRepository.create(hero2));
        Assert.assertEquals(2, heroRepository.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveNull() throws NullPointerException {
        heroRepository.remove(null);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveEmpty() throws NullPointerException {
        heroRepository.remove("");
    }

    @Test
    public void testRemoveFalse() {
        Assert.assertFalse(heroRepository.remove("Hero2"));
    }

    @Test
    public void testRemoveTrue() {
        Assert.assertTrue(heroRepository.remove("Hero1"));
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        Hero hero2 = new Hero("Hero2", 20);
        Hero hero3 = new Hero("Hero3", 30);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
        Assert.assertEquals(hero3, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHero() {
        Assert.assertEquals(hero, heroRepository.getHero("Hero1"));
    }
}