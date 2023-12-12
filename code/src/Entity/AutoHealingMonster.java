package Entity;

public class AutoHealingMonster extends Monster {
   private int luck;
   private int healingCapacity;

    /**
     * Monstre qui a 20% de chance de se soigner d'un nombre de PV égal à healingCapacity
     * @param HP
     * @param baseAttack
     * @param defense
     * @param type
     * @param reward
     * @param luck
     * @param healingCapacity
     */
    public AutoHealingMonster (int HP, int baseAttack, int defense, String type, int reward, int healingCapacity) {
        super (HP, baseAttack, defense, type, reward);
        this.healingCapacity = healingCapacity;
            
    }

    public void mayHeal() {
        double luck = Math.random();
        if (luck > 0.8) {
            this.setHP(this.getHP() + healingCapacity);
            if (this.getHP() + this.healingCapacity > this.getMaxHP()) {
                this.setHP(this.getMaxHP());
            }
        }
   }
   
    @Override
    public int getAttackPower() {
        this.mayHeal();
        return super.getAttackPower();
    }

    @Override
    public String toString(){
        return super.toString() + " (Healer)";
    } 
}

