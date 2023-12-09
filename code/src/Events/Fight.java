package Events;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.Avatar;
import Entity.Monster;
import Entity.MonsterList;

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
            ArrayList<Monster> monsters = MonsterList.allMonsters();
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
        Scanner clavier = new Scanner(System.in);
        int playerRoll = 0;
        int monsterRoll = 0;
        int montantDgts = 0;

        while(this.enemies.size() !=0 && player.is_alive()){
            currentMonster = this.enemies.get(0);

            while(currentMonster.is_alive() && player.is_alive()){

                do{
                    playerRoll = (int)(Math.random()*6 + 1);

                    monsterRoll = (int)(Math.random()*6 + 1);
                }while(playerRoll == monsterRoll);

                System.out.println("Vous avez fait " + playerRoll + " au lancer de dé");
                System.out.println("Le monstre a fait " + monsterRoll + " au lancer de dé");



                if(playerRoll < monsterRoll){
                    System.out.println("Vous avez perdu le lancer de dé!");
                    clavier.nextLine();

                    montantDgts = currentMonster.getAttackPower() - player.getDefense() + 1 ;
                    if(montantDgts < 1) montantDgts = 1;

                    player.setHP(player.getHP()-montantDgts);
                    System.out.println("Vous subissez " + montantDgts + " dégâts!");
                    clavier.nextLine();

                }else{
                    System.out.println("Vous avez gagné le lancer de dé!");
                    clavier.nextLine();

                    montantDgts = player.getAttackPower() - currentMonster.getDefense() + 1 ;
                    if(montantDgts < 1) montantDgts = 1;
                    
                    currentMonster.setHP(player.getHP()-montantDgts);
                    System.out.println("Vous infligez " + montantDgts + " dégâts!");
                    clavier.nextLine();
                }

            }
            if(player.is_alive()){
                System.out.println("Vous avez tué " + currentMonster.getType());

            }
            this.enemies.remove(0);
            

        }
        clavier.close();
    }



    @Override
    public int getId() {
        return Fight.id;
    }

    
     
}
