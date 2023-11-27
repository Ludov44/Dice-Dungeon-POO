package Entity;

import java.util.ArrayList;

import Item.Item;

public class Inventory {
    private ArrayList<Item> items;
    private int money;

    public Inventory(){
        this.items = new ArrayList<Item>();
        this.money = 0;
    }

    public Inventory(ArrayList<Item> items, int money) {
        this.items = items;
        this.money = money;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
