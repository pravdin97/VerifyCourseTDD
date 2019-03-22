import org.junit.Assert;
import org.junit.Test;

public class FindErrorGameTest {
    @Test
    public void gameCreationTest() {
        Game game = new Game();
        Assert.assertNotNull(game);
    }

    @Test
    public void getNextTaskTest() {
        Game game = new Game();
        Assert.assertNotNull(game.getNextTask());
    }

    @Test
    public void TaskGetTextTest() {
        Game game = new Game();
        String [] text = game.getNextTask().getText();
        Assert.assertNotNull(text);
    }

    @Test
    public void HasNextTaskTest() {
        Game game = new Game();
        boolean answer;
        answer = game.hasNextTask();
        Assert.assertNotNull(answer);
    }

    @Test
    public void SetTaskTest() {
        Game game = new Game();
        Task setTask = new Task(new String[] {"int main() {}"});
        game.setTask(setTask);
        Task getTask = game.getNextTask();
        Assert.assertEquals(setTask, getTask);
    }
}
