package Entity;

public abstract class Entite {
   private int HP;
   private int attack;
   private int defense;

   public Entite (int HP, int attack, int defense) {
      this.HP = HP;
      this.attack = attack;
      this.defense = defense;
   }
   
   public boolean is_alive () {
      return (this.HP >= 0);
   }

   public boolean is_dead () {
      return (this.HP <= 0);
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

   public int getAttackPower() {
      return this.attack;
   }

}

