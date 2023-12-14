package Item;

public abstract class Consumable implements Item{
    private String name;
    private int effect;
    private int price;


    /**
     * Conctructeur de la classe Consumable
     * @param name le nom du consommable
     * @param effect l'entier qui représente la valeur qui va être ajouté a la stat modifiée par l'item
     * @param price  le prix de l'objet dans le magasin
     */
    public Consumable(String name, int effect, int price){
        this.name = name;
        this.effect = effect;
        this.price = price;
    }

    /**
     * Getter de consumable
     * @return une chaine de caractère représentant le nom du consumable
     */
    public String getConsumable(){
        return this.name;
    }

    /**
     * Setter du nom d'un consumable
     * @param n le nouveau nom du consumable
     */
    public void setConsumable(String n){
        this.name = n;
    }
    
    /**
     * Getter de l'effet d'un consumable
     * @return un entier représentant l'effet d'un consumable   
     */
    public int getEffect(){
        return this.effect;
    }
    
    /**
     * Setter de l'effet d'un consumable
     * @param v la nouvelle valeur du consumable 
     */
    public void setEffect(int v){
        this.effect = v;
    }

    /**
     * Setter du prix d'un consumable
     * @param pr nouveau prix du consumable 
     */
    public void setPrice(int pr){
        this.price = pr;
    }

    /**
     * Getter du prix d'un consumable 
     * @return un entier représentant le prix de consumable 
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Getter du nom du consumable
     * @return une chaine de caractères représentant le nom du consumable
     */
    public String getName() {
        return this.name;
    }

    /**
     * methode abstraite permettant de cloner un consumable 
     */
    public abstract Object clone();
}
