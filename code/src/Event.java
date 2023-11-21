/* Librarie Event.java, contenant l'interface Event aisni que ces 4 implémentations : Fight, Escape, Merchant et Chest.
 * 
 */


import Code.Entity; 
import java.util.ArrayList; 
import java.lang.Math;

 public interface Event {

    public void trigger(Avatar player);
 }

 public class Chest implements Event {
   private int money;
   private ArrayList<Item> items;

   public Chest(int money){
      //Début
         this.money = money;
         this.items = new ArrayList<Item>();
      //Fin
   }
   public int getMoney(){
      //Début
         return money;
      //Fin
   }

   public ArrayList<Item> getItems(){
      //Début
         return items;
      //Fin
   }

   public void setMoney(int newMoney){
      //Début
         money = newMoney;
      //Fin
   }

   @Override
   public void trigger(Avatar player){
      //Variables
         double dice = math.random();

      //Début
         
      //Fin
   }



 }