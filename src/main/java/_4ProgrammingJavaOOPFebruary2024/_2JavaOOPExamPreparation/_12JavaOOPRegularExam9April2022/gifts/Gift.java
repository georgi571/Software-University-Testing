package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._12JavaOOPRegularExam9April2022.gifts;

public class Gift {
    private String type;
    private double magic;

    public Gift(String type, double magic){
        this.setType(type);
        this.setMagic(magic);
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setMagic(double magic) {
        this.magic = magic;
    }

    public String getType() {
        return type;
    }

    public double getMagic() {
        return magic;
    }
}
