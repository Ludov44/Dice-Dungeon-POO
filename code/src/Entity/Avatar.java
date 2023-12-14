package Entity;
import java.lang.Math;

import Item.Equippable;
import io.UserInput;

public class Avatar extends Entity {
   private int maxHP;
   private Inventory stock;
   private int tempATK;

   
   public Avatar (String name, int HP, int baseAttack, int defense, Inventory stock) {
      super(HP, baseAttack, defense, name);
      this.maxHP = HP;     //on initialise un Avatar avec tous ses PV
      this.tempATK = 0;
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
      if (UserInput.getChoice(String.format("Voulez-vous équiper cet item (O/N) ? %s", item.toString()), 'O')) {       // TODO : afficher current equipped ?
         item.use(this);
         System.out.println(String.format("%s a bien été équipé", item.toString()));
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
   public int getAttackPower() {
      double attackEfficiency = Math.random() % 0.1 - 0.02;

      return (int) ((this.getbaseAttack() * (1 + 10 * attackEfficiency))); // le personnage joué a une puissance d'attaque entre 80% et 180% de son attaque de base
   }

   /**
    * Retire les effets des consommables utilisés sur le joueur (seulement pour l'attaque pour le moment)
    */
   public void endConsumableEffects(){
      this.setbaseAttack(this.getbaseAttack() - this.getTempATK());
   }

   public Inventory getInv() {
      return stock;
   }

   public int getTempATK() {
      return tempATK;
   }
   
   public void setTempATK(int tempATK) {
      this.tempATK = tempATK;
   }

   @Override
   public String toString(){
      return String.format(super.toString() + " (Inventory : %s)", getInv());
   }  
}
