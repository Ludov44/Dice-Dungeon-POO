package Events;

import Entity.Avatar;
import Item.Item;

import java.util.ArrayList;                     // Permet l'utilisation des listes
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.lang.Math;                          // Permet de générer un nombre random entre 0 et 1
import java.util.Scanner;                       // Permet les affichages/saisie utilisateurs

public class Chest implements Event {
   private int money;
   private ArrayList<Item> items;
   private final static int id = 1;             // Permet d'identifier les Events dans Room
   private final static int baseReward = 8;     // Permet de modifier rapidement les récompense de monnaie des coffres

   
   /**
    * 
    */
   public Chest()
   {
      //Début
         this.items = new ArrayList<Item>();
         this.fill();
      //Fin
   }
   /**
    * 
    * @return
    */
   public int getMoney()
   {
      //Début
         return money;
      //Fin
   }

   public ArrayList<Item> getItems()
   {
      //Début
         return items;
      //Fin
   }

   public void setMoney(int newMoney)
   {
      //Début
         money = newMoney;
      //Fin
   }

   @Override
   public int getId()
   {
      //Début
      return Chest.id;
      //Fin
   }

   
    public void fill
    {
        //Variables
        ArrayList<Item> allItem;
        double dice = Math.random();
        int ind = (int)(dice*allItem.size());
        Object ob = new JsonParser().parse(new FileReader("Items.json"))

        //Début

         FileReader("Items.json")
            allItems.add();

         if (dice < 0.25)
         {
            setMoney(baseReward); 
         }
         else if(dice < 0.60)
         {
            setMoney((int)(baseReward*0.75));
            items.add(allItem.get(ind));
         }
         else if(dice < 0.90)
         {
            setMoney((int)(baseReward*0.5));
            items.add(allItem.get(ind));

            dice = Math.random();
            ind = (int)(dice*allItem.size());
            items.add(allItem.get(ind));
         }
         else
         {
            items.add(allItem.get(ind));

            dice = Math.random();
            ind = (int)(dice*allItem.size());
            items.add(allItem.get(ind));

            dice = Math.random();
            ind = (int)(dice*allItem.size());
            items.add(allItem.get(ind));
         //Fin
         }
   }

    

    @Override
    public void trigger(Avatar player){
      //Variables
      Scanner clavier = new Scanner(System.in);
      String choix;
      // Début
      System.out.println("Vous avez trouvé un coffre !"); 
      System.out.println("Taper O si vous voulez l'ouvrir, Tapez N sinon"); 
      choix = clavier.nextLine();
      if(choix == "o" || choix == "O" )
      {
         if (this.getMoney() > 0) {
            System.out.println("Vous avez trouvé " + this.getMoney() +  " coins dans le coffre");
            player.getInv().changeMoney(this.getMoney());
         }
         for (Item item : items) {
            System.out.println("\t - Item trouvé :" + item.toString());
            player.getInv().addItem(item);
         }
      }
      else 
      {
         System.out.println("Le coffre est abandonné");
      }
      clavier.close();
      //Fin
    }
}
