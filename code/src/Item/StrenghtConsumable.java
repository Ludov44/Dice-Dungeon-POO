package Item;

import Entity.Avatar;

public class StrenghtConsumable extends Consumable{
    public static final int itemType = 4;

    public StrenghtConsumable(String name, int effect, int price){
        super(name, effect, price);
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

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public String toString(){
        return String.format("[%s] Force +%d", getName(), getBonus());
    }
}