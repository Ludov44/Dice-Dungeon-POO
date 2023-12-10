package Entity;
import java.lang.Math;

import Item.Equippable;
import io.UserInput;

public class Avatar extends Entity {
   private int maxHP;
   private Inventory stock;

   public Avatar (String name, int HP, int baseAttack, int defense, Inventory stock) {
      super(HP, baseAttack, defense, name);
      this.maxHP = HP;     //on initialise un Avatar avec tous ses PV
      this.stock = stock;
   }
   public int getMaxHP() {
      return this.maxHP;
   }

   public void setMaxHP(int nb) {
      this.maxHP = nb;       
   }

   /**
    * Asks whether the user wants to equip the item, then adds the item to inventory
    * @param item
    */
   public void addItem(Equippable item){
      if (UserInput.getChoice(String.format("Voulez-vous equiper cet item (O/N) ? %s", item.toString()))) {
         item.use(this);
         System.out.println("item équipé");
      }
      this.getInv().addItem(item);
   }

   public int getStockMoney() {
      return this.stock.getMoney();
   }

   public void changeMoney(int nb) {
      this.stock.setMoney(this.stock.getMoney() + nb);
   }

   @Override
   protected int getAttackPower() {
      double attackEfficiency = Math.random() % 0.1;

      return (int) ((this.getbaseAttack() * (1 + attackEfficiency)));
   }

   public Inventory getInv() {
      return stock;
   }

   @Override
   public String toString(){
      return String.format(super.toString() + " (Inventory : %s)", getInv());
   }  
}
