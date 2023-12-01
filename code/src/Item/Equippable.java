package Item;

import Entity.Avatar;

public abstract class Equippable implements Item{
    private String name;
    private int price;
    private int bonus;
    private boolean isEquip;

    public Equippable(String nom, int prix, int b){
        this.name = nom;
        this.price = prix;
        this.bonus = b;
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

    public abstract void unuse(Avatar player);
        
}
