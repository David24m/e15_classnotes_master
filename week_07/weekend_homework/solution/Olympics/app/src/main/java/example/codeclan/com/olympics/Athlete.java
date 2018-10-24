package example.codeclan.com.olympics;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class Athlete implements Contender {
    private String name;
    private Country country;

    public Athlete(String name, Country country){
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
