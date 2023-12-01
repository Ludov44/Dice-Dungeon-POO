package Entity;
import.java.lang.Math;

public class Monster extends Entity {
   private string type;
   private int reward;

   public Monster (int HP, int attack, int defense, string type, string reward) {
      super (HP, attack, defense);
      this.type = type;
      this.reward = reward
   }



   @override
   public int getAttackPower() {
      private int attackEfficiency = (Math.random() % 0,1); 
      return ((int)Math.round(this.attack * (0.6 + attackEfficiency)))
   }
/*
les monstres de bases ont une puissance d'attaque entre 60% et 160%
*/
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

public class CriticalHitMonster extends Monster {
   private int luck

   public CriticalHitMonster (HP, A, D, T, R, L) {
      super (HP, A, D, T, R, L)
      this.luck = L;          //faire une condition luck entre 0 et 10
   }

   @override
   public int getAttackPower() {
      double attackEfficiency = Math.random() % 0.1;

      return ((this.attack * (0,6 + attackEfficiency)) % 1);
   }
}

/* la fonction getAttackPower a pour chaque utilisation en pourcentage de chance
si math.random < luck * 0,1, ça renvoie "Coup critique", et les dégats sont doublés/triplés
sinon ça fait des dégats normaux

la fonction setLuck vérifie que la Luck est < 10

}