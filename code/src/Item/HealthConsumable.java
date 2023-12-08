public Class HealthConsumable extends Consumable{

    public healthConsumable(string n, int h , int p){
        super(n, h, p);
    }

    @Override
    public void use(Avatar player){
        if (this.effect == 0){
            throw new IllegalArgumentException("La potion est vide");
        }
        else{
            player.currentHP += this.effect;
            if(player.HP > player.maxHP){
                player.HP = player.maxHP;
            }
            this.effect = 0;
        }
    }
}

