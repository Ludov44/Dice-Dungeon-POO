package Events;
/* Fichier principal de la Librarie Event, contenant l'interface Event ainsi que ses 4 implémentations : Fight, Escape, Merchant et Chest.
 * 
 */


import Entity.Avatar;

public interface Event {
   public void trigger(Avatar player);
   public int getId();
}