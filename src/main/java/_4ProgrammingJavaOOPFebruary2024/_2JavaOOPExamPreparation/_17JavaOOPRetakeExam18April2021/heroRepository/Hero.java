package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021.heroRepository;

public class Hero {
    private String name;
    private int level;

    public Hero(String name, int level) {
        this.setName(name);
        this.setLevel(level);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    private void setLevel(int level) {
        this.level = level;
    }
}
