package Entity;

public class AllOrNothingMonster extends Monster {

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
   
}

