/***                                                                                              */
/*                                                                                               */
/*     Novembre  2023							                                                */
/*                                                                                             */
/**********************************************************************/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Math



public class Entity {         
     private int HP;
     private int attack;
     private int defense;


     public boolean is_alive () {
        return (this.HP != 0)
     }
     public Entity (int HP, int attack, int defense) {
        this.HP = H;
        this.attack = A;
        this.defense = D;
     }

     public int attackPower() {
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

   @override
   public int attackPower {
      private int attackEfficiency = Math.random() % 0,1; 
      return (this.attack * (1 + attackEfficiency) - this.attack)
   }
/*
attackEfficiency est compris entre 0% et 100%
l'avatar fait donc  entre 100% et 200% (techniquement 190%) de son a
attaque en puissance d'attaque
*/
}

public class Monster extends Entity {
   private string type;
   private int reward;

   public boolean is_defeated () {
      return (this.HP <= 0);
   }


   public Monster (string type, int reward, int HP, int attck, defense) {
      super (int HP, int attack, int defense);
      this.type = type;
      this.reward = reward;
   }
}



