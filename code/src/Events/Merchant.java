package Events;

import Entity.Avatar;
import Item.Item;
import java.util.ArrayList; 
import java.lang.Math;                          // Permet de générer un nombre random entre 0 et 1
import java.util.Scanner;                       // Permet les affichages/saisie utilisateurs


public class Merchant implements Event{
    ArrayList<Item> items;                          // Les items proposés par le marchand
    private final static int id = 2;                // Permet d'identifier les Events dans Room

    public Merchant()
    {
    //Début
        this.items = new ArrayList<Item>();
        this.fill();
     //Fin 
    }

    public void fill()
    {
    //Variables
        ArrayList<Item> allItems = Item.allObjects;
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
        String choix;
    // Début
        System.out.println("Vous avez trouvé un Marchand !");                                           // Affichage utilisateur
        
        for(Item i : items)
        {
            System.out.println("\t - Item trouvé :" + i.toString());                              // Affichage utilisateur pour les items
        }
        system.out.println();


        clavier.close();
        //Fin
        }

        @Override
        public int getId() {
            return id;
        }
        
    }
