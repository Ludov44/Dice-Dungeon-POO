public Class Consumable implements Item{
    private string name;
    private int effect;
    private int price;

    public consumable(string n, int e, int p){
        this.name = n;
        this.effect = e;
        this.price = p;
    }

    public string getConsumable(){
        return this.name;
    }

    public string setConsumable(string n){
        this.name = n;
    }

    public getEffect(){
        return this.effect;
    }
    
    public setEffect(int v){
        this.effect = v;
    }

    public setPrice(int pr){
        this.price = pr;
    }

    public getPrice(){
        return this.price;
    }

}
