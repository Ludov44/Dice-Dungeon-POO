package Game;


import Entity.Avatar;
import Room.Room;
import Events.*;
import Exception.PlayerDead;

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
    /**
     * Créer une room en remplissant une liste d'event aléatoirement.
     * Chaque room possède une sortie et possiblement des combats, des chests et des marchands
     */
    private void create_room(){
        this.room_nb += 1;
        double randomNumber = Math.random();
        int roomSize = 3 + (int)(randomNumber*2);
        ArrayList<Event> newEventList = new ArrayList<Event>();
        Event newEvent;
        Escape sortie = new Escape();
        newEventList.add(sortie); // ajoute la sortie au pull d'event
        
        // ajoute entre 3 et 4 Event au pull d'event avec 60% de chance de tirer un combat, 20% d'avoir un chest et 20% de chance pour un marchand
        for(int i = 0; i < roomSize ; i++){ 
            randomNumber = Math.random();
            int randomEventId = (int)(randomNumber*5+1); 
            switch (randomEventId) {
                case 1:
                    newEvent = new Chest();
                    break;
                case 2:
                    newEvent = new Merchant();
                    break;
                default:                                    // les cas 3, 4, 5 tombe dans le default.
                    newEvent = new Fight(this.room_nb);
            }
            newEventList.add(newEvent);

        }
        this.active_room = new Room(false, newEventList); 
    
    }
    /**
     * Procédure pour gérer l'exploration d'une room.
     * Créé une nouvelle room et explore jusqu'à trouver la sortie, ou mourir (exception PLayerDead levée dans ce cas)
     */
    public void enter_room() throws PlayerDead{
        this.create_room();
        System.out.println(String.format("Vous entrez dans une nouvelle salle (room %d)...", this.getRoom_nb()));
        boolean inProgress = true;
        while(inProgress){
            System.out.println(String.format("il reste %d évenements dans la salle", this.active_room.eventsRemaining()));
            inProgress = this.active_room.explore(this.player);

            if(this.active_room.getEscape() && inProgress){
                System.out.println("Voulez-vous sortir de la salle ou continuer à explorer ? ");
                Scanner clavier = new Scanner(System.in);
                String choix = "";
        
                // Vérifie que l'utilisateur souhaite quitter la room
                while (choix!="O" || choix != "o"|| choix != "N" || choix != "n") {
                    System.out.println("Taper O si vous voulez passer à l'étage suivant, Tapez N sinon : ");
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

    /**
     * Lance une game, qui se termine soit quand 15 rooms sont traversées, soit quand le joueur meurt
     * @return nombre de rooms traversées, qui sera ajouté en tokens dans la classe Account
     */
    public int play(){
        try {
            while(this.getRoom_nb() < 15 && this.player.is_alive()){
                enter_room();
            }
            System.out.println("Félicitations! Vous êtes sortis du donjon");
            //Possiblement rajouter un combat de boss ici
        } catch (PlayerDead e) {
            System.out.println("Vous êtes mort...");
        }
        
        return this.getRoom_nb();
    }

    public int getRoom_nb() {
        return room_nb;
    }
    public void setRoom_nb(int room_nb) {
        this.room_nb = room_nb;
    }
}
