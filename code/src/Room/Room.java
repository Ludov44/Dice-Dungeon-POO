package Room;
import Events.Event;
import Exception.PlayerDead;

import java.util.ArrayList;

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
        if(this.eventsRemaining() == 0){ //Si il ne reste qu'un élément, alors il s'agit de la sortie de la room
            if(!this.escape_found){
                this.events.get(0).trigger(player);
                System.out.println("La salle est vide, pour prenez la sortie...");
                this.escape_found = true;
            }
            return false;
        }
        else{ //Sinon on tire un élément au hasard dans la room
            int eventNumber = (int)(Math.random()*this.eventsRemaining());

            if(this.events.get(eventNumber).getId() == 4){ //Si on a trouvé la sortie, on la déplace à la fin de la liste et on change l'attribut escape_found
                this.escape_found = true;
                this.events.add(this.events.get(eventNumber));
            }

            this.events.get(eventNumber).trigger(player);
            this.events.remove(eventNumber);
            
            if(player.is_dead()){ // Si le joueur est mort, quitte la room
                throw new PlayerDead("player is dead");
            }

            return true;
        }
    }
    /**
     * Retourne le nombre d'événement dans la liste et si la sortie a été trouvée, ne la compte pas dedans
     * @return Le nombre d'event restant
     */
    public int eventsRemaining(){
        if (escape_found) {
            return this.events.size() - 1;
        }
        else {
            return this.events.size();
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

