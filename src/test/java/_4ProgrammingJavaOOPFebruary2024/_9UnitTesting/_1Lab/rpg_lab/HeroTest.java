package _4ProgrammingJavaOOPFebruary2024._9UnitTesting._1Lab.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.*;

public class HeroTest {
    private final static int TARGET_EXPERIENCE = 10;

    private Dummy dummy;
    private Axe axe;
    private Hero hero;
    Weapon weaponMock;
    Target targetMock;

    @Before
    public void setup() {
        weaponMock = Mockito.mock(Weapon.class);
        targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_EXPERIENCE);
        hero = new Hero("Cross Marian", weaponMock);
    }

    @Test
    public void testHeroGainXPWhenTargetDies() {
        hero.attack(targetMock);
        Assert.assertEquals(TARGET_EXPERIENCE, hero.getExperience());
    }

}