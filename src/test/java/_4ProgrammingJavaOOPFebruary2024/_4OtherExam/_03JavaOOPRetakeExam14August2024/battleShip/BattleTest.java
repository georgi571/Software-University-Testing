package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024.battleShip;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024.battleShip.Battle;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024.battleShip.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {

    private Battle battle;
    private Ship ship1;
    private Ship ship2;
    private Ship ship3;

    @BeforeEach
    void setUp() {
        battle = new Battle("Battle1", 3);
        ship1 = new Ship("Destroyer", "RoyalBattleship", 150, 120, 50);
        ship2 = new Ship("Submarine", "RoyalBattleship", 200, 80, 70);
        ship3 = new Ship("Battleship", "RoyalBattleship", 180, 150, 60);
    }

    @Test
    void testAddShip() {
        battle.addShip(ship1);
        assertEquals(1, battle.getCount());
        assertThrows(IllegalArgumentException.class, () -> battle.addShip(ship1), "The ship Destroyer already exists!");
    }

    @Test
    void testAddShipCapacityExceeded() {
        battle.addShip(ship1);
        battle.addShip(ship2);
        battle.addShip(ship3);
        assertThrows(IllegalArgumentException.class, () -> battle.addShip(new Ship("Carrier", "TypeD", 220, 200, 80)), "No more places!");
    }

    @Test
    void testRemoveShip() {
        battle.addShip(ship1);
        boolean removed = battle.removeShip(ship1.getType());
        assertTrue(removed);
        assertEquals(0, battle.getCount());
    }

    @Test
    void testRemoveShipNotExists() {
        battle.addShip(ship1);
        boolean removed = battle.removeShip("NonExistingShip");
        assertFalse(removed);
        assertEquals(1, battle.getCount());
    }

    @Test
    void testGetMostPowerfulShip() {
        battle.addShip(ship1);
        battle.addShip(ship2);
        battle.addShip(ship3);
        assertEquals("Submarine", battle.getMostPowerfulShip());
    }

    @Test
    void testFindAllShipByAmmunitionMoreThan100() {
        battle.addShip(ship1);
        battle.addShip(ship2);
        battle.addShip(ship3);
        List<Ship> result = battle.findAllShipByAmmunitionMoreThan100();
        assertEquals(2, result.size());
        assertTrue(result.contains(ship1));
        assertTrue(result.contains(ship3));
    }
}
