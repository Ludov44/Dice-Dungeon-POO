package Entity;

public class Avatar extends Entity {
   private String name;
   private int maxHP;

   /**
    * @param name
    * @param HP
    * @param attack
    * @param defense
    */
   public Avatar (String name, int HP, int attack, int defense) {
      super (HP, attack, defense);
      this.name = name;
      this.maxHP = HP;
   }

   public int getMaxHP() {
      return this.maxHP;
   }

   public String getName() {
      return name;
   }

   @Override
   public int getAttackPower() {
        double attackEfficiency = (Math.random() % 0.1); 
        return (
            (int) Math.round(
                super.getAttackPower() * 
                (1 + attackEfficiency)
                )
        );
   }
   
/*
attackEfficiency prend une valeur dans { 0,1 ; 0,2 ; ... ; 0,9}
l'avatar a donc pour puissance d'attaque  entre 100% et 200% de son 
attaque
*/
}