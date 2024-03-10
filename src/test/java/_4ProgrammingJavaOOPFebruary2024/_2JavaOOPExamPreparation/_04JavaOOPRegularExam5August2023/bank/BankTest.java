package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._04JavaOOPRegularExam5August2023.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    Bank bank;
    Client client;
    @Before
    public void setUp() throws Exception {
        bank = new Bank("Bank1", 2);
        client = new Client("Client1");
        bank.addClient(client);
    }

    @Test
    public void getName() {
        Assert.assertEquals("Bank1", bank.getName());
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(2, bank.getCapacity());
    }

    @Test
    public void getCount() {
        Assert.assertEquals(1, bank.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddClientInFullBank() throws IllegalArgumentException {
        Client client2 = new Client("Client2");
        Client client3 = new Client("Client3");
        bank.addClient(client2);
        bank.addClient(client3);
    }

    @Test
    public void testAddClient() {
        Client client2 = new Client("Client2");
        bank.addClient(client2);
        Assert.assertEquals(2, bank.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveInvalidClient() throws IllegalArgumentException {
        bank.removeClient("Client2");
    }

    @Test
    public void testRemoveClient() {
        bank.removeClient("Client1");
        Assert.assertEquals(0, bank.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLoanWithdrawalInvalidClient() throws IllegalArgumentException{
        bank.loanWithdrawal("Client2");
    }

    @Test
    public void testLoanWithdrawal() {
        bank.loanWithdrawal("Client1");
        Assert.assertFalse(client.isApprovedForLoan());
    }

    @Test
    public void testStatistics() {
        Assert.assertEquals("The client Client1 is at the Bank1 bank!", bank.statistics());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityInvalid() throws IllegalArgumentException {
        Bank bank2 = new Bank("Bank2", -1);
    }

    @Test
    public void testSetValidCapacity() {
        Bank bank2 = new Bank("Bank2", 5);
        Assert.assertEquals(5, bank2.getCapacity());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameInvalid() throws NullPointerException{
        Bank bank2 = new Bank("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameNull() throws NullPointerException{
        Bank bank2 = new Bank(null, 5);
    }

    @Test
    public void testSetName() {
        Bank bank2 = new Bank("Bank2", 5);
        Assert.assertEquals("Bank2", bank2.getName());
    }
}