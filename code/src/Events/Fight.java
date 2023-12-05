package Events;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.Avatar;
import Entity.Monster;
import Item.Item;

public class Fight implements Event {
    ArrayList<Monster> enemies;
    private final static int id = 3;

    public Fight(int nbRoom)
    {
        this.enemies = new ArrayList<Monster>();
        this.fill(nbRoom);
    }

    public void fill(int nbRoom)
    {
        //Variables
            ArrayList<Monster> monsters = Monster.allMonsters;
            double dice = Math.random();                             // Variables contenant un réel généré aléatoirement entre 0 et 1
            int ind = (int)(dice*monsters.size());                   // Choisit aléatoirement un premier monstre 

        //Début

            if (nbRoom <= 3)                                         // les 3 premières salles
            {
                enemies.add(monsters.get(ind));                      // Attribue le monstre, tiré aléatoirement au début de la méthode, à cette salle
            }
            else if(nbRoom <= 6)                                     // les 3 salles suivantes
                {
                enemies.add(monsters.get(ind));                      // Attribue le monstre, tiré aléatoirement au début de la méthode, à cette salle
                dice = Math.random();                              
                ind = (int)(dice*monsters.size());                   // sélectionne un nouveau monstre
                enemies.add(monsters.get(ind));                      // Attribue le monstre tiré aléatoirement à la ligne précédente, à cette salle
            }
            else if(nbRoom <= 10)                                   // les 4 salles suivantes
            {
                enemies.add(monsters.get(ind));                      // Attribue le monstre, tiré aléatoirement au début de la méthode, à cette salle

                dice = Math.random();
                ind = (int)(dice*monsters.size());                   // sélectionne un deuxième monstre
                enemies.add(monsters.get(ind));                      // Attribue le deuxième monstre à cette salle

                dice = Math.random();
                ind = (int)(dice*monsters.size());                   // sélectionne un troisième monstre
                enemies.add(monsters.get(ind));                      // Attribue le troisième monstre à cette salle
            }
            else if(nbRoom <= 15)                                    // les 5 salles suivantes
            {
                enemies.add(monsters.get(ind));                      // Attribue le monstre, tiré aléatoirement au début de la méthode, à cette salle

                dice = Math.random();
                ind = (int)(dice*monsters.size());                   // sélectionne un deuxième monstre
                enemies.add(monsters.get(ind));                      // Attribue le deuxième monstre à cette salle

                dice = Math.random();
                ind = (int)(dice*monsters.size());                   // sélectionne un troisième monstre
                enemies.add(monsters.get(ind));                      // Attribue le troisième monstre à cette salle

                dice = Math.random();
                ind = (int)(dice*monsters.size());                   // sélectionne un quatrième monstre
                enemies.add(monsters.get(ind));                      // Attribue le quatrième monstre à cette salle
            }
        //Fin
    }


    @Override
    public void trigger(Avatar player) {
        Monster currentMonster;

        int playerRoll = 0;
        int monsterRoll = 0;
        

        while(this.enemies.size() !=0 && player.getHP() > 0){
            currentMonster = this.enemies.get(0);

            while(currentMonster.getHP() > 0 && player.getHP() > 0){
                currentMonster = this.enemies.get(0);

                do{
                    playerRoll = (int)(Math.random()*6 + 1);
                    monsterRoll = (int)(Math.random()*6 + 1);
                }while(playerRoll == monsterRoll);
                
                if(playerRoll<monsterRoll){
                    player.setHP(currentMonster.getAttackPower());
                    System.out.println("Vous subissez " + currentMonster.getAttackPower() + " dégâts");

                }else{
                    currentMonster.setHP(player.getAttackPower());
                }

            }
            this.enemies.remove(0);
            

        }

    }



    @Override
    public int getId() {
        return Fight.id;
    }


     
}
