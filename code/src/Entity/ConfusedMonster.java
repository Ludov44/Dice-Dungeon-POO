package Entity;

public class ConfusedMonster extends Monster {

   /**
    * Monstre qui à 40% de chance de manquer son attaque
    * @param HP
    * @param attack
    * @param defense
    * @param type
    * @param reward
    */
   public ConfusedMonster(int HP, int attack, int defense, String type, int reward) {
      super (HP, attack, defense, type, reward);
   }

   @Override
   public int getAttackPower() {
      int attack = super.getAttackPower();
      double successful = Math.random();
      if (successful > 0.4) {
         return attack;
      }
      else {
         if (this.getHP() <= this.getMaxHP() * 0.3) {
            this.setHP(0);
         } 
         else {
            this.setHP(this.getHP() - (int) (this.getMaxHP() * 0.3));
         }
         return 0;
      }
   }

   @Override
   public String toString(){
      return super.toString() + " (Confused)";
   } 
}





