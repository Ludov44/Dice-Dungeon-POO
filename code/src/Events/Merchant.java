package Events;

import Entity.Avatar;
import Item.Equippable;
import Item.Item;
import Item.ItemGenerator;
import io.UserInput;

import java.util.ArrayList; 

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
     * Remplit la vitrine du marchand avec nbItems items aléatoires
     */
    public void fill()
    {
        int nbItems = 3;
        for (int i = 0; i < nbItems; i++) {
            items.add(ItemGenerator.getRandomItem());
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void trigger(Avatar player) // TODO : pouvoir vendre des items
    {
        // Début
        System.out.println("Vous avez trouvé un Marchand !\nItems en vente :");                                      // Affichage utilisateur
        
        for(int i = 0 ; i < items.size() ; i++)
        {
            System.out.println(String.format("\t%d - %s", i + 1, items.get(i).toString()));                                // Affichage utilisateur pour les items
        }

        System.out.println(player);
        int choice = UserInput.getInt("Tapez 1, 2 ou 3 pour achetez l'item voulu, tapez une autre touche si aucun item ne vous intéresse : ");
        if (choice == 1 || choice == 2 || choice == 3){
            Item item = items.get(choice - 1);
            System.out.println(String.format("Item choisi : %s", item.toString()));

            if(player.getInv().getMoney() >= item.getPrice())
            {
                player.changeMoney(-item.getPrice());
                if (item.getItemType() == 1 || item.getItemType() == 2) {
                    System.out.println(String.format("Equipement ajouté à l'inventaire : %s", item.toString()));
                    player.addItem( (Equippable) item);
                }
                else {
                    System.out.println(String.format("Consommable utilisé : %s", item.toString()));
                    item.use(player);
                }
            }
            else{
                System.out.println(String.format("Vous n'avez pas assez d'argent pour acheter cet item : prix = %d <=> money = %d", item.getPrice(), player.getInv().getMoney()));
            }
        }
    }     
}
