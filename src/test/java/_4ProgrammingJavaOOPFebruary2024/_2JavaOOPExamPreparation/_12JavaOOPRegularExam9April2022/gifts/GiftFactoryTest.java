package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022.gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiftFactoryTest {

    GiftFactory giftFactory;
    Gift gift;
    @Before
    public void setUp() throws Exception {
        giftFactory = new GiftFactory();
        gift = new Gift("Gift1", 10.00);
        giftFactory.createGift(gift);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateGiftExisting() throws IllegalArgumentException {
        giftFactory.createGift(gift);
    }

    @Test
    public void testCreateGift() {
        Gift gift2 = new Gift("Gift2", 20.00);
        Assert.assertEquals("Successfully added gift Gift2 with magic 20.00.", giftFactory.createGift(gift2));
        Assert.assertEquals(2, giftFactory.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveGiftNull() throws NullPointerException{
        giftFactory.removeGift(null);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveGiftInvalidName() throws NullPointerException{
        giftFactory.removeGift("");
    }

    @Test
    public void testRemoveGiftFalse() {
        Assert.assertFalse(giftFactory.removeGift("Gift2"));
    }

    @Test
    public void testRemoveGiftTrue() {
        Assert.assertTrue(giftFactory.removeGift("Gift1"));
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        Gift gift2 = new Gift("Gift2", 20.00);
        Gift gift3 = new Gift("Gift3", 30.00);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Assert.assertEquals(gift, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresent() {
        Assert.assertEquals(gift, giftFactory.getPresent("Gift1"));
    }
}