package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._05JavaOOPRegularExam8April2023.robots;

public class Robot {
    private String name;
    private boolean isReadyForSale;

    public Robot(String name){
        this.setName(name);
        this.setReadyForSale(true);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean isReadyForSale() {
        return isReadyForSale;
    }

    public void setReadyForSale(boolean readyForSale) {
        this.isReadyForSale = readyForSale;
    }
}
