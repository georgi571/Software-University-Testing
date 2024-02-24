package _4ProgrammingJavaOOPFebruary2024._10TestDrivenDevelopment._2Exercises;

public class TransactionImpl implements Transaction, Comparable<TransactionImpl>{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public TransactionStatus getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(TransactionStatus newStatus) {
        this.status = newStatus;
    }

    @Override
    public String getFrom() {
        return this.from;
    }

    @Override
    public String getTo() {
        return this.to;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }


    public int compareTo(TransactionImpl o) {
        return 0;
    }


}
