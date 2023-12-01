package Item;

public abstract class Consumable implements Item{
    private String name;
    private int effect;
    private int price;

    public Consumable(String n, int e, int p){
        this.name = n;
        this.effect = e;
        this.price = p;
    }

    public String getConsumable(){
        return this.name;
    }

    public void setConsumable(String n){
        this.name = n;
    }

    public int getEffect(){
        return this.effect;
    }
    
    public void setEffect(int v){
        this.effect = v;
    }

    public void setPrice(int pr){
        this.price = pr;
    }

    public int getPrice(){
        return this.price;
    }

}
