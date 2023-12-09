package Account;

import Game.Game;
import Entity.Avatar;
import Entity.Inventory;

public class Account {
    private int tokens;
    private Stats statistics;
    private Game active_game;

    public Account() {
        this.tokens = 0;
        this.statistics = new Stats();
        // création Game
        Inventory inv = new Inventory();
        Avatar player = new Avatar("anon", 20, 5, 5, inv); // garder les stats de base dans un autre fichier ?
        this.active_game = new Game(player);
    }

    public void play(){ // inutile ?
        this.active_game.play();
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
