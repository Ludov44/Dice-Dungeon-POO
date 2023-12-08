package Room;
import Events.Event;
import Exception.PlayerDead;

import java.util.ArrayList;
import java.util.Random;

import Entity.Avatar;



public class Room{
    private boolean escape_found;
    private ArrayList<Event> events;

    public Room(boolean escape, ArrayList<Event> events_list){
        this.escape_found = escape;
        this.events = events_list;
    }

    /**
    * Getter de l'attribut escape_found
    * @return La valeur de la sortie avec un boolean
    */
    public boolean getEscape(){
        return this.escape_found;
    }
     /**
    * Getter de l'attribut events
    * @return la liste d'event
    */
    public ArrayList<Event> getEvents(){
        return this.events;
    }
   /**
    * Setter de l'attribut escape
    * @param escape vrai si l'escape a été trouvée, faux sinon
    */
    public void setEscape(boolean escape){
        this.escape_found = escape;
    }
    /**
    * Setter de l'attribut events
    * @param events_list une liste d'event non vide
    */
    public void setEvents(ArrayList<Event> events_list){
        this.events = events_list;
    }

    /**
     * Prends un événement de la liste et le déclenche
     * Renvoie true si un event a été déclenché et false si il ne reste que la sortie
     */
    public boolean explore(Avatar player) throws PlayerDead{
        if(this.events.size() == 1){ //Si il ne reste qu'un élément, alors il s'agit de la sortie de la room
            if(!this.escape_found){
                this.events.get(1).trigger(player);
                this.escape_found = true;
            }
            return false;
        }
        else{ //Sinon on tire un élément au hasard dans la room
            Random randomNumber = new Random();
            int eventNumber;

            if(this.escape_found){ //Si la sortie a été trouvé, on ne regarde pas le dernier Event de la liste car c'est forcément la sortie
                eventNumber = (randomNumber.nextInt(this.events.size()-1));
            }else{
                eventNumber = (randomNumber.nextInt(this.events.size()));
            }

            if(this.events.get(eventNumber).getId() == 4){ //Si on a trouvé la sortie, on la déplace à la fin de la liste et on change l'attribut escape_found

                this.escape_found = true;
                this.events.add(this.events.get(eventNumber));
                this.events.remove(eventNumber);
                eventNumber = this.events.size();
                
            }
            this.events.get(eventNumber).trigger(player);
            
            if(player.is_dead()){ // Si le joueur est mort, quitte la room
                return false;
            }


            return true;
        }
    }
    /*
    public void quit(Avatar player){
        if(this.escape_found){
            this.events.get(this.events.size()).trigger(player);
        }else{
            System.out.println("Vous n'avez pas encore trouvé la sortie!");
        }
    }
     */

}

