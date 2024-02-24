package _4ProgrammingJavaOOPFebruary2024._10TestDrivenDevelopment._2Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new HashMap<>();
    }

    public int getCount() {
        return this.transactionMap.size();
    }

    public void add(Transaction transaction) {
        int id = transaction.getID();
        if (!transactionMap.containsKey(id)) {
            this.transactionMap.put(id, transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.transactionMap.containsValue(transaction);
    }

    public boolean contains(int id) {
        return this.transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (this.transactionMap.containsKey(id)) {
            Transaction transactionForChange = transactionMap.get(id);
            transactionForChange.setStatus(newStatus);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void removeTransactionById(int id) {
        if (this.transactionMap.containsKey(id)) {
            this.transactionMap.remove(id);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public Transaction getById(int id) {
        if (this.transactionMap.containsKey(id)) {
            return this.transactionMap.get(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransaction = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getStatus() == status) {
                filteredTransaction.add(value);
            }
        }
        if (filteredTransaction.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            filteredTransaction.sort(Comparator.comparing(Transaction::getAmount).reversed());
        }
        return filteredTransaction;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransaction = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getStatus() == status) {
                filteredTransaction.add(value);
            }
        }
        if (filteredTransaction.isEmpty()) {
            throw new IllegalArgumentException();
        }
        filteredTransaction.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        List<String> senders = new ArrayList<>();
        for (Transaction transaction : filteredTransaction) {
            senders.add(transaction.getFrom());
        }
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransaction = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getStatus() == status) {
                filteredTransaction.add(value);
            }
        }
        if (filteredTransaction.isEmpty()) {
            throw new IllegalArgumentException();
        }
        filteredTransaction.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        List<String> receivers = new ArrayList<>();
        for (Transaction transaction : filteredTransaction) {
            receivers.add(transaction.getTo());
        }
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionMap.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getID)).collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getFrom().equals(sender)) {
                transactions.add(value);
            }
        }
        transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed()).collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getTo().equals(receiver)) {
                transactions.add(value);
            }
        }
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getID))
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getStatus().equals(status) && value.getAmount() <= amount) {
                transactions.add(value);
            }
        }
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        return transactions;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getFrom().equals(sender) && value.getAmount() > amount) {
                transactions.add(value);
            }
        }
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getTo().equals(receiver) && value.getAmount() >=  lo && value.getAmount() < hi) {
                transactions.add(value);
            }
        }
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return transactions;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction value : this.transactionMap.values()) {
            if (value.getAmount() >=  lo && value.getAmount() <= hi) {
                transactions.add(value);
            }
        }
        return transactions;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
