package Entity;

public class AutoHealingMonster extends Monster {
   private int luck;
   private int healingCapacity;

   public AutoHealingMonster (int HP, int attack, int defense, String type, int reward, int luck, int healingCapacity) {
      super (HP, attack, defense, type, reward);
      this.luck = luck;
      this.healingCapacity = healingCapacity;
          
   }

    public void mayHeal() {
        double luck = Math.random();
        if (luck > 0.8) {
            this.setHP(this.getHP() + healingCapacity);
            if (this.getHP() > this.getMaxHP()) {
                this.setHP(this.getMaxHP());
            }
        }
   }

    public int getLuck() {
        return luck;
    }
   
    @Override
    public int getAttackPower() {
        mayHeal();
        double attackEfficiency = Math.random(); 
        return ((int)Math.round(this.getAttack() * (0.6 + attackEfficiency)));
    }

    @Override
    public String toString(){
        return super.toString() + " (Healer)";
    } 
}

