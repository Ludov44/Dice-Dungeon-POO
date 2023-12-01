package Entity;

import Entity.Entity;
import java.lang.Math;

public class Avatar extends Entity {
   private int maxHP;
   private String name;
   private Inventory stock;

   public Avatar (String name, int HP, int attack, int defense, Inventory stock) {
      super(HP, attack, defense);
      this.maxHP = HP;     //on initialise un Avatar avec tous ses PV
      this.name = name;
      this.stock = stock;
   }
   public int getMaxHP() {
      return this.maxHP;
   }

   public void setMaxHP(int nb) {
      this.maxHP = nb;       
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getStockMoney() {
      return this.stock.money;
   }

   public void addMoney(int nb) {
      this.stock.money = this.stock.money + nb;
   }

   @override
   public int getAttackPower() {
      double attackEfficiency = Math.random() % 0.1;

      return ((this.attack * (1 + attackEfficiency)) % 1);
   }
}