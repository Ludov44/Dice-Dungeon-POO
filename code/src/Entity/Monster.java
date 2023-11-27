package Entity;
import java.lang.Math;

public class Monster extends Entity {
   private String type;

   /**
    * @param type
    * @param HP
    * @param attack
    * @param defense
    */
   public Monster(String type, int HP, int attack, int defense){
         super (HP, attack, defense);
         this.type = type;
   }

   public String getType() {
      return type;
   }

   @Override
   public int getAttackPower() {
      double attackEfficiency = (Math.random() % 0.1); 
      return ((int)Math.round(super.getAttackPower() * (0.6 + attackEfficiency)));
   }
/*
les monstres de bases ont une puissance d'attaque entre 60% et 160%
*/
}

