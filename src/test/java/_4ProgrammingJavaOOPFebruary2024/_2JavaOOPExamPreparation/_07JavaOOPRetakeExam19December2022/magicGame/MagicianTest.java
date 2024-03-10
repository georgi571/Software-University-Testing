package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022.magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MagicianTest {

    Magician magician;
    Magic magic;
    @Before
    public void setUp() throws Exception {
        magician = new Magician("Magician1", 10);
        magic = new Magic("Magic1", 10);
        magician.addMagic(magic);
    }

    @Test
    public void testGetUsername() {
        Assert.assertEquals("Magician1", magician.getUsername());
    }

    @Test
    public void testGetHealth() {
        Assert.assertEquals(10, magician.getHealth());
    }

    @Test
    public void testGetMagics() {
        List<Magic> magics = new ArrayList<>();
        magics.add(magic);
        Assert.assertEquals(magics, magician.getMagics());
    }

    @Test (expected = IllegalStateException.class)
    public void testTakeDamageZeroHealth() throws IllegalStateException {
        magician.takeDamage(10);
        magician.takeDamage(20);
    }

    @Test
    public void testTakeDamageLeftWithZeroHealth() {
        magician.takeDamage(10);
        Assert.assertEquals(0, magician.getHealth());
    }

    @Test
    public void testTakeDamageLeftWithMoreThanZeroHealth() {
        magician.takeDamage(5);
        Assert.assertEquals(5, magician.getHealth());
    }

    @Test (expected = NullPointerException.class)
    public void testAddMagicNull() throws NullPointerException {
        Magic magic2 = null;
        magician.addMagic(magic2);
    }

    @Test
    public void testAddMagic() {
        Magic magic2 = new Magic("Magic2", 20);
        magician.addMagic(magic2);
        Assert.assertEquals(2, magician.getMagics().size());
    }

    @Test
    public void removeMagicFalse() {
        Magic magic2 = new Magic("Magic2", 20);
        Assert.assertFalse(magician.removeMagic(magic2));
    }

    @Test
    public void removeMagicTrue() {
        Assert.assertTrue(magician.removeMagic(magic));
    }

    @Test
    public void getMagic() {
        Assert.assertEquals(magic, magician.getMagic("Magic1"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHealthInvalid() throws IllegalArgumentException {
        Magician magician2 = new Magician("Magician2", -1);
    }

    @Test
    public void testSetValidHealth() {
        Magician magician2 = new Magician("Magician2", 5);
        Assert.assertEquals(5, magician2.getHealth());
    }

    @Test (expected = NullPointerException.class)
    public void testSetUserNameInvalid() throws NullPointerException{
        Magician magician2 = new Magician("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetUserNameNull() throws NullPointerException{
        Magician magician2 = new Magician(null, 5);
    }

    @Test
    public void testSetUserName() {
        Magician magician2 = new Magician("Magician2", 5);
        Assert.assertEquals("Magician2", magician2.getUsername());
    }
}