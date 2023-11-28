package Game;


import Entity.Avatar;
import Room.Room;
import Events.*;
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

    private void create_room(){
        this.room_nb += 1;
        double randomNumber = Math.random();
        int roomSize = 4 + (int)(randomNumber*2);
        ArrayList<Event> newEventList;

        Escape sortie = new Escape();
        newEventList.add(sortie); // ajoute la sortie au pull d'event
        
        // ajoute entre 3 et 4 Event au pull d'event avec 60% de chance de tirer un combat, 20% d'avoir un chest et 20% de chance pour un marchand
        for(int i = 1; i < roomSize ; i++){ 
            randomNumber = Math.random();
            int randomEventId = (int)(randomNumber*5+1); 
            switch (randomEventId) {
                case 1:
                    Chest newChest = new Chest();
                    newEventList.add(newChest);
                    break;
                case 2:
                    Merchant newMerchant = new Merchant();
                    newEventList.add(newMerchant);
                break;
                case 3,4,5:
                    Fight newFight = new Fight();
                    newEventList.add(newFight);
                break;
            }
        }
        this.active_room = new Room(false, newEventList); 
    
    }

    public void enter_room(){
        this.create_room();
        this.active_room.explore(this.player);
        // TODO
        this.active_room.quit(this.player);
    }

    public int getRoom_nb() {
        return room_nb;
    }

    public void setRoom_nb(int room_nb) {
        this.room_nb = room_nb;
    }
}
