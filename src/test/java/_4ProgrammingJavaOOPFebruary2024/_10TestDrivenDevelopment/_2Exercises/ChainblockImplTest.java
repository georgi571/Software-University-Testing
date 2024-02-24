package _4ProgrammingJavaOOPFebruary2024._10TestDrivenDevelopment._2Exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest {
    private static final int TRANSACTION_ID_1 = 1;
    private static final int TRANSACTION_ID_2 = 2;
    private static final int TRANSACTION_ID_3 = 3;
    private static final int TRANSACTION_ID_4 = 4;
    private static final int TRANSACTION_ID_5 = 5;
    private static final int TRANSACTION_INVALID_ID_100 = 100;
    private static final String TRANSACTION_SENDER_1 = "Cross Marian";
    private static final String TRANSACTION_SENDER_2 = "Froi Tiedoll";
    private static final String INVALID_TRANSACTION_SENDER = "Alan Walker";
    private static final String TRANSACTION_RECEIVER_1 = "Klaud Nine";
    private static final String TRANSACTION_RECEIVER_2 = "Winters Socalo";
    private static final String TRANSACTION_RECEIVER_3 = "Kevin Yeegar";
    private static final String INVALID_TRANSACTION_RECEIVER = "Neah Noah";
    private static final Double TRANSACTION_AMOUNT_1 = 450.50;
    private static final Double TRANSACTION_AMOUNT_2 = 350.50;
    private static final Double TRANSACTION_AMOUNT_3 = 250.50;
    private static final Double TRANSACTION_AMOUNT_4 = 150.50;
    private static final Double TRANSACTION_AMOUNT_5 = 50.50;
    private static final int TRANSACTION_COUNT_0 = 0;
    private static final int TRANSACTION_COUNT_1 = 1;
    private static final int TRANSACTION_COUNT_2 = 2;
    private static final int TRANSACTION_COUNT_3 = 3;
    private static final int TRANSACTION_COUNT_4 = 4;
    private static final Double TRANSACTION_AMOUNT_MAX = 250.50;
    private static final Double TRANSACTION_AMOUNT_MIN = 150.50;
    private static final Double TRANSACTION_AMOUNT_LO = TRANSACTION_AMOUNT_5;
    private static final Double TRANSACTION_AMOUNT_HI = TRANSACTION_AMOUNT_1;

    private static final Double TRANSACTION_AMOUNT_LO_INVALID = 10000.00;
    private static final Double TRANSACTION_AMOUNT_HI_INVALID = 20000.00;
    private static final Double TRANSACTION_AMOUNT_INVALID = 1150.50;

    private Chainblock chainblock;
    private List<Transaction> transactionList;

    @Before
    public void setup() {
        this.chainblock = new ChainblockImpl();
        this.transactionList = new ArrayList<>();
        prepareTransactionForTest();
    }

    private void prepareTransactionForTest() {
        Transaction transaction1 = new TransactionImpl(TRANSACTION_ID_1, TransactionStatus.SUCCESSFUL, TRANSACTION_SENDER_1, TRANSACTION_RECEIVER_1, TRANSACTION_AMOUNT_1);
        Transaction transaction2 = new TransactionImpl(TRANSACTION_ID_2, TransactionStatus.FAILED, TRANSACTION_SENDER_2, TRANSACTION_RECEIVER_2, TRANSACTION_AMOUNT_2);
        Transaction transaction3 = new TransactionImpl(TRANSACTION_ID_3, TransactionStatus.SUCCESSFUL, TRANSACTION_SENDER_1, TRANSACTION_RECEIVER_2, TRANSACTION_AMOUNT_3);
        Transaction transaction4 = new TransactionImpl(TRANSACTION_ID_4, TransactionStatus.SUCCESSFUL, TRANSACTION_SENDER_2, TRANSACTION_RECEIVER_3, TRANSACTION_AMOUNT_4);
        Transaction transaction5 = new TransactionImpl(TRANSACTION_ID_5, TransactionStatus.SUCCESSFUL, TRANSACTION_SENDER_2, TRANSACTION_RECEIVER_1, TRANSACTION_AMOUNT_5);
        this.transactionList.add(transaction1);
        this.transactionList.add(transaction2);
        this.transactionList.add(transaction3);
        this.transactionList.add(transaction4);
        this.transactionList.add(transaction5);
    }

    @Test
    public void testAddCorrectTransaction() {
        Assert.assertEquals(TRANSACTION_COUNT_0, this.chainblock.getCount());
        this.chainblock.add(this.transactionList.get(0));
        Assert.assertEquals(TRANSACTION_COUNT_1, this.chainblock.getCount());
        this.chainblock.add(this.transactionList.get(1));
        Assert.assertEquals(TRANSACTION_COUNT_2, this.chainblock.getCount());
    }

    @Test
    public void testAddExistingTransaction() {
        Transaction transaction50 = new TransactionImpl(TRANSACTION_ID_1, TransactionStatus.FAILED, TRANSACTION_SENDER_2, TRANSACTION_RECEIVER_2, TRANSACTION_AMOUNT_2);
        Assert.assertEquals(TRANSACTION_COUNT_0, this.chainblock.getCount());
        this.chainblock.add(this.transactionList.get(0));
        Assert.assertEquals(TRANSACTION_COUNT_1, this.chainblock.getCount());
        this.chainblock.add(transaction50);
        Assert.assertEquals(TRANSACTION_COUNT_1, this.chainblock.getCount());
    }

    @Test
    public void testContains() {
        Assert.assertFalse(this.chainblock.contains(this.transactionList.get(0)));
        Assert.assertFalse(this.chainblock.contains(this.transactionList.get(0).getID()));
        this.chainblock.add(this.transactionList.get(0));
        Assert.assertTrue(this.chainblock.contains(this.transactionList.get(0)));
        Assert.assertTrue(this.chainblock.contains(this.transactionList.get(0).getID()));
    }

    @Test
    public void testChangeTransactionStatus() {
        this.chainblock.add(this.transactionList.get(0));
        Assert.assertEquals(TRANSACTION_COUNT_1, this.chainblock.getCount());
        this.chainblock.changeTransactionStatus(TRANSACTION_ID_1, TransactionStatus.ABORTED);
        Assert.assertEquals(TransactionStatus.ABORTED, this.transactionList.get(0).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusInvalidID() {
        this.chainblock.add(this.transactionList.get(0));
        Assert.assertEquals(TRANSACTION_COUNT_1, this.chainblock.getCount());
        this.chainblock.changeTransactionStatus(TRANSACTION_ID_2, TransactionStatus.ABORTED);
        Assert.assertEquals(TransactionStatus.ABORTED, this.transactionList.get(0).getStatus());
    }

    @Test
    public void testRemoveTransactionById() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        Assert.assertEquals(TRANSACTION_COUNT_2, this.chainblock.getCount());
        this.chainblock.removeTransactionById(this.transactionList.get(0).getID());
        Assert.assertEquals(TRANSACTION_COUNT_1, this.chainblock.getCount());
        Assert.assertFalse(this.chainblock.contains(this.transactionList.get(0).getID()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIThrowInvalidID() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        Assert.assertEquals(TRANSACTION_COUNT_2, this.chainblock.getCount());
        this.chainblock.removeTransactionById(TRANSACTION_INVALID_ID_100);
    }

    @Test
    public void testGetById() {
        Transaction transaction = this.transactionList.get(0);
        this.chainblock.add(transaction);
        Transaction transactionFromChainBlock = this.chainblock.getById(transaction.getID());
        Assert.assertEquals(transaction.getID(), transactionFromChainBlock.getID());
        Assert.assertEquals(transaction.getStatus(), transactionFromChainBlock.getStatus());
        Assert.assertEquals(transaction.getFrom(), transactionFromChainBlock.getFrom());
        Assert.assertEquals(transaction.getTo(), transactionFromChainBlock.getTo());
        Assert.assertEquals(transaction.getAmount(), transactionFromChainBlock.getAmount(), 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByInvalidID() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.getById(TRANSACTION_INVALID_ID_100);
    }

    @Test
    public void testGetByTransactionStatus() {
        List<Transaction> successfulTransaction = new ArrayList<>();
        for (Transaction transaction : this.transactionList) {
            if (transaction.getStatus() == TransactionStatus.SUCCESSFUL) {
                successfulTransaction.add(transaction);
            }
        }
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> byTransactionStatus = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> transactionsFromChainBlock = new ArrayList<>();
        for (Transaction transactionStatus : byTransactionStatus) {
            transactionsFromChainBlock.add(transactionStatus);
        }
        Assert.assertEquals(successfulTransaction.size(), transactionsFromChainBlock.size());
        for (Transaction transaction : transactionsFromChainBlock) {
            Assert.assertEquals(transaction.getStatus(), TransactionStatus.SUCCESSFUL);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionInvalidStatus() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatus() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        Iterable<String> byTransactionStatus = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> transactionsFromChainBlock = new ArrayList<>();
        for (String transactionStatus : byTransactionStatus) {
            transactionsFromChainBlock.add(transactionStatus);
        }
        Assert.assertEquals(TRANSACTION_COUNT_3, transactionsFromChainBlock.size());
        Assert.assertEquals(TRANSACTION_SENDER_1, transactionsFromChainBlock.get(0));
        Assert.assertEquals(TRANSACTION_SENDER_1, transactionsFromChainBlock.get(1));
        Assert.assertEquals(TRANSACTION_SENDER_2, transactionsFromChainBlock.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithInvalidTransactionStatus() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatus() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<String> byTransactionStatus = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> transactionsFromChainBlock = new ArrayList<>();
        for (String transactionStatus : byTransactionStatus) {
            transactionsFromChainBlock.add(transactionStatus);
        }
        Assert.assertEquals(TRANSACTION_COUNT_4, transactionsFromChainBlock.size());
        Assert.assertEquals(TRANSACTION_RECEIVER_1, transactionsFromChainBlock.get(0));
        Assert.assertEquals(TRANSACTION_RECEIVER_2, transactionsFromChainBlock.get(1));
        Assert.assertEquals(TRANSACTION_RECEIVER_3, transactionsFromChainBlock.get(2));
        Assert.assertEquals(TRANSACTION_RECEIVER_1, transactionsFromChainBlock.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithInvalidTransactionStatus() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allOrderedByAmountDescendingThenById = this.chainblock.getAllOrderedByAmountDescendingThenById();
        List<Transaction> expected = this.transactionList
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getID)).collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allOrderedByAmountDescendingThenById) {
            returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void testGetBySenderOrderedByAmountDescending() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allBySenderOrderedByAmountDescending = this.chainblock.getBySenderOrderedByAmountDescending(TRANSACTION_SENDER_1);
        List<Transaction> expected = this.transactionList
                .stream()
                .filter(sender -> sender.getFrom().equals(TRANSACTION_SENDER_1))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allBySenderOrderedByAmountDescending) {
                returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByInvalidSenderOrderedByAmountDescending() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        this.chainblock.getBySenderOrderedByAmountDescending(INVALID_TRANSACTION_SENDER);
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenById() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allByReceiverOrderedByAmountThenById = this.chainblock.getByReceiverOrderedByAmountThenById(TRANSACTION_RECEIVER_1);
        List<Transaction> expected = this.transactionList
                .stream()
                .filter(receiver -> receiver.getTo().equals(TRANSACTION_RECEIVER_1))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getID)).collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allByReceiverOrderedByAmountThenById) {
            returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByInvalidReceiverOrderedByAmountThenById() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        this.chainblock.getBySenderOrderedByAmountDescending(INVALID_TRANSACTION_RECEIVER);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmount() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allByReceiverOrderedByAmountThenById = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, TRANSACTION_AMOUNT_MAX);
        List<Transaction> expected = this.transactionList
                .stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.SUCCESSFUL)
                .filter(transaction -> transaction.getAmount() <= TRANSACTION_AMOUNT_MAX)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                        .collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allByReceiverOrderedByAmountThenById) {
            returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountReturnEmptyList() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allByReceiverOrderedByAmountThenById = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, TRANSACTION_AMOUNT_MAX);
        List<Transaction> expected = this.transactionList
                .stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.ABORTED && transaction.getAmount() <= TRANSACTION_AMOUNT_MAX)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allByReceiverOrderedByAmountThenById) {
            returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescending() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allBySenderAndMinimumAmountDescending = this.chainblock.getBySenderAndMinimumAmountDescending(TRANSACTION_SENDER_1, TRANSACTION_AMOUNT_MIN);
        List<Transaction> expected = this.transactionList
                .stream()
                .filter(transaction -> transaction.getFrom().equals(TRANSACTION_SENDER_1) && transaction.getAmount() > TRANSACTION_AMOUNT_MIN)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allBySenderAndMinimumAmountDescending) {
            returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingEmpty() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        this.chainblock.getBySenderAndMinimumAmountDescending(TRANSACTION_SENDER_1, TRANSACTION_AMOUNT_INVALID);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByInvalidSenderAndMinimumAmountDescending() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        this.chainblock.getBySenderAndMinimumAmountDescending(INVALID_TRANSACTION_SENDER, TRANSACTION_AMOUNT_MIN);
    }


    @Test
    public void testGetByReceiverAndAmountRange() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allBySenderAndMinimumAmountDescending = this.chainblock.getByReceiverAndAmountRange(TRANSACTION_RECEIVER_2, TRANSACTION_AMOUNT_LO, TRANSACTION_AMOUNT_HI);
        List<Transaction> expected = this.transactionList
                .stream()
                .filter(transaction -> transaction.getTo().equals(TRANSACTION_RECEIVER_2) && transaction.getAmount() >= TRANSACTION_AMOUNT_LO && transaction.getAmount() < TRANSACTION_AMOUNT_HI)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allBySenderAndMinimumAmountDescending) {
            returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByInvalidReceiverAndAmountRange() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        this.chainblock.getByReceiverAndAmountRange(INVALID_TRANSACTION_RECEIVER, TRANSACTION_AMOUNT_LO, TRANSACTION_AMOUNT_HI);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeEmpty() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        this.chainblock.getByReceiverAndAmountRange(INVALID_TRANSACTION_RECEIVER, TRANSACTION_AMOUNT_LO_INVALID, TRANSACTION_AMOUNT_HI_INVALID);
    }

    @Test
    public void testGetAllInAmountRange() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allBySenderAndMinimumAmountDescending = this.chainblock.getAllInAmountRange(TRANSACTION_AMOUNT_LO, TRANSACTION_AMOUNT_HI);
        List<Transaction> expected = this.transactionList
                .stream()
                .filter(transaction -> transaction.getAmount() >= TRANSACTION_AMOUNT_LO && transaction.getAmount() <= TRANSACTION_AMOUNT_HI)
                .collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allBySenderAndMinimumAmountDescending) {
            returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void testGetAllInAmountRangeEmpty() {
        this.chainblock.add(this.transactionList.get(0));
        this.chainblock.add(this.transactionList.get(1));
        this.chainblock.add(this.transactionList.get(2));
        this.chainblock.add(this.transactionList.get(3));
        this.chainblock.add(this.transactionList.get(4));
        Iterable<Transaction> allBySenderAndMinimumAmountDescending = this.chainblock.getAllInAmountRange(TRANSACTION_AMOUNT_LO_INVALID, TRANSACTION_AMOUNT_HI_INVALID);
        List<Transaction> expected = this.transactionList
                .stream()
                .filter(transaction -> transaction.getAmount() >= TRANSACTION_AMOUNT_LO_INVALID && transaction.getAmount() <= TRANSACTION_AMOUNT_HI_INVALID)
                .collect(Collectors.toList());
        List<Transaction> returned = new ArrayList<>();
        for (Transaction transaction : allBySenderAndMinimumAmountDescending) {
            returned.add(transaction);
        }
        Assert.assertEquals(expected, returned);
    }
}