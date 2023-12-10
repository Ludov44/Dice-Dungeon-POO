package Item;

public abstract class Consumable implements Item{
    private String name;
    private int effect;
    private int price;

    public Consumable(String name, int effect, int price){
        this.name = name;
        this.effect = effect;
        this.price = price;
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

    public String getName() {
        return this.name;
    }

    public int getBonus() {
        return this.effect;
    }

    public abstract Object clone();
}
