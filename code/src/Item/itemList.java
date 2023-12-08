public Class itemList{
    ArrayList<String> allObjects;

    public static void allObjects(){
    HealthConsumable bandage = new HealthConsumable("Bandage", 5, 1);
    HealthConsumable petiteH = new HealthConsumable("Petite potion de soin", 10, 2);
    HealthConsumable normaleH = new HealthConsumable("Potion de soin", 15, 5);
    HealthConsumable grosseH = new HealthConsumable("Grosse potion de soin", 20, 10);

    StrenghtConsumable petiteS = new StrenghtConsumable("Petite potion de force", 0.2, 5);
    StrenghtConsumable normaleS = new StrenghtConsumable("Potion de force", 0.4, 10);
    StrenghtConsumable grosseS = new StrenghtConsumable("Grosse de force", 0.6, 15);
    
    Weapon epee = new Weapon("épée", 10, 10);
    Weapon hache = new Weapon("hache", 20, 15);
    Weapon dague = new Weapon("dague", 5, 5);
    Weapon lance = new Weapon("lance", 15, 12);

    Armor cuir = new Armor("armure en cuir", 5, 4);
    Armor fer = new Armor("armure en fer", 10, 6);
    Armor or = new Armor("armure en or", 15, 8);
    Armor diamant = new Armor("armure en diamant", 20, 12);
        ArrayList<String> allObjects = new ArrayList<String>()
        allObjects.add(bandage);
        allObjects.add(petiteH);
        allObjects.add(normaleH);
        allObjects.add(grosseH);
        allObjects.add(petiteS);
        allObjects.add(normaleS);
        allObjects.add(grosseS);
        allObjects.add(epee);
        allObjects.add(hache);
        allObjects.add(lance);
        allObjects.add(dague);
        allObjects.add(cuir);
        allObjects.add(fer);
        allObjects.add(or);
        allObjects.add(diamant);
    }
}