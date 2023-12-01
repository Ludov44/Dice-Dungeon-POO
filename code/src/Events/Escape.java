package Events;

import Entity.Avatar;

public class Escape implements Event {
    private final static int id = 4;



    @Override
    public void trigger(Avatar player) {
        System.out.println("Vous avez trouvé la sortie !");                                          // Affichage utilisateur
    }

    @Override
    public int getId() {
        return Escape.id;
    }
    
}

