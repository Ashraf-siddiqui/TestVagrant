package tests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Payload;

public class CricketMatchTest {

    public static JsonPath js = new JsonPath(Payload.GetTeamInfo());

    public static int totalPlayers = js.getInt("player.size()");

    @Test
    public void ValidateForeignTeamMembers() {

        int foriegnPlayersCount = 0;
        for (int i = 0; i < totalPlayers; i++) {
            if (!js.getString("player[" + i + "].country").equalsIgnoreCase("India")) {
                foriegnPlayersCount++;
            }
        }
        Assert.assertEquals(foriegnPlayersCount, 4, "count of foreign players is not 4. ");
    }


    @Test
    public void ValidateWicketkeeper() {
        int wicketKeeperCount = 0;
        for (int i = 0; i < totalPlayers; i++) {
            if (js.getString("player[" + i + "].role").trim().equalsIgnoreCase("Wicket-keeper")) {
                wicketKeeperCount++;

            }
        }
        System.out.println("total count for wicket-keeper " + wicketKeeperCount);
        Assert.assertTrue(wicketKeeperCount <= 1);
    }


}
