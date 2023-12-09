package Item;

import Entity.Avatar;

public class Weapon extends Equippable{
    
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
    public String toString(){
        return '[' + this.getName() + "] Weapon +" + this.getBonus();
    }
}