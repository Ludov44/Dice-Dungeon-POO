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
   les monstres de bases ont une puissance d'attaque entre 60% et 160%
   */
   public int getReward() {
      return reward;
   }

   @Override
   public String toString(){
      return String.format(super.toString() + " (Reward = %d)", getReward());
   } 
}



/*différentes idées de monstre sur lequels on peut tomber (je ne les implémenterai pas tous) :
-fait des coups normaux à chaque attaque
-fait des coups normaux + dégats poisons à chaque tour
-fait des coups normaux mais avec chance de coup critique
-possède une attaque spécial avec tour de chargement
-évolue au milieu du combat 
-gagne/pe^plusieurs fois
-se blesse quand il attaque
-inflige des dégats quand il prend des dégats de recul
-soigne les autres monstres
-attaques les autres monstres 
-empêche de se soigner 
*/