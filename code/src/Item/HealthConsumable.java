package Item;

import Entity.Avatar;

public class HealthConsumable extends Consumable{
    public static final int itemType = 3;

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

    @Override
    public String toString(){
        return String.format("[%s] Soin +%d", getName(), getBonus());
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}

