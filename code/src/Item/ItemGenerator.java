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

    public static ArrayList<Item> generateObjects(){
        Item bandage = new HealthConsumable("Bandage", 5, 1);
        Item petiteH = new HealthConsumable("Petite potion de soin", 10, 2);
        Item normaleH = new HealthConsumable("Potion de soin", 15, 5);
        Item grosseH = new HealthConsumable("Grosse potion de soin", 20, 10);

        Item petiteS = new StrenghtConsumable("Petite potion de force", 5, 5);
        Item normaleS = new StrenghtConsumable("Potion de force", 10, 10);
        Item grosseS = new StrenghtConsumable("Grosse potion de force", 15, 15);
        
        Item epee = new Weapon("épée", 10, 10);
        Item hache = new Weapon("hache", 20, 15);
        Item dague = new Weapon("dague", 5, 5);
        Item lance = new Weapon("lance", 15, 12);

        Item cuir = new Armor("armure en cuir", 5, 4);
        Item fer = new Armor("armure en fer", 10, 6);
        Item or = new Armor("armure en or", 15, 8);
        Item diamant = new Armor("armure en diamant", 20, 12);
        
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