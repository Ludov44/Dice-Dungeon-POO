package Account;

import Game.Game;
import Entity.Avatar;
import Entity.Inventory;
import io.UserInput;


public class Account {
    private int tokens;
    private Stats statistics;
    private Avatar player;

    public Account() {
        this.tokens = 0;
        this.statistics = new Stats();
        this.player = createAvatar();
    }

    /**
     * Création de l'avatar du joueur pour la partie, avec nom choisi, et amélioré selon le nombre de tokens récupéré lors de précédentes parties (+1 aux stats pour 10 tokens)
     * @return Avatar du joueur
     */
    private Avatar createAvatar(){
        
        String name = UserInput.getInput("Nom du joueur ?");
        Inventory inv = new Inventory();
        int tokenUpgrade = getTokens() / 10;
        Avatar player = new Avatar(name, 25 + tokenUpgrade, 4 + tokenUpgrade, 4 + tokenUpgrade, inv);
        System.out.println(player);
        return player;
    }

    public void play(){
        Game activeGame;        
        while (UserInput.getChoice("Lancer une nouvelle partie (O/N) ?", 'O')) {
            activeGame = new Game(player); 
            System.out.println("Lancement d'un nouveau donjon...");
            this.tokens += activeGame.play(); // lancement Game
            System.out.println(String.format("Solde en tokens : %d", this.getTokens()));
            this.player = this.createAvatar(); // reset du joueur
        }
        System.out.println("Arrêt du jeu...");
    }

    public Stats getStatistics() {
        return statistics;
    }

    public void setStatistics(Stats statistics) {
        this.statistics = statistics;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
