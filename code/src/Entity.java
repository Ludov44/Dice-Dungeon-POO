/*                                                                    /                                                                                           */
/*     Novembre  2023							                              /
/**********************************************************************/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math



public abstract class Entity {
   private int HP;   public int getAttackPower() {
      return this.attack;
   }
   


   public boolean is_alive () {
      return (this.HP != 0)
   }
   public Entity (int HP, int attack, int defense) {
      this.HP = H;
      this.attack = A;
      this.defense = D;
   }

   public int getHP() {
      return this.HP;
   }

   public getAttack() {
      return this.attack;
   }
   
   public getDefense () {
      return this.defense;
   }
   public setHP(int nb) {
      this.HP = nb;
   }
      public setAttack() {
      return this.attack
   }
   public setDefense (int nb) {
      this.defense = nb;
   }

   public boolean is_defeated () {
      return (this.HP <= 0);
   }

   public int getAttackPower() {
      return this.attack;
   }
      public int getAttackPower() {
      return this.attack;
   }
   
}

public class Avatar extends Entity {
   private string name;
   private int maxHP;

   public Avatar (string name, int HP, int attack, int defense) {
      super (HP, attack, defense);
      this.name = name;
      this.maxHP = HP;
   }

   public getMaxHP() {
      return this.maxHP;
   }

   @override
   public int getAttackPower() {
      private int attackEfficiency = (Math.random() % 0.1); 
      return ((int)Math.round(this.attack * (1 + attackEfficiency)))
   }
/*
attackEfficiency prend une valeur dans { 0,1 ; 0,2 ; ... ; 0,9}
l'avatar a donc pour puissance d'attaque  entre 100% et 200% de son 
attaque
*/
}

public class Monster extends Entity {
   private string type;


   @override
   public int getAttackPower() {
      private int attackEfficiency = (Math.random() % 0,1); 
      return ((int)Math.round(this.attack * (0.6 + attackEfficiency)))
   }
/*
les monstres de bases ont une puissance d'attaque entre 60% et 160%
*/
}



