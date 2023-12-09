package Item;

import Entity.Avatar;

public class Weapon extends Equippable{
    public static int itemType = 2;
    
    public Weapon(String name, int price, int bonus){
        super(name, price, bonus);  
    }

    @Override
    public void use(Avatar player){
        this.setIsEquip(true);
        player.setAttack(player.getAttack() + this.getBonus());;
    }

    @Override 
    public void unuse(Avatar player){
        this.setIsEquip(false);
        player.setAttack(player.getAttack() - this.getBonus());
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public String toString(){
        String res = String.format("[%s] Weapon +%d", getName(), getBonus());
        if (this.getIsEquip()) {
            res += " [E]";
        }
        return res;
    }
}