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
        if (nbRoom <= 3)                                         // les 3 premières salles
        {
            enemies.add(MonsterList.generateMonster());                      // Attribue le monstre, tiré aléatoirement au début de la méthode, à cette salle
        }
        else if(nbRoom <= 6)                                     // les 3 salles suivantes
            {
            enemies.add(MonsterList.generateMonster());                      // Attribue le monstre, tiré aléatoirement au début de la méthode, à cette salle
            enemies.add(MonsterList.generateMonster());                      // Attribue le monstre tiré aléatoirement à la ligne précédente, à cette salle
        }
        else if(nbRoom <= 10)                                   // les 4 salles suivantes
        {
            enemies.add(MonsterList.generateMonster());                      // Attribue le monstre, tiré aléatoirement au début de la méthode, à cette salle
            enemies.add(MonsterList.generateMonster());                      // Attribue le deuxième monstre à cette salle
            enemies.add(MonsterList.generateMonster());                      // Attribue le troisième monstre à cette salle
        }
        else if(nbRoom <= 15)                                    // les 5 salles suivantes
        {
            enemies.add(MonsterList.generateMonster());                      // Attribue le monstre, tiré aléatoirement au début de la méthode, à cette salle
            enemies.add(MonsterList.generateMonster());                      // Attribue le deuxième monstre à cette salle
            enemies.add(MonsterList.generateMonster());                      // Attribue le troisième monstre à cette salle                              
            enemies.add(MonsterList.generateMonster());                      // Attribue le quatrième monstre à cette salle
        }
    }


    @Override
    public void trigger(Avatar player) {
        Monster currentMonster;
        Scanner clavier = new Scanner(System.in);
        int playerRoll = 0;
        int monsterRoll = 0;
        int montantDgts = 0;

        System.out.println("Vous rencontrez des monstres ! ");
        for (Monster monster : this.enemies) {
            System.out.println(String.format("\t- %s", monster));
        }

        while(this.enemies.size() != 0 && player.is_alive()){
            System.out.println("Entrée en combat...");
            currentMonster = this.enemies.get(0);

            while(currentMonster.is_alive() && player.is_alive()){
                System.out.println(player);
                System.out.println(currentMonster);
                System.out.println("Appuyez sur une touche pour lancer le dé...");
                clavier.nextLine();
                do{
                    playerRoll = (int)(Math.random()*6 + 1);

                    monsterRoll = (int)(Math.random()*6 + 1);
                }while(playerRoll == monsterRoll);

                System.out.println(String.format("Vous avez fait %d au lancer de dé", playerRoll));
                System.out.println(String.format("Le monstre a fait %d au lancer de dé", monsterRoll));

                if(playerRoll < monsterRoll){
                    System.out.println("Vous avez perdu le lancer de dé!");
                    clavier.nextLine();

                    montantDgts = currentMonster.getAttackPower() - player.getDefense() + 1 ;
                    if(montantDgts < 1) montantDgts = 1;

                    player.setHP(player.getHP()-montantDgts);
                    System.out.println(String.format("Vous subissez %d dégâts!", montantDgts));
                    clavier.nextLine();

                }else{
                    System.out.println("Vous avez gagné le lancer de dé!");
                    clavier.nextLine();

                    montantDgts = player.getAttackPower() - currentMonster.getDefense() + 1 ;
                    if(montantDgts < 1) montantDgts = 1;
                    
                    currentMonster.setHP(currentMonster.getHP()-montantDgts);
                    System.out.println(String.format("Vous infligez %d dégâts à [%s]!", montantDgts, currentMonster.getName()));
                    clavier.nextLine();
                }

            }
            if(player.is_alive()){
                System.out.println(String.format("Vous avez tué [%s]", currentMonster.getName()));

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
