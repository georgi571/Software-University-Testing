package _4ProgrammingJavaOOPFebruary2024._10TestDrivenDevelopment._2Exercises;

public interface Transaction {
    int getID();
    TransactionStatus getStatus();
    void setStatus(TransactionStatus newStatus);
    String getFrom();
    String getTo();
    double getAmount();

}
