package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._10JavaOOPRegularExam14August2022.football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTest {

    FootballTeam footballTeam;
    Footballer footballer;
    @Before
    public void setUp() throws Exception {
        footballTeam = new FootballTeam("FootballTeam1", 2);
        footballer = new Footballer("Footballer1");
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("FootballTeam1", footballTeam.getName());
    }

    @Test
    public void testGetVacantPositions() {
        Assert.assertEquals(2, footballTeam.getVacantPositions());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFootballerNoSpace() throws IllegalArgumentException {
        Footballer footballer2 = new Footballer("Footballer2");
        Footballer footballer3 = new Footballer("Footballer3");
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
    }

    @Test
    public void testAddFootballer() {
        Footballer footballer2 = new Footballer("Footballer2");
        footballTeam.addFootballer(footballer2);
        Assert.assertEquals(2, footballTeam.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveFootballerInvalidFootballer() throws IllegalArgumentException{
        footballTeam.removeFootballer("Footballer2");
    }

    @Test
    public void testRemoveFootballer() {
        footballTeam.removeFootballer("Footballer1");
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleInvalid() throws IllegalArgumentException{
        footballTeam.footballerForSale("Footballer2");
    }

    @Test
    public void testFootballerForSale() {
        footballTeam.footballerForSale("Footballer1");
        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void testGetStatistics() {
        Assert.assertEquals("The footballer Footballer1 is in the team FootballTeam1.", footballTeam.getStatistics());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityInvalid() throws IllegalArgumentException {
        FootballTeam footballTeam2 = new FootballTeam("FootballTeam2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        FootballTeam footballTeam2 = new FootballTeam("FootballTeam2", 5);
        Assert.assertEquals(5, footballTeam2.getVacantPositions());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        FootballTeam footballTeam2 = new FootballTeam("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        FootballTeam footballTeam2 = new FootballTeam(null, 5);
    }

    @Test
    public void testSetName() {
        FootballTeam footballTeam2 = new FootballTeam("FootballTeam2", 5);
        Assert.assertEquals("FootballTeam2", footballTeam2.getName());
    }
}