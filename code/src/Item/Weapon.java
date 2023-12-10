package Item;

import Entity.Avatar;

public class Weapon extends Equippable{
    public static int itemType = 2;
    
    public Weapon(String name, int price, int bonus){
        super(name, price, bonus);  
    }

    @Override
    public void use(Avatar player){
        for (Equippable item : player.getInv().getContent()) {
            if (item.getIsEquip() && item.getItemType() == this.getItemType()) {
                item.unuse(player);
            }
        }
        this.setIsEquip(true);
        player.setbaseAttack(player.getbaseAttack() + this.getBonus());;
    }

    @Override 
    public void unuse(Avatar player){
        this.setIsEquip(false);
        player.setbaseAttack(player.getbaseAttack() - this.getBonus());
        System.out.println(String.format("Retiré arme : %s", this.toString()));
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public String toString(){
        String res = String.format("[%s] Weapon +%d (value = %d)", getName(), getBonus(), getPrice());
        if (this.getIsEquip()) {
            res += " [E]";
        }
        return res;
    }

    @Override
    public Object clone(){
        return new Weapon(getName(), getPrice(), getBonus());
    }
}