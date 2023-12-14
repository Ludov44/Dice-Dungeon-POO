package Item;

import Entity.Avatar;

public class HealthConsumable extends Consumable{
    public static final int itemType = 3;

    public HealthConsumable(String name, int effect, int price){
        super(name, effect, price);
    }

    @Override
    public void use(Avatar player){
        player.setHP(player.getHP() + this.getEffect());
    }

    @Override
    public String toString(){
        return String.format("[%s] Soin +%d (value = %d)", getName(), getEffect(), getPrice());
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public Object clone(){
        return new HealthConsumable(getName(), getEffect(), getPrice());
    }
}

