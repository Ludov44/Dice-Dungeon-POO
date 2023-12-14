package Game;


import Entity.Avatar;
import Room.Room;
import io.UserInput;
import Events.*;
import Exception.PlayerDead;

import java.util.ArrayList;
import java.lang.Math;


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
     * Création d'une room en remplissant une liste d'event aléatoirement.
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
        if (this.getRoom_nb() == 1) {
            System.out.println(String.format("===> ROOM %d", this.getRoom_nb()));
        }
        else{
            System.out.println(String.format("ROOM %d ===> ROOM %d", this.getRoom_nb() - 1, this.getRoom_nb()));
        }
        UserInput.getInput("...");
        
        boolean inProgress = true;
        while(inProgress){
            System.out.println(String.format("Il reste %d évenements dans la salle (room %d)", this.active_room.eventsRemaining(), this.getRoom_nb()));
            inProgress = this.active_room.explore(this.player);

            if(this.active_room.getEscape() && inProgress && this.active_room.eventsRemaining() > 0){
                // Vérifie que l'utilisateur souhaite quitter la room
                if (UserInput.getChoice("Voulez-vous sortir de la salle ou continuer à explorer (S/E) ? ", 'S')) {
                    inProgress = false;
                }
                else{
                    System.out.println("Vous continuez d'explorer l'étage");
                }
            }

        }

        player.endConsumableEffects();
    }

    /**
     * Lance une game, qui se termine soit quand 15 rooms sont traversées, soit quand le joueur meurt
     * @return nombre de rooms traversées, qui sera ajouté en tokens dans la classe Account
     */
    public int play(){
        try {
            while(this.getRoom_nb() < 15){
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
