import Item.*;
import Entity.*;


public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Test equipping joueur :");
        Inventory inv = new Inventory();
        Avatar player = new Avatar("pedro", 10, 10, 10, inv);
        Item objet = new Weapon("epee", 100, 5);
        System.out.println(objet.toString());
        objet.use(player);
        System.out.println(player.toString());
    }
}

