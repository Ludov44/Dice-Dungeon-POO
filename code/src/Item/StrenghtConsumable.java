package Item;

import Entity.Avatar;

public class StrenghtConsumable extends Consumable{

    public StrenghtConsumable(int h, String n, int p){
        super(n, h, p);
        if(this.getEffect() < 0 || this.getEffect() > 1){
            throw new IllegalArgumentException("l'effect de force doit être entre 0 et 1");
        }
    }
    
    @Override
    public void use(Avatar player){
        if (this.getEffect() == 0){
            throw new IllegalArgumentException("La potion est vide");
        }
        else{
            player.setAttack((1 + getEffect()) * player.getAttack());
            this.setEffect(0);
        }
    }

    public void stopEffect(Avatar player){
        if(this.getEffect() == 0){
            player.setAttack((1 - getEffect()) * player.getAttack());
        }
    }
}