package Item;

import Entity.Avatar;

public interface Item {
    /**
     * Methode pour utiliser l'item et qui modifie éventuellement les stats du joueur
     * @param joueur représente le joueur qui va utiliser l'item 
     */
    public void use(Avatar player);
    /**
     * Getter du prix d'un item
     * @return entier représentant le nom de l'item
     */
    public int getPrice();

    /**
     * Getter du nom d'un item
     * @return chaine de caracteres représentant le nom de l'item
     */
    public String getName();

    /**
     * Getter du type d'un item
     * @return entier représentant le type de l'item
     */
    public int getItemType();

    /**
     * methode abstraite permettant de cloner un consumable 
     */
    public Object clone();
}
