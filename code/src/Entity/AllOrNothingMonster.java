package Entity;

public class AllOrNothingMonster extends Monster {

   /**
    * Monstre qui à 50% de chance de manquer son attaque, et 50% de chance de faire des dégâts égal à 2.5 fois son attaque
    * @param HP
    * @param attack
    * @param defense
    * @param type
    * @param reward
    * @param luck
    */
   public AllOrNothingMonster (int HP, int attack, int defense, String type, int reward, int luck) {
      super (HP, attack, defense, type, reward);
   }

   @Override
   public int getAttackPower() {
      double luck = Math.random();
      if (luck > 0.5) {
         return (int) (this.getAttack() * 2.5);
      }
      else {
         return 0;
      }
      
   }
   
   @Override
   public String toString(){
      return super.toString() + " (CriticalOnly)";
   }
}

