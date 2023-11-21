/* Librarie Event.java, contenant l'interface Event aisni que ces 4 implémentations : Fight, Escape, Merchant et Chest.
 * 
 */


import Code.Entity; 
import java.util.ArrayList; 
import java.lang.Math;
import java.util.Scanner;

 public interface Event {

    public void trigger(Avatar player);
    public int getId();
 }

 public class Chest implements Event {
   private int money;
   private ArrayList<Item> items;
   private final static int id = 1;
   

   public Chest(int money)
   {
      //Début
         this.money = money;
         this.items = new ArrayList<Item>();
      //Fin
   }
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
   puclic int getId()
   {
      //Début
      return this.id;
      //Fin
   }

   @Override
   public void trigger(Avatar player, arraylist<Item> allItem)
   
   {
      //Variables
         double dice = Math.random();
         int ind = (int)(dice*allItem.size());
         String choix;
         Scanner clavier = new Scanner(System.in);

      //Début

         System.out.println("Vous avez trouvé un coffre !"); 
         System.out.println("Taper O si vous voulez l'ouvrir, Tapez N sinon"); 
         choix = clavier.nextLine();
         if(choix == "o" || choix == "O" )
         {
            if (dice < 0.25)
            {
               setMoney(8);
            System.out.println("Vous avez trouvé 8 coins dans le coffre"); 
            }
            else if(dice < 0.60)
            {
               setMoney(6);
               items.add(ind);
            }
            else if(dice < 0.90)
            {
               setMoney(4);
               items.add(ind);

               dice = Math.random();
               ind = (int)(dice*allItem.size());
               items.add(ind);
            }
            else
            {
               items.add(ind);

               dice = Math.random();
               ind = (int)(dice*allItem.size());
               items.add(ind);

               dice = Math.random();
               ind = (int)(dice*allItem.size());
               items.add(ind);
            }
         }
         else 
         {
               System.out.println("Le coffre est abandonné");
         }
      //Fin
   



   }
}