public class Game {
    public Game() {
    }

    public Task getNextTask() {
        return new Task();
    }

    public boolean hasNextTask() {
        return true;
    }
}
