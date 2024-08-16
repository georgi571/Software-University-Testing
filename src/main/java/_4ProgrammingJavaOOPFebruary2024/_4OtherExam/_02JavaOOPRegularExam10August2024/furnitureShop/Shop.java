package _4ProgrammingJavaOOPFebruary2024._4OtherExam._02JavaOOPRegularExam10August2024.furnitureShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

    private String name;
    private int capacity;
    private List<Furniture> furnitures;

    public Shop(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.furnitures = new ArrayList<>();
    }

    public List<Furniture> getFurnitures() {
        return Collections.unmodifiableList(this.furnitures);
    }

    public int getCount() {
        return this.furnitures.size();
    }


    public void addFurniture(Furniture furniture) {
        if (furniture == null) {
            throw new IllegalArgumentException("Furniture can't be null");
        }

        if (furnitures.size() == this.getCapacity()) {
            throw new IllegalArgumentException("No more places!");
        }
        boolean furnitureExist = this.furnitures
                .stream()
                .anyMatch(a -> a.getName().equals(furniture.getName()));

        if (furnitureExist) {
            throw new IllegalArgumentException(String.format("The furniture %s already exist!", furniture.getName()));
        }

        this.furnitures.add(furniture);
    }


    public boolean removeFurniture(String furnitureName) {
        Furniture furniture = this.furnitures
                .stream()
                .filter(a -> a.getType().equals(furnitureName))
                .findFirst()
                .orElse(null);

        return this.furnitures.remove(furniture);
    }

    public String getCheapestFurniture() {
        Furniture furniture = furnitures
                .stream()
                .sorted(Comparator.comparingInt(Furniture::getPrice))
                .limit(1)
                .findFirst()
                .orElse(null);

        assert furniture != null;
        return furniture.getName();
    }



    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid capacity!");
        }
        this.capacity = capacity;
    }

    public String getType() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Furniture> findAllFurnitureByType(String type) {
        return this.furnitures.stream().filter(d -> d.getType().equals(type)).collect(Collectors.toList());
    }
}