package Entity;
package Monster;
import java.lang.Math;

public class Monster extends Entite {
   private string type;
   private int reward;

   public Monster (int HP, int attack, int defense, string type, string reward) {
      super (HP, attack, defense);
      this.type = type;
      this.reward = reward;
   }


   @override
   public int getAttackPower() {
      int attackEfficiency = (Math.random() % 0.1); 
      return ((int)Math.round(this.attack * (0.6 + attackEfficiency)));
   }

}
