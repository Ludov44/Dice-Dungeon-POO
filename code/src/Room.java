import Event;
import java.util.ArrayList;
import java.util.Random;



public class Room{
    private boolean escape_found;
    private ArrayList<Event> events;

    public Room(boolean escape, ArrayList<Event> events_list){
        this.escape_found = escape;
        this.events = events_list;
    }


    public boolean getEscape(){
        return this.escape_found;
    }

    public ArrayList<Event> getEvents(){
        return this.events;
    }

    public void setEscape(boolean escape){
        this.escape_found = escape;
    }

    public void setEvents(ArrayList<Event> events_list){
        this.events = events_list;
    }

    public void explore(Avatar player){
        if(this.events.size() == 1){ //Si il ne reste qu'un élément, alors il s'agit de la sortie de la room
            
        }
        else{ //Sinon on tire un élément au hasard dans la room
            Random randomNumber = new Random();
            int eventNumber;
            if(this.escape_found){ //Si la sortie a été trouvé, on on ne regarde pas le dernier Event de la liste car c'est forcément la sortie
                eventNumber = (randomNumber.nextInt(this.events.size()-1));
                this.events.get(eventNumber).trigger(player);
            }else{
                eventNumber = (randomNumber.nextInt(this.events.size()));
                this.events.get(eventNumber).trigger(player);
            }

            if(this.events.get(eventNumber).getId() == 3){ //Si on a trouvé la sortie, on la déplace à la fin de la liste
                this.events.add(this.events.get(eventNumber));
                this.events.remove(eventNumber);
                
            }
        }
    }

    public void quit(Avatar player){
        if(this.escape_found){
            int positionEvent = 0;
            while(this.events.get(positionEvent).getId != 3 ){
                positionEvent++;
            }
            this.events.get(positionEvent).trigger(player);
        }else{
            System.out.println("Vous n'avez pas encore trouvé la sortie!");
        }


    }

}

