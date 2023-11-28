package Entity;
/*                                                                    /                                                                                           */
/*     Novembre  2023							                              /
/**********************************************************************/



public abstract class Entity {
   private int HP;   
   private int attack;
   private int defense;
   


   public boolean is_alive () {
      return (this.HP != 0);
   }

   public Entity (int HP, int attack, int defense) {
      this.HP = HP;
      this.attack = attack;
      this.defense = defense;
   }

   public int getHP() {
      return this.HP;
   }

   public int getAttack() {
      return this.attack;
   }
   
   public int getDefense () {
      return this.defense;
   }
   public void setHP(int nb) {
      this.HP = nb;
   }
   public void setAttack(int nb) {
      this.attack = nb;
   }
   public void setDefense (int nb) {
      this.defense = nb;
   }

   public boolean is_defeated () {
      return (this.HP <= 0);
   }

   public int getAttackPower() {
      return this.attack;
   }
   
}


