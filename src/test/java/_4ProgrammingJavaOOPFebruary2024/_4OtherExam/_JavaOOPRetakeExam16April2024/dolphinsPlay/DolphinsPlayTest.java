package _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024.dolphinsPlay;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024.dolphinsPlay.Dolphin;
import _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024.dolphinsPlay.DolphinsPlay;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DolphinsPlayTest {

    DolphinsPlay dolphinsPlay;
    Dolphin dolphin;

    @Before
    public void setUp() throws Exception {
        dolphinsPlay = new DolphinsPlay("Play1", 2);
        dolphin = new Dolphin("BottleNoseDolphin", "Dolphin1", 300);
        dolphinsPlay.addDolphin(dolphin);
    }

    @Test
    public void getDolphins() {
        List<Dolphin> dolphins = this.dolphinsPlay.getDolphins();
        Assert.assertEquals(dolphins, dolphinsPlay.getDolphins());
    }

    @Test
    public void getCount() {
        Assert.assertEquals(1, dolphinsPlay.getDolphins().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDolphinNull() throws IllegalArgumentException {
        dolphinsPlay.addDolphin(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDolphinNoCapacity() throws IllegalArgumentException {
        Dolphin dolphin2 = new Dolphin("BottleNoseDolphin", "Dolphin2", 400);
        Dolphin dolphin3 = new Dolphin("BottleNoseDolphin", "Dolphin3", 500);
        dolphinsPlay.addDolphin(dolphin2);
        dolphinsPlay.addDolphin(dolphin3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDolphinSameName() throws IllegalArgumentException {
        Dolphin dolphin2 = new Dolphin("BottleNoseDolphin", "Dolphin1", 400);
        dolphinsPlay.addDolphin(dolphin2);
    }

    @Test
    public void addDolphin() {
        Dolphin dolphin2 = new Dolphin("BottleNoseDolphin", "Dolphin2", 400);
        dolphinsPlay.addDolphin(dolphin2);
        Assert.assertEquals(2, dolphinsPlay.getDolphins().size());
    }

    @Test
    public void removeDolphinFalse() {
        Assert.assertFalse(dolphinsPlay.removeDolphin("Dolphin2"));
    }

    @Test
    public void removeDolphinTrue() {
        Assert.assertTrue(dolphinsPlay.removeDolphin("Dolphin1"));
    }

    @Test
    public void getTheDolphinWithTheMaxEnergy() {
        Dolphin dolphin2 = new Dolphin("BottleNoseDolphin", "Dolphin2", 400);
        dolphinsPlay.addDolphin(dolphin2);
        Assert.assertEquals("Dolphin2", dolphinsPlay.getTheDolphinWithTheMaxEnergy());
    }

    @Test
    public void findAllDolphinsByType() {
        List<Dolphin> dolphins = new ArrayList<>();
        dolphins.add(dolphin);
        Dolphin dolphin2 = new Dolphin("SpinnerDolphin", "Dolphin2", 400);
        dolphinsPlay.addDolphin(dolphin2);
        Assert.assertEquals(dolphins, dolphinsPlay.findAllDolphinsByType("BottleNoseDolphin"));
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(2, dolphinsPlay.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityInvalid() throws IllegalArgumentException {
        DolphinsPlay dolphinsPlay2 = new DolphinsPlay("Play2", -1);
    }

    @Test
    public void setCapacity() throws IllegalArgumentException {
        DolphinsPlay dolphinsPlay2 = new DolphinsPlay("Play2", 3);
        Assert.assertEquals(3, dolphinsPlay2.getCapacity());
    }

    @Test
    public void getName() {
        Assert.assertEquals("Play1", dolphinsPlay.getName());
    }

    @Test
    public void setName() {
        DolphinsPlay dolphinsPlay2 = new DolphinsPlay("Play2", 3);
        Assert.assertEquals("Play2", dolphinsPlay2.getName());
    }
}