package Events;

import java.util.ArrayList;

import Entity.Avatar;
import Entity.Monster;

public class Fight implements Event {
    ArrayList<Monster> enemies;

    @Override
    public void trigger(Avatar player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'trigger'");
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
     
}
