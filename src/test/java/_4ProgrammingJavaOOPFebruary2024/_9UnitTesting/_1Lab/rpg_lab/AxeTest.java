package _4ProgrammingJavaOOPFebruary2024._9UnitTesting._1Lab.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private final static int AXE_ATTACK = 10;
    private final static int AXE_DURABILITY = 10;
    private final static int AXE_WITHOUT_DURABILITY = 0;
    private final static int AXE_DURABILITY_LOSS = 1;
    private final static int DUMMY_START_HEALTH = 100;
    private final static int DUMMY_EXPERIENCE = 10;

    private Dummy dummy;
    private Axe axe;
    private Axe brokenAxe;

    @Before
    public void setup(){
        dummy = new Dummy(DUMMY_START_HEALTH, DUMMY_EXPERIENCE);
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        brokenAxe = new Axe(AXE_ATTACK, AXE_WITHOUT_DURABILITY);
    }

    @Test
    public void testAxeLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(AXE_DURABILITY - AXE_DURABILITY_LOSS, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackWithBrokenAxeShouldThrowException() {
        brokenAxe.attack(dummy);
    }
}