package Item;

import Entity.Avatar;

public class HealthConsumable extends Consumable{

    public HealthConsumable(String name, int effect, int price){
        super(name, effect, price);
    }

    @Override
    public void use(Avatar player){
        if (this.getEffect() == 0){
            throw new IllegalArgumentException("La potion est vide");
        }
        else{
            player.setHP(player.getHP() + this.getEffect());
            if(player.getHP() > player.getMaxHP()){
                player.setHP(player.getMaxHP());;
            }
            this.setEffect(0);
        }
    }
}

