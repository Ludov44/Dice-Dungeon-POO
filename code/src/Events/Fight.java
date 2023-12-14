package Events;

import java.util.ArrayList;

import Entity.Avatar;
import Entity.Monster;
import Entity.MonsterGenerator;
import io.UserInput;

public class Fight implements Event {
    ArrayList<Monster> enemies;                 // Les ennemis de ce combat.
    private final static int id = 3;            // L'identifiant de Fight.

    /**
     * Constructeur de l'Event Fight
     * @param nbRoom le numéro de la room actuelle.
     */
    public Fight(int nbRoom)
    {
        this.enemies = new ArrayList<Monster>();
        this.fill(nbRoom);
    }

    /**
     * Remplit la liste d' ennemis de ce combat.
     * @param nbRoom Le numéro de la room, pour ajuster la difficulté du combat.
     */
    public void fill(int nbRoom)
    {
        int nbMonster;
        if (nbRoom <= 3)                                        // les 3 premières salles
        {
            nbMonster = 1;
        }
        else if(nbRoom <= 6)                                    // les 3 salles suivantes
        {
            nbMonster = 2;
            

        }
        else if(nbRoom <= 10)                                   // les 4 salles suivantes
        {
            nbMonster = 3;

        }
        else if(nbRoom <= 15)                                   // les 5 salles suivantes
        {
            nbMonster = 4;

        }
        else {                                                  // non utilisé pour le moment
            nbMonster = 5;
        }

        for (int i = 0; i < nbMonster; i++) {
            enemies.add(MonsterGenerator.generate(nbRoom));
            /*for(Monster m : enemies)
            {
                m.setMaxHP((int)(m.getMaxHP() + nbRoom*1.5));
                m.setHP(m.getMaxHP());
                m.setbaseAttack(m.getbaseAttack() + nbRoom);
                m.setDefense(m.getDefense() + (int)(nbRoom*0.8));
            }*/
        }
    }


    /**
     * Méthode déclencheuse de l'Event Fight, implémentation de l'interface Event.
     * Elle lance le combat jusqu'a la mort du joueur ou des ennemis.
     * @param player Avatar de l'utilisateur pour la partie en cours
     */
    @Override
    public void trigger(Avatar player) {
        Monster currentMonster;
        int playerRoll = 0;
        int monsterRoll = 0;
        boolean autoMode = false;

        System.out.println("Vous rencontrez des monstres ! ");
        for (Monster monster : this.enemies) {
            System.out.println(String.format("\t- %s", monster));
        }

        while(this.enemies.size() != 0 && player.is_alive()){
            System.out.println("Entrée en combat...");
            currentMonster = this.enemies.get(0);

            while(currentMonster.is_alive() && player.is_alive()){
                if (!autoMode) {
                    System.out.println(player);
                    System.out.println(currentMonster);
                    if (UserInput.getChoice("Appuyez sur une touche pour lancer le dé... (A pour combat automatique)", 'A')) {
                        autoMode = true;
                    }
                }
                
                do{
                    playerRoll = (int)(Math.random()*6 + 1);

                    monsterRoll = (int)(Math.random()*6 + 1);
                }while(playerRoll == monsterRoll);
                
                if (!autoMode) {
                    System.out.println(String.format("Vous avez fait %d au lancer de dé", playerRoll));
                    System.out.println(String.format("Le monstre a fait %d au lancer de dé", monsterRoll));
                }

                if(playerRoll < monsterRoll){
                    if (!autoMode) {System.out.println("Vous avez perdu le lancer de dé!");}

                    System.out.println(String.format("Vous subissez %d dégâts!", currentMonster.attack(player)));
                    if (!autoMode) {UserInput.getInput("...");}

                }else{
                    if (!autoMode) {System.out.println("Vous avez gagné le lancer de dé!");}

                    System.out.println(String.format("Vous infligez %d dégâts à [%s]!", player.attack(currentMonster), currentMonster.getName()));
                    if (!autoMode) {UserInput.getInput("...");}
                }

            }
            if(player.is_alive()){
                System.out.println(String.format("Vous avez tué [%s] : argent + %d", currentMonster.getName(), currentMonster.getReward()));
                player.getInv().setMoney(player.getInv().getMoney() + currentMonster.getReward()); // récupération de la récompense du monstre
                System.out.println(player);
                UserInput.getInput("...");
            }
            this.enemies.remove(0);
            

        }
    }


    /**
     * Getter de l'id de Fight
     * @return L'id de cet évenement
     */
    @Override
    public int getId() {
        return Fight.id;
    }

    
     
}
