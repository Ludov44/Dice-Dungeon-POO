package Events;

import Entity.Avatar;
import Item.Item;
import Item.ItemList;

import java.util.ArrayList; 
import java.lang.Math;                          // Permet de générer un nombre random entre 0 et 1
import java.util.Scanner;                       // Permet les affichages/saisie utilisateurs


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
    public void trigger(Avatar player) 
    {
    //Variables
        Scanner clavier = new Scanner(System.in);
        String choix = "";
    // Début
        System.out.println("Vous avez trouvé un Marchand !");                                      // Affichage utilisateur
        
        for(Item i : items)
        {
            System.out.println("\t - Item trouvé :" + i.toString());                                // Affichage utilisateur pour les items
        }

        while (choix!="1" || choix != "2"|| choix != "3" || choix != "s" || choix != "S") {
           System.out.println("/t - Tapez 1, 2 ou 3 pour achetez l'item voulu, tapez s si aucun item vous intéresse.");    // Proposition utilisateur
            choix = clavier.nextLine();                                                                 // Lecture de la réponse de l'utilisateur
         }
       
        if( choix != "s" && choix != "S" )
        {
            if(player.getInv().getMoney() >= items.get(Integer.parseInt(choix)).getPrice())
            {
                player.changeMoney(items.get(Integer.parseInt(choix)).getPrice());
                player.getInv().addItem(items.get(Integer.parseInt(choix)));
            }
        }
        
        clavier.close();
        //Fin
        }

        @Override
        public int getId() {
            return id;
        }
        
    }
