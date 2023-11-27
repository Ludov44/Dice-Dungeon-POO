package Account;

import Game.Game;

public class Account {
    private int tokens;
    private Stats statistics;
    private Game active_game;

    public Account() {
        // TODO
    }

    public void play(){
        this.active_game = new Game(null);
        this.active_game.enter_room();
        // TODO
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
