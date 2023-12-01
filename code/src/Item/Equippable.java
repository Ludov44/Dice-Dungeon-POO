public abstract Class Equipement implements Item{
    private string name;
    private int price;
    private int bonus;
    private boolean isEquip;

    public equipement(string nom, int prix, int b){
        this.name = nom;
        this.price = prix;
        this.bonus = b;
        this.isEquip = false
    }

    public getName(){
        return this.name;
    }

    public getPrice(){
        return this.price;
    }

    public getBonus(){
        return this.bonus;
    }

    public getIsEquip(){
        return this.isEquip;
    }

    public setName(string nom){
        this.name = nom;
    }

    public setPrice(int prix){
        this.price = prix;
    }

    public setBonus(int b){
        this.bonus = b
    }

    public setIsEquip(boolean bool){
        this.isEquip = bool;
    }

    public abstract void unuse(Avatar player);
        
}
