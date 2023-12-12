package Item;

import Entity.Avatar;

public class Armor extends Equippable{
    public static final int itemType = 1; //entier qui represente le type de l'item 

    /**
     * Constructeur pour créer un objet qui est une armure
     * @param name le nom de l'armure 
     * @param price le prix de l'armure
     * @param bonus le bonus de l'armure
     */
    public Armor(String name, int price, int bonus){
        super(name, price, bonus);  
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public void use(Avatar player){
        for (Equippable item : player.getInv().getContent()) {
            if (item.getIsEquip() && item.getItemType() == this.getItemType()) {
                item.unuse(player);
            }
        }
        this.setIsEquip(true);
        player.setDefense(player.getDefense() + this.getBonus());
    }

    @Override 
    public void unuse(Avatar player){
        this.setIsEquip(false);
        player.setDefense(player.getDefense() - this.getBonus());
        System.out.println(String.format("Armure retirée => %s", this.toString()));
    }

    @Override
    public String toString(){
        String res = String.format("[%s] DEF +%d (value = %d)", getName(), getBonus(), getPrice());
        if (this.getIsEquip()) {
            res += " [E]";
        }
        return res;
    }

    @Override
    public Object clone(){
        return new Armor(getName(), getPrice(), getBonus());
    }
}