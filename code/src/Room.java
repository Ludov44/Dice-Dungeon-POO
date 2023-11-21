import Event;
import java.util.ArrayList;
import java.util.Random;
import java.util.random;


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
        if(this.events.size() == 1){
            
        }
        else{
            Random random_number = new Random();
            int eventNumber;
            eventNumber = (randomNumber.nextInt(this.events.size())) 
        }
    }

    public void quit(){


    }

})

