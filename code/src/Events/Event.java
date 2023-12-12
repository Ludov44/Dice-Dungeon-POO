package Events;
/**
 *  Fichier principal de la Librarie Event, contenant l'interface Event ainsi que ses 4 implémentations : Fight, Escape, Merchant et Chest.
 */


import Entity.Avatar;

public interface Event {
   /**
    * Methode déclenchant les différents Events
    * @param player le personnage joué.
    */
   public void trigger(Avatar player);

   /**
    * Getter de l'id des Events
    * @return
    */
   public int getId();
}