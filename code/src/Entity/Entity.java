package Entity;

public abstract class Entity {
   private int HP;
   private int attack;
   private int defense;
   private int maxHP;
   private String name;

   public Entity (int HP, int attack, int defense, String name) {
      this.HP = HP;
      this.maxHP = HP;
      this.attack = attack;
      this.defense = defense;
      this.name = name;
   }
   
   // pourquoi is_alive et is_dead existent tous les deux ? - Raphaël
   public boolean is_alive () {
      return (this.HP > 0);
   }

   public boolean is_dead () {
      return (this.HP <= 0);
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getMaxHP() {
      return maxHP;
   }

   public void setMaxHP(int maxHP) {
      this.maxHP = maxHP;
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

   public String toString(){
      return String.format("[%s] - HP : %d/%d, ATK : %d, DEF : %d)", 
         getName(), getHP(), getMaxHP(), getAttack(), getDefense());
   }

}

