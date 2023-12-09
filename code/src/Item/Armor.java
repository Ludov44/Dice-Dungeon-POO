package Item;

import Entity.Avatar;

public class Armor extends Equippable{
    
    public Armor(String name, int price, int bonus){
        super(name, price, bonus);  
    }

    @Override
    public void use(Avatar player){
        this.setIsEquip(true);;
        player.setDefense(player.getDefense() + this.getBonus());
    }

    @Override 
    public void unuse(Avatar player){
        this.setIsEquip(false);;
        player.setDefense(player.getDefense() - this.getBonus());
    }
}