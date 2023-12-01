public Class Weapon extends Equipement{
    
    public weapon(string n, int p, int b){
        super(n, p, b);
    }

    @Override
    public use(Avatar player){
        this.isEquip = true 
        player.attack += this.bonus;
    }

    @Override 
    public abstract void unuse(Avatar player){
        this.isEquip = false 
        player.attack -= this.bonus;
    }
}