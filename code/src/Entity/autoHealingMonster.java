package Entity;
package Monster;

public class AutoHealingMonsterMonster extends Monster {
   private int luck;
   private int healingCapacity;

   public AutoHealingMonster (int HP, int attack, int defense, String type, int reward, int luck, int healingCapacity, int maxHP ) {
      super (HP, attack, defense, type, reward);
      this.maxHP = HP;
      this.luck = luck;
      this.healingCapacity = healingCapacity;
          
   }

   public void mayHeal() {
    double luck = Math.random();
    if (luck > 0.8) {
        this.HP = this.HP + healingCapacity;
        if (this.HP > this.maxHP) {
            this.HP = this.maxHP;
        }
    }
   }
   
   @override
   public int getAttackPower() {
    mayHeal();
    int attackEfficiency = Math.random(); 
    return ((int)Math.round(this.attack * (0.6 + attackEfficiency)));
   }


}

