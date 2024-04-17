package _4ProgrammingJavaOOPFebruary2024._4OtherExam._JavaOOPRetakeExam16April2024.dolphinsPlay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DolphinsPlay {

    private String name;
    private int capacity;
    private List<Dolphin> dolphins;

    public DolphinsPlay(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.dolphins = new ArrayList<>();
    }

    public List<Dolphin> getDolphins() {
        return Collections.unmodifiableList(this.dolphins);
    }

    public int getCount() {
        return this.dolphins.size();
    }


    public void addDolphin(Dolphin dolphin) {
        if (dolphin == null) {
            throw new IllegalArgumentException("Dolphin can't be null");
        }

        if (dolphins.size() == this.getCapacity()) {
            throw new IllegalArgumentException("No more places!");
        }
        boolean dolphinExist = this.dolphins
                .stream()
                .anyMatch(a -> a.getName().equals(dolphin.getName()));

        if (dolphinExist) {
            throw new IllegalArgumentException(String.format("The dolphin %s already exist!", dolphin.getName()));
        }

        this.dolphins.add(dolphin);
    }


    public boolean removeDolphin(String dolphinName) {
        Dolphin dolphin = this.dolphins
                .stream()
                .filter(a -> a.getName().equals(dolphinName))
                .findFirst()
                .orElse(null);

        return this.dolphins.remove(dolphin);
    }

    public String getTheDolphinWithTheMaxEnergy() {
        Dolphin dolphin = this
                .dolphins
                .stream()
                .sorted((d1, d2) -> Integer.compare(d2.getEnergy(), d1.getEnergy()))
                .limit(1)
                .findFirst()
                .orElse(null);

        assert dolphin != null;
        return dolphin.getName();
    }


    public List<Dolphin> findAllDolphinsByType(String type) {
        List<Dolphin> dolphins = this.dolphins.stream().filter(d -> d.getType().equals(type)).collect(Collectors.toList());

        return dolphins;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}