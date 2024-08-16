package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024.furnitureShop;

public class Furniture {
    private String name;
    private String type;
    private int price;



    public Furniture(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
