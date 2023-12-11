package Events;

import java.util.ArrayList;                     // Permet l'utilisation des listes

import Entity.Avatar;
import Item.Equippable;
import Item.Item;
import Item.ItemGenerator;
import io.UserInput;

public class Chest implements Event {
   private int money;                          
   private ArrayList<Item> items;
   private final static int id = 1;             // Permet d'identifier les Events dans Room
   private final static int baseReward = 8;     // Permet de modifier rapidement les récompense de monnaie des coffres

   
   /**
    * Constructeur de la classe Chest.
    * Il créé la liste d'item et remplit le coffre en suivant certaines probabilités ( décrites dans le commentaire de la méthode fill )
    */
   public Chest()
   {
      //Début
         this.items = new ArrayList<Item>();
         this.fill();
      //Fin 
   }
   /**
    * Getter de l'attribut moneyallItem
   /**
    * Getter de l'attribut items
    * @return la liste d'Item "items"
    */
   public ArrayList<Item> getItems()
   {
      //Début
         return items;
      //Fin
   }

   /**
    * Setter de l'attribut money
    * @param newMoney nouvelle valeur de this.money ( remplace sans additionner)
    */
   public void setMoney(int newMoney)
   {
      //Début
         money = newMoney;
      //Fin
   }

   /**
    * Getter de l'attribut money
    * @return la monnaie du coffre, sous forme d'entier.
    */
   public int getMoney()
   {
      return money;
   }

   @Override
   /**
    * Getter de l'Id de cet Event
    * @return un entier représentant identifiant de l'event chest, ici 1
    */

   public int getId()
   {
      //Début
      return Chest.id;
      //Fin
   }

   
   /**
    * Remplit un Chest selon les probabilités suivantes : 
    * - 25% d'avoir 8 coins et 0 item
    * - 35% d'avoir 6 coins et 1 item
    * - 30% d'avoir 4 coins et 2 items
    * - 10% d'avoir 0 coin et 3 items
    * Pour cela il génère un nombre aléatoire entre 0 et 1 grace a "Math.random()", puis le multiplie au nombre d'items dans le jeu.
    */
    public void fill()
    {
      double dice = Math.random();                              // Variables contenant un réel généré aléatoirement entre 0 et 1, il décide quel type de coffre ce sera.

      if (dice < 0.25)                                         // coffre contenant 8 coins et 0 item : 25% de probabilités
      {
         setMoney(baseReward);                              // Attribue 8 coins a ce coffre
      }
      else if(dice < 0.60)                                     // coffre contenant 6 coins et 1 item : 35% de probabilités
      {
         setMoney((int)(baseReward*0.75));                  // Attribue 6 coins à ce coffre
         items.add(ItemGenerator.getRandomItem());                       
      }
      else if(dice < 0.90)                                     // coffre contenant 4 coins et 2 items : 30% de probabilités
      {
         setMoney((int)(baseReward*0.5));                   // Attribue 4 coins à ce coffre
         items.add(ItemGenerator.getRandomItem());                      
         items.add(ItemGenerator.getRandomItem());                       
      }
      else                                                     // coffre contenant 0 coins et 3 items : 10% de probabilités
      {
         items.add(ItemGenerator.getRandomItem());                       
         items.add(ItemGenerator.getRandomItem());                       
         items.add(ItemGenerator.getRandomItem());                       
      //Fin
      }
   }

    

    @Override

    /**
     * Méthode déclencheuse de l'Event Chest, implémentation de l'interface Event.
     * Elle ajoute les coins et items a l'inventaire de l'avatar si il décide de l'ouvrir
     * @param player Avatar de l'utilisateur pour la partie en cours
     */
    public void trigger(Avatar player){
      // Début
      System.out.println(player);
      System.out.println("Vous avez trouvé un coffre !");                         // Affichage utilisateur

      if(UserInput.getChoice("Ouvrir le coffre (O/N) ?", 'O'))                                                              // Vérifie que l'utilisateur souhaite ouvrir le coffre
      {
         System.out.println("Contenu du coffre :");     
         if (this.getMoney() > 0) {                                                                  
            System.out.println(String.format("\t - Vous avez trouvé %d coins dans le coffre", getMoney()));    // Affichage utilisateur pour les coins
            player.getInv().setMoney(this.getMoney() + player.getInv().getMoney());                                         // Ajoute la money à l'inventaire de l'avatar
         }
         for (Item item : items) {
            System.out.println(String.format("\t - Item trouvé : %s", item.toString()));                              // Affichage utilisateur pour les items
            if (item.getItemType() == 1 || item.getItemType() == 2) {
               System.out.println(String.format("Equipement ajouté à l'inventaire : %s", item.toString()));
               player.addItem( (Equippable) item);
            }
            else {
               System.out.println(String.format("Consommable utilisé : %s", item.toString()));
               item.use(player);
            }
         }
      }
      else 
      {
         System.out.println("Le coffre est abandonné");                                            // Affichage utilisateur
      }
      UserInput.getInput("...");
      //Fin
    }
}
