package Account;

public class Stats {
    private int score;

    /**
     * Constructeur de Stats
     */
    public Stats(){
        this.score = 0;
    }

    /**
     * 2 ème Constructeur de Stats
     * @param score le score voulu
     */
    public Stats(int score){
        this.score = score;
    }

    /**
     * Getter de score
     * @return un entier représentat le score
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter de Score
     * @param score un entier représentat le score
     */
    public void setScore(int score) {
        this.score = score;
    }
}
