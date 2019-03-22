import java.util.ArrayList;

public class Game {
    private ArrayList<Task> tasks;
    private int indexOfNextTask;

    public Game() {
        tasks = new ArrayList<Task>();
        indexOfNextTask = 0;
    }

    public Task getNextTask() {
        if (hasNextTask()) {
            return tasks.get(indexOfNextTask++);
        }
        return null;
    }

    public boolean hasNextTask() {
        if (indexOfNextTask < tasks.size() && tasks.get(indexOfNextTask) != null)
            return true;
        return false;
    }

    public void setTask(Task setTask) {
        tasks.add(setTask);
    }
}
