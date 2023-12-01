package Item;

import Entity.Avatar;

public class Weapon extends Equippable{
    
    public Weapon(String n, int p, int b){
        super(n, p, b);
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
}