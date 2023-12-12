package Events;

import Entity.Avatar;

public class Escape implements Event {
    private final static int id = 4;                // L'identifiant de Escape.


/**
     * Méthode déclencheuse de l'Event Escape, implémentation de l'interface Event.
     * Elle propose au joueur de passer le reste de la Room ou non
     * @param player Avatar de l'utilisateur pour la partie en cours
     */
    @Override
    public void trigger(Avatar player) {
        System.out.println("Vous avez trouvé la sortie !");     // Affichage utilisateur
    }

    /**
     * Getter de l'id de Escape
     * @return L'id de cet évenement
     */
    @Override
    public int getId() {
        return Escape.id;
    }
    
}

