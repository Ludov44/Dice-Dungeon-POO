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
      double attackEfficiency = Math.random() % 0.2 - 0.1;                
      return (int)(this.getbaseAttack() * (1 + 6 * attackEfficiency));     
   }
   /*
   les monstres de bases ont une puissance d'attaque entre 100% et 160% de leurs attaques
   */
   public int getReward() {
      return reward;
   }

   @Override
   public String toString(){
      return String.format(super.toString() + " (Reward = %d)", getReward());
   } 
}