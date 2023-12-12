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


    /**
     * Getter de l'id de cet Event
     * @return L'id de l'evenement Merchant
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Méthode déclencheuse de l'Event Merchant, implémentation de l'interface Event.
     * Elle ajoute les items à la vitrine du marchand
     * @param player Avatar de l'utilisateur pour la partie en cours
     */
    @Override
    public void trigger(Avatar player) // TODO : pouvoir vendre des items
    {
        int choice;
        //boolean wannaSell = false;
        // Début
        System.out.println("Vous avez trouvé un Marchand !");                                      // Affichage utilisateur
        /*System.out.println("Voulez-vous vendre vos Items non-équipés, pour 50% de leurs values ? ");
        wannaSell = UserInput.getChoice("Tapez O si vous le voulez, tapez autre chose sinon: ", 'O');
        if(wannaSell){
            for (Equippable i : player.getInv().getContent()) {
                if(!(i.getIsEquip()))
                {
                    player.changeMoney((int)(i.getPrice()/2));
                    player.getInv().getContent().remove(i);
                }
            }
        }TODO*/

        


        System.out.println("Items en vente :");
        do {
            for(int i = 0 ; i < items.size() ; i++)
            {
                System.out.println(String.format("\t%d - %s", i + 1, items.get(i).toString()));                                // Affichage utilisateur pour les items
            }
            System.out.println(player);
            choice = UserInput.getInt(String.format("Tapez un chiffre entre 1 et %d pour acheter l'item voulu, tapez une autre touche si aucun item ne vous intéresse : ", this.items.size()));
            
            if (choice <= this.items.size() && choice >= 1) {
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

                this.items.remove(choice - 1);
            } 
            else {
                this.items.clear();
            }
        } while (!(this.items.isEmpty()));
    }     
}
