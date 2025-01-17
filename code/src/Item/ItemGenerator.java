package Item;

import java.util.ArrayList;


public class ItemGenerator{

    public final static ArrayList<Item> allObjects = ItemGenerator.generateObjects();

    /**
     * @param ind
     * @return Copie de l'item à l'index ind dans allObjects
     */
    public static Item getItemAtIndex(int ind){
        return (Item) allObjects.get(ind).clone();
    }

    /**
     * @return Copie d'un item aléatoire dans la liste des items de allObjects
     */
    public static Item getRandomItem(){
        int ind = (int)(Math.random()*allObjects.size());
        return getItemAtIndex(ind);
    }

    /**
     * Créer les Items de la games
     * @return La liste d'items
     */
    public static ArrayList<Item> generateObjects(){ // TODO : ajouter des items ? (exemple : amulettes pour up les HP)
        Item bandage = new HealthConsumable("Bandage", 4, 1);
        Item petiteH = new HealthConsumable("Petite potion de soin", 6, 2);
        Item normaleH = new HealthConsumable("Potion de soin", 10, 4);
        Item grosseH = new HealthConsumable("Grosse potion de soin", 20, 10);

        Item petiteS = new StrenghtConsumable("Petite potion de force", 2, 3);
        Item normaleS = new StrenghtConsumable("Potion de force", 4, 5);
        Item grosseS = new StrenghtConsumable("Grosse potion de force", 10, 10);
        
        Item epee = new Weapon("épée", 12, 5);
        Item hache = new Weapon("hache", 14, 6);
        Item dague = new Weapon("dague", 8, 3);
        Item lance = new Weapon("lance", 10, 4);

        Item cuir = new Armor("armure en cuir", 6, 2);
        Item fer = new Armor("armure en fer", 12, 4);
        Item or = new Armor("armure en or", 20, 8);
        Item diamant = new Armor("armure en diamant", 30, 12);
        
        ArrayList<Item> obj_list = new ArrayList<Item>();
        obj_list.add(bandage);
        obj_list.add(petiteH);
        obj_list.add(normaleH);
        obj_list.add(grosseH);
        obj_list.add(petiteS);
        obj_list.add(normaleS);
        obj_list.add(grosseS);
        obj_list.add(epee);
        obj_list.add(hache);
        obj_list.add(lance);
        obj_list.add(dague);
        obj_list.add(cuir);
        obj_list.add(fer);
        obj_list.add(or);
        obj_list.add(diamant);
        
        return obj_list;
    }

}