package Item;

import Entity.Avatar;

public class Armor extends Equippable{
    public static final int itemType = 1;

    public Armor(String name, int price, int bonus){
        super(name, price, bonus);  
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public void use(Avatar player){
        for (Equippable item : player.getInv().getContent()) {
            if (item.getIsEquip() && item.getItemType() == this.getItemType()) {
                item.unuse(player);
            }
        }
        this.setIsEquip(true);;
        player.setDefense(player.getDefense() + this.getBonus());
    }

    @Override 
    public void unuse(Avatar player){
        this.setIsEquip(false);
        player.setDefense(player.getDefense() - this.getBonus());
    }

    @Override
    public String toString(){
        return String.format("[%s] Armor +%d", getName(), getBonus());
    }
}