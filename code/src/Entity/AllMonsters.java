package Entity;

import java.util.ArrayList;                     // Permet l'utilisation des listes



public class AllMonsters {
    public static ArrayList<Monster> allMonsters = new ArrayList<Monster>();
    
    public AllMonsters()
    {
        double randomNumber;
        Monster newMonster;
        
        for(int i = 1; i < 20 ; i++){ 
            randomNumber = Math.random();
            int randomMonsterId = (int)(randomNumber*3+1); 
            switch (randomMonsterId) {
                case 1:
                    newMonster = new Monster(10 + (int)(randomNumber*15), 1 + (int)(randomNumber*8),(int)(randomNumber*2), "Squelette", (int)(randomNumber*3));
                    break;
                case 2:
                    newMonster = new Monster(10 + (int)(randomNumber*30), 1 + (int)(randomNumber*4),(int)(randomNumber*5), "Zombie", (int)(randomNumber*3));
                break;
                default:                // Le cas 3.
                    newMonster = new Monster(10 + (int)(randomNumber*20), 1 + (int)(randomNumber*6),(int)(randomNumber*3), "Araignée", (int)(randomNumber*3));
            }
            this.allMonsters.add(newMonster);
    }
}
}
