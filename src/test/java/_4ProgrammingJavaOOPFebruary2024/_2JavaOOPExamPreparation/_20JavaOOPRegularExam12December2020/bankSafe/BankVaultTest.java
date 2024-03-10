package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020.bankSafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    BankVault bankVault;
    Item item;
    @Before
    public void setUp() throws Exception {
        bankVault = new BankVault();
        item = new Item("Owner1", "Id1");
        bankVault.addItem("A1" ,item);
    }

    @Test
    public void testGetVaultCells() {
        Map<String, Item> vaultCells = new LinkedHashMap<>();
        vaultCells.put("A1", item);
        vaultCells.put("A2", null);
        vaultCells.put("A3", null);
        vaultCells.put("A4", null);
        vaultCells.put("B1", null);
        vaultCells.put("B2", null);
        vaultCells.put("B3", null);
        vaultCells.put("B4", null);
        vaultCells.put("C1", null);
        vaultCells.put("C2", null);
        vaultCells.put("C3", null);
        vaultCells.put("C4", null);
        Assert.assertEquals(vaultCells, bankVault.getVaultCells());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddItemInvalidCell() throws OperationNotSupportedException, IllegalArgumentException {
        Item item2 = new Item("Owner2", "Id2");
        bankVault.addItem("D4", item2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddItemNotEmptyCell() throws OperationNotSupportedException, IllegalArgumentException {
        Item item2 = new Item("Owner2", "Id2");
        bankVault.addItem("A1", item2);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddItemExisting() throws OperationNotSupportedException, IllegalArgumentException {
        bankVault.addItem("A2", item);
    }

    @Test
    public void testAddItem() throws OperationNotSupportedException, IllegalArgumentException {
        Item item2 = new Item("Owner2", "Id2");
        Assert.assertEquals("Item:Id2 saved successfully!", bankVault.addItem("A2", item2));
        Assert.assertEquals(item2, bankVault.getVaultCells().get("A2"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveItemInvalidCell() throws IllegalArgumentException{
        Item item2 = new Item("Owner2", "Id2");
        bankVault.removeItem("D4", item2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveItemInvalidItem() throws IllegalArgumentException {
        Item item2 = new Item("Owner2", "Id2");
        bankVault.removeItem("A1", item2);
    }

    @Test
    public void testRemoveItem() {
        Assert.assertEquals("Remove item:Id1 successfully!", bankVault.removeItem("A1", item));
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
    }
}