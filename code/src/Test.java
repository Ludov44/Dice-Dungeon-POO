import Item.*;
import Entity.*;


public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Test equipping joueur :");
        Inventory inv = new Inventory();
        Avatar player = new Avatar("Pedro", 20, 10, 10, inv);
        Equippable objet = new Weapon("épée", 100, 5);
        System.out.println(player.toString());
        System.out.println(objet.toString());
        objet.use(player);
        player.getInv().addItem(objet);
        System.out.println(player.toString());
        objet.unuse(player);
        System.out.println(player.toString());
    }
}

