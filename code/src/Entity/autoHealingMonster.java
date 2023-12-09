package Entity;

public class AutoHealingMonster extends Monster {
   private int luck;
   private int healingCapacity;

    /**
     * Monstre qui a 20% de chance de se soigner d'un nombre de PV égal à healingCapacity
     * @param HP
     * @param attack
     * @param defense
     * @param type
     * @param reward
     * @param luck
     * @param healingCapacity
     */
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
        return super.getAttackPower();
    }

    @Override
    public String toString(){
        return super.toString() + " (Healer)";
    } 
}

