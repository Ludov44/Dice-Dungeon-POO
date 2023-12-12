package Entity;

public class AllOrNothingMonster extends Monster {

   /**
    * Monstre qui à 50% de chance de manquer son attaque, et 50% de chance de faire des dégâts égal à 2.5 fois son attaque
    * @param HP entier representant les HP
    * @param baseAttack entier representant les degats de base
    * @param defense entier representant la defense
    * @param type chaine de caractere representant le type de monstre
    * @param reward entier representant la recompense
    */
   public AllOrNothingMonster (int HP, int baseAttack, int defense, String type, int reward) {
      super (HP, baseAttack, defense, type, reward);
   }

   @Override
   public int getAttackPower() {
      double luck = Math.random();
      if (luck > 0.5) {
         return (int) (this.getbaseAttack() * 3);
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

