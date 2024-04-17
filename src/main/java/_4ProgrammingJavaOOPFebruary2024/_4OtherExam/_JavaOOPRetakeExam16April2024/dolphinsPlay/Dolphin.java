package _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024.dolphinsPlay;

public class Dolphin {
    private String type;
    private String name;
    private int energy;



    public Dolphin(String type, String name, int energy) {
        this.type = type;
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public String getType() {
        return type;
    }
}
