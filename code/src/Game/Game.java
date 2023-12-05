package Game;


import Entity.Avatar;
import Room.Room;
import Events.*;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;  


public class Game {
    private int room_nb;
    private Room active_room;
    private Avatar player;

    /**
     * @param player
     */
    public Game(Avatar player) {
        this.player = player;
        this.room_nb = 0;
    }
    /*
     * Créer une room en remplissant une liste d'event aléatoirement
     * Chaque room possède une sortie et possiblement des combats, des chests et des marchands
     */
    private void create_room(){
        this.room_nb += 1;
        double randomNumber = Math.random();
        int roomSize = 4 + (int)(randomNumber*2);
        ArrayList<Event> newEventList = new ArrayList<Event>();
        Event newEvent;
        Escape sortie = new Escape();
        newEventList.add(sortie); // ajoute la sortie au pull d'event
        
        // ajoute entre 3 et 4 Event au pull d'event avec 60% de chance de tirer un combat, 20% d'avoir un chest et 20% de chance pour un marchand
        for(int i = 1; i < roomSize ; i++){ 
            randomNumber = Math.random();
            int randomEventId = (int)(randomNumber*5+1); 
            switch (randomEventId) {
                case 1:
                    newEvent = new Chest();
                    break;
                case 2:
                    newEvent = new Merchant();
                break;
                case 3,4,5:
                    newEvent = new Fight(this.room_nb);
                break;
                default:
                    newEvent = new Fight(this.room_nb);
            }
            newEventList.add(newEvent);

        }
        this.active_room = new Room(false, newEventList); 
    
    }
    /*
     * Procédure pour gérer l'exploration d'une room
     * Créé une nouvelle room et explore jusqu'à trouver la sortie
     */
    public void enter_room(){
        this.create_room();
        System.out.println("Vous voici dans une nouvelle salle");
        boolean inProgress = true;
        while(inProgress){

            inProgress = this.active_room.explore(this.player);

            if(this.active_room.getEscape() && inProgress){
                System.out.println("Voulez-vous sortir de la salle ou continuer à explorer");
                Scanner clavier = new Scanner(System.in);
                String choix = "";
        
                // Vérifie que l'utilisateur souhaite quitter la room
                while (choix!="O" || choix != "o"|| choix != "N" || choix != "n") {
                    System.out.println("Taper O si vous voulez passer à l'étage suivant, Tapez N sinon");
                    choix = clavier.nextLine();    
                }
                if(choix == "o" || choix == "O" ) {
                    inProgress = false;
                }
                else 
                {
                   System.out.println("Vous continuez d'explorer l'étage");
                }
                clavier.close();
            }

        }
    }

    void play(){
        while(this.room_nb <15 || this.player.getHP() <= 0){
            enter_room();
        }
        //Possiblement rajouter un combat de boss ici
        System.out.println("Félicitations! Vous êtes sortis du donjon");
    }

    public int getRoom_nb() {
        return room_nb;
    }
    public void setRoom_nb(int room_nb) {
        this.room_nb = room_nb;
    }
}
