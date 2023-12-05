package Entity;

public class CriticalHitMonster extends Monster {
   private int luck;

   public CriticalHitMonster (int HP, int attack, int defense, String type, int reward, int luck) {
      super (HP, attack, defense, type, reward);
      this.luck = luck;          //faire une condition luck entre 0 et 10
   }

   @Override
   public int getAttackPower() {
      double attackEfficiency = Math.random() % 0.1;

      return (int)((this.getAttack() * (0.6 + attackEfficiency)) % 1);
   }
}

/* la fonction getAttackPower a pour chaque utilisation en pourcentage de chance
si math.random < luck * 0,1, ça renvoie "Coup critique", et les dégats sont doublés/triplés
sinon ça fait des dégats normaux

la fonction setLuck vérifie que la Luck est < 10

}
*/
