package Events;

import Entity.Avatar;
import Item.Equippable;
import Item.Item;
import Item.ItemList;
import io.UserInput;

import java.util.ArrayList; 
import java.lang.Math;                          // Permet de générer un nombre random entre 0 et 1

public class Merchant implements Event{
    ArrayList<Item> items;                          // Les items proposés par le marchand
    private final static int id = 2;                // Permet d'identifier les Events dans Room

    /**
     * Constructeur de la classe Merchant
     */
    public Merchant()
    {
    //Début
        this.items = new ArrayList<Item>();
        this.fill();
     //Fin 
    }

    /**
     * Remplit la vitrine du marchand avec 3 items aléatoires
     */
    public void fill()
    {
    //Variables
        ArrayList<Item> allItems = ItemList.allObjects();
        double dice = Math.random();                              // Variables contenant un réel généré aléatoirement entre 0 et 1.
        int ind = (int)(dice*allItems.size());                    // Choisit aléatoirement un premier item 

    //Début

        items.add(allItems.get(ind));                       // Attribue l'item, tiré aléatoirement au début de la méthode, à l'étalage du marchand

        dice = Math.random();
        ind = (int)(dice*allItems.size());                  // sélectionne un nouvel item
        items.add(allItems.get(ind));                       // Attribue l'item tiré aléatoirement à la ligne précédente à l'étalage du marchand

        dice = Math.random();
        ind = (int)(dice*allItems.size());                  // sélectionne un troisième item
        items.add(allItems.get(ind));                       // Attribue l'item tiré aléatoirement à la ligne précédente à l'étalage du marcha
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void trigger(Avatar player) 
    {
        // Début
        System.out.println("Vous avez trouvé un Marchand !\nItems en vente :\n");                                      // Affichage utilisateur
        
        for(Item i : items)
        {
            System.out.println(String.format("\t - %s", i.toString()));                                // Affichage utilisateur pour les items
        }

        int choice = UserInput.getInt("Tapez 1, 2 ou 3 pour achetez l'item voulu, tapez une autre touche si aucun item ne vous intéresse : ");
       
        if (choice == 1 || choice == 2 || choice == 3){
            Item item = items.get(choice);
            if(player.getInv().getMoney() >= item.getPrice())
            {
                player.changeMoney(-item.getPrice());
                if (item.getItemType() == 1 || item.getItemType() == 2) {
                    player.getInv().addItem( (Equippable) item);
                                        
                }
            }
        }
    }     
}
