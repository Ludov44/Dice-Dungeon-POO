package Item;

import Entity.Avatar;

public abstract class Equippable implements Item{
    private String name;
    private int price;
    private int bonus;
    private boolean isEquip;

    public Equippable(String name, int price, int bonus){
        this.name = name;
        this.price = price;
        this.bonus = bonus;
        this.isEquip = false;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public int getBonus(){
        return this.bonus;
    }

    public boolean getIsEquip(){
        return this.isEquip;
    }

    public void setIsEquip(boolean bool){
        this.isEquip = bool;
    }

    public String toString(){
        return String.format(super.toString(), String.format(" (value = %d)", getPrice()));
    }

    public abstract void unuse(Avatar player);    
}
