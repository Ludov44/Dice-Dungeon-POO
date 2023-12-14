package Entity;
import java.lang.Math;

public class Monster extends Entity {
   private int reward;

   public Monster (int HP, int baseAttack, int defense, String type, int reward) {
      super (HP, baseAttack, defense, type);
      this.reward = reward;
   }

   @Override
   public int getAttackPower() {
      double attackEfficiency = Math.random() % 0.2 - 0.05;                
      return (int)(this.getbaseAttack() * (1 + 8 * attackEfficiency)); // les monstres de base ont une puissance d'attaque entre 80% et 160% de leur attaque de base
   }
   
   public int getReward() {
      return reward;
   }

   @Override
   public String toString(){
      return String.format(super.toString() + " (Reward = %d)", getReward());
   } 
}