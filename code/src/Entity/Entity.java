package Entity;

public abstract class Entity {
   private int HP;
   private int baseAttack;
   private int defense;
   private int maxHP;
   private String name;

   public Entity (int HP, int baseAttack, int defense, String name) {
      this.HP = HP;
      this.maxHP = HP;
      this.baseAttack = baseAttack;
      this.defense = defense;
      this.name = name;
   }

   /**
    * Calculates the damage dealt by this Entity to target, sets new HP for target, then returns damage
    * @param target Entity to be attacked
    * @return damage dealt to target Entity
    */
   public int attack(Entity target){
      int damage = this.getAttackPower() - target.getDefense();
      if (damage < 1) { // if attack is blocked, 50% chance to deal no damage, and 50% to deal 1 damage
         if (Math.random() > 0.5) {
            damage = 0;
         }
         else{
            damage = 1;
         }
      }
      target.setHP(target.getHP() - damage);
      return damage;
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

   public int getbaseAttack() {
      return this.baseAttack;
   }
   
   public int getDefense () {
      return this.defense;
   }

   /**
    * borné à [0, this.maxHP]
    * @param nb
    */
   public void setHP(int nb) {
      this.HP = Math.min(Math.max(0, nb), this.getMaxHP());
   }

   public void setbaseAttack(int nb) {
      this.baseAttack = nb;
   }

   public void setDefense (int nb) {
      this.defense = nb;
   }

   public int getAttackPower() {
      return this.baseAttack;
   }

   public String toString(){
      return String.format("[%s] - HP : %d/%d, ATK : %d, DEF : %d", 
         getName(), getHP(), getMaxHP(), getbaseAttack(), getDefense());
   }

}

