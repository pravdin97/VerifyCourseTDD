import org.junit.Assert;
import org.junit.Test;

public class FindErrorGameTest {
    @Test
    void gameCreationTest() {
        Game game = new Game();
        Assert.assertNotNull(game);
    }
}
