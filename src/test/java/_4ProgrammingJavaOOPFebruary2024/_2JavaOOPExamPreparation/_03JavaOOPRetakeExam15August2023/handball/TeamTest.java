package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._03JavaOOPRetakeExam15August2023.handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    Team team;
    HandballPlayer handballPlayer;
    @Before
    public void setUp() throws Exception {
        team = new Team("Team1", 2);
        handballPlayer = new HandballPlayer("Player1");
        team.add(handballPlayer);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Team1", team.getName());
    }

    @Test
    public void testGetPosition() {
        Assert.assertEquals(2, team.getPosition());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, team.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddInFullTeam() throws IllegalArgumentException {
        HandballPlayer handballPlayer2 = new HandballPlayer("Player2");
        HandballPlayer handballPlayer3 = new HandballPlayer("Player3");
        team.add(handballPlayer2);
        team.add(handballPlayer3);
    }

    @Test
    public void testAdd() {
        HandballPlayer handballPlayer2 = new HandballPlayer("Player2");
        team.add(handballPlayer2);
        Assert.assertEquals(2, team.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveInvalidPlayer() throws IllegalArgumentException {
        team.remove("Player2");
    }

    @Test
    public void testRemove() {
        team.remove("Player1");
        Assert.assertEquals(0, team.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamInvalidPlayer() throws IllegalArgumentException{
        team.playerForAnotherTeam("Player2");
    }

    @Test
    public void testPlayerForAnotherTeam() {
        team.playerForAnotherTeam("Player1");
        Assert.assertFalse(handballPlayer.isActive());
    }

    @Test
    public void testGetStatistics() {
        Assert.assertEquals("The player Player1 is in the team Team1.", team.getStatistics());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetValidPositionInvalid() throws IllegalArgumentException {
        Team team2 = new Team("Team2", -1);
    }

    @Test
    public void testSetValidPosition() {
        Team team2 = new Team("Team2", 5);
        Assert.assertEquals(5, team2.getPosition());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        Team team2 = new Team("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Team team2 = new Team(null, 5);
    }

    @Test
    public void testSetName() {
        Team team2 = new Team("Team2", 5);
        Assert.assertEquals("Team2", team2.getName());
    }
}