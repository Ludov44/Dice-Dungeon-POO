package Item;

import Entity.Avatar;

public class StrenghtConsumable extends Consumable{
    

    public StrenghtConsumable(int h, String n, int p){
        if(this.effect < 1 || this.effect > 0){
            super(n, h, p);
        }
        else{throw new IllegalArgumentException("l'effect de force doit être entre 0 et 1");}
    }

    
    @Override
    public use(Avatar player){
        if (this.effect == 0){
            throw new IllegalArgumentException("La potion est vide");
        }
        else{
            player.attack = player.attack +(player.attack * this.effect) ;
            this.effect = 0;
        }
    }

    public stopEffect(Avatar player){
        if(this.effect == 0){
            player.attack = player.attack - (player.attack * this.effect)
        }
    }
}