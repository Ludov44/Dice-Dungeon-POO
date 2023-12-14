package Item;

import Entity.Avatar;

public class StrenghtConsumable extends Consumable{
    public static final int itemType = 4;//entier qui represente le type de l'item 


    /**
     * Constructeur pour créer un objet qui est une potion de force
     * @param name le nom de l'item
     * @param effect la valeur de force qui va être ajouté au stat su joueur
     * @param price le prix de l'item
     */
    public StrenghtConsumable(String name, int effect, int price){
        super(name, effect, price);
    }
    
    @Override
    public void use(Avatar player){
        player.setbaseAttack(player.getbaseAttack() + getEffect());
        player.setTempATK(getEffect());
    }

    /**
     * Methode qui permet d'arreter l'effet de force de la potion
     * @param player le joueur qui va avoir ses stats modifiées
     */
    public void stopEffect(Avatar player){ // ne sera pas utilisé ? - Raphaël
        if(this.getEffect() == 0){
            player.setbaseAttack(player.getbaseAttack() - getEffect());
        }
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public String toString(){
        return String.format("[%s] ATK +%d (value = %d)", getName(), getEffect(), getPrice());
    }

    @Override
    public Object clone(){
        return new StrenghtConsumable(getName(), getEffect(), getPrice());
    }
}