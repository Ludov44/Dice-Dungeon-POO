package Entity;

import java.util.ArrayList;

import Item.Equippable;

public class Inventory {
    private ArrayList<Equippable> contents;
    private int money;

    public Inventory(){
        this.contents = new ArrayList<Equippable>();
        this.money = 0;
    }

    public Inventory(ArrayList<Equippable> contents, int money) {
        this.contents = contents;
        this.money = money;
    }
    
    public ArrayList<Equippable> getContent() {
        return this.contents;
    }

    public void addItem(Equippable item) {
        this.contents.add(item);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString(){
        String res = String.format("money = %d ; contents = {", getMoney());
        for (int i = 0; i < this.contents.size(); i++) {
            res += String.format("%s", this.getContent().get(i).toString());
            if (i < this.contents.size() - 1) {
                res += ", ";
            }
        }
        res += '}';
        return res;
    }

}
