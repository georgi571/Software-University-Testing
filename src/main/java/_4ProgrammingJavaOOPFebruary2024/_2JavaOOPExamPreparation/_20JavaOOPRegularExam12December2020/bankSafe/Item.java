package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020.bankSafe;

public class Item {
    private String owner;
    private String itemId;

    public Item(String owner, String itemId)
    {
        this.setOwner(owner);
        this.setItemId(itemId);
    }

    public String getOwner() {
        return owner;
    }

    private void setOwner(String owner) {
        this.owner = owner;
    }

    public String getItemId() {
        return itemId;
    }

    private void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
