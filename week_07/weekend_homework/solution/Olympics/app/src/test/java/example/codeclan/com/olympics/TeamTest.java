package example.codeclan.com.olympics;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jaychetty on 18/09/2017.
 */

public class TeamTest {

    @Test
    public void country_is_that_of_first_team_member(){
        Team team = new Team();
        Athlete athlete = new Athlete("Usain", Country.JAMAICA);
        team.addMember(athlete);

        assertEquals(Country.JAMAICA, team.getCountry());
    }

}
