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
    *Calcule et retourne la quantité de dégâts infligés par cette entité à une cible et mets à jour les HP de la cible
    * @param target Entité cible de l'attaque
    * @return Quantité de dégâts infligés
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

   /**
    * Value si l'entité est vivante
    * @return Vrai si l'entité est vivante, faux
    */
   public boolean is_alive () {
      return (this.HP > 0);
   }
   
   /**
    * Value si l'entité est morte
    * @return Vrai si l'entité est vivante, faux sinon
    */
   public boolean is_dead () {
      return (this.HP <= 0);
   }
    /**
    * Getter de l'attribut events
    * @return la liste d'event
    */
   public String getName() {
      return this.name;
   }
   /**
    * Setter de l'attribut name
    * @param name Nouveau nom de l'entité
    */
   public void setName(String name) {
      this.name = name;
   }
    /**
    * Getter des HPs maxs
    * @return Les HPs maxs de l'entité
    */
   public int getMaxHP() {
      return maxHP;
   }
   /**
    * Setter de l'attribut maxHP
    * @param maxHP Nouveau Hps max de l'entité
    */
   public void setMaxHP(int maxHP) {
      this.maxHP = maxHP;
   }
    /**
    * Getter des HPs actuels de l'entité
    * @return Les HPs actuels de l'entité
    */
   public int getHP() {
      return this.HP;
   }
    /**
    * Getter de l'attaque de l'entité
    * @return L'attaque de l'entité
    */
   public int getbaseAttack() {
      return this.baseAttack;
   }
    /**
    * Getter de la défense de l'entité
    * @return La défense de l'entité
    */
   public int getDefense () {
      return this.defense;
   }

   /**
    * Setter de l'attribut HP borné à [0, this.maxHP]
    * @param nb Nouvelle valeur des HP actuels de l'entité
    */
   public void setHP(int nb) {
      this.HP = Math.min(Math.max(0, nb), this.getMaxHP());
   }
   /**
    * Setter de l'attribut Attack
    * @param name Nouvelle valeur de l'attaque de l'entité
    */
   public void setbaseAttack(int nb) {
      this.baseAttack = nb;
   }
   /**
    * Setter de l'attribut defense
    * @param name Nouvelle valeur de la défense de l'entité
    */
   public void setDefense (int nb) {
      this.defense = nb;
   }
   /**
    * Getter de l'attribut Attack
    * @return L'attaque de l'entité
    */
   public int getAttackPower() {
      return this.baseAttack;
   }

   public String toString(){
      return String.format("[%s] - HP : %d/%d, ATK : %d, DEF : %d", 
         getName(), getHP(), getMaxHP(), getbaseAttack(), getDefense());
   }

}

