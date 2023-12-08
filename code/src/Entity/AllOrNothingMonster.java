package Entity;
package Monster;

public class AllOrNothingMonster extends Monster {

   public AllOrNothingMonster (HP, A, D, T, R) {
      super (HP, A, D, T, R);
   }

   @override
   public int getAttackPower() {
      double luck = Math.random();
      if (luck > 0.5) {
         return this.attack * 2.5;
      }
      else {
         return 0;
      }
      
   }
   
}

