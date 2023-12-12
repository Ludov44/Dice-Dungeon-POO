package Entity;

public class AutoHealingMonster extends Monster {;
   private int healingCapacity;

    /**
     * Monstre qui a 20% de chance de se soigner d'un nombre de PV égal à healingCapacity
     * @param HP entier representant les HP
     * @param baseAttack entier representant les degats de base
     * @param defense entier representant la defense
     * @param type chaine de caractere representant le type de monstre
     * @param reward entier representant la recompense
     * @param healingCapacity entier représentant la regeneration du monstre
     */
    public AutoHealingMonster (int HP, int baseAttack, int defense, String type, int reward, int healingCapacity) {
        super (HP, baseAttack, defense, type, reward);
        this.luck = luck;
        this.healingCapacity = healingCapacity;
            
    }

    /**
     * donne une chance au monstre de se soigner
     */
    public void mayHeal() {
        double luck = Math.random();
        if (luck > 0.8) {
            this.setHP(this.getHP() + healingCapacity);
            if (this.getHP() > this.getMaxHP()) {
                this.setHP(this.getMaxHP());
            }
        }
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

