package example.codeclan.com.olympics;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class ContenderEntry implements Comparable<ContenderEntry> {
    private int score;
    private Contender contender;

    public ContenderEntry(int score, Contender contender) {
        this.score = score;
        this.contender = contender;
    }

    public int getScore() {
        return score;
    }

    public Contender getContender() {
        return contender;
    }

    public int compareTo(ContenderEntry comparingTo){
        return this.score - comparingTo.getScore();
    }
}
