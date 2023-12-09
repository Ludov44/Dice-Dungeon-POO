package Item;

import Entity.Avatar;

public class StrenghtConsumable extends Consumable{

    public StrenghtConsumable(String name, int effect, int price){
        super(name, effect, price);
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
            player.setAttack(player.getAttack() + getEffect());
            this.setEffect(0);
        }
    }

    public void stopEffect(Avatar player){ // ne sera pas utilisé ? - Raphaël
        if(this.getEffect() == 0){
            player.setAttack(player.getAttack() - getEffect());
        }
    }
}