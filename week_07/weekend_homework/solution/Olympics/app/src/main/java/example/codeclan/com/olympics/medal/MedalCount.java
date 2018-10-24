package example.codeclan.com.olympics.medal;

import example.codeclan.com.olympics.medal.Medal;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class MedalCount {
    private int goldCount;
    private int silverCount;
    private int bronzeCount;

    public MedalCount(){
        this.goldCount = 0;
        this.silverCount = 0;
        this.bronzeCount = 0;

    }

    public void incrementCount(Medal medal) {
        switch (medal) {
            case GOLD:
                this.goldCount++;
                break;
            case SILVER:
                this.silverCount++;
                break;
            case BRONZE:
                this.bronzeCount++;
                break;
        }
    }

    public int getGoldCount() {
        return goldCount;
    }

    public int getSilverCount() {
        return silverCount;
    }

    public int getBronzeCount() {
        return bronzeCount;
    }
}
