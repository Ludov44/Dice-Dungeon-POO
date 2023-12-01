public Class Armor extends Equipement{
    
    public armor(string n, int p, int b){
        super(n, p, b);
        
    }

    @Override
    public use(Avatar player){
        this.isEquip = true;
        player.defence += this.bonus;
    }

    @Override 
    public abstract void unuse(Avatar player){
        this.isEquip = false;
        player.defence -= this.bonus;
    }
}