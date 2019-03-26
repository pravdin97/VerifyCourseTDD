import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Task> tasks;
    private int indexOfNextTask;

    public Game() {
        tasks = new ArrayList<Task>();
        indexOfNextTask = 0;
        try {
            fillTasks();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

    public boolean checkAnswers(ArrayList<Integer> answers) {
        ArrayList<Integer> realAnswers = tasks.get(indexOfNextTask - 1).getErrorLineIndexes();
        int countGoodAnswers = 0;
        for (Integer ans: answers) {
            if (!realAnswers.contains(ans))
                return false;
            countGoodAnswers++;
        }
        if (countGoodAnswers != realAnswers.size())
            return false;
        return true;
    }

    public boolean fillTasks() throws FileNotFoundException {
        FileReader fr = new FileReader(this.getClass().getResource("/tasks.txt").getFile());
        Scanner scanner = new Scanner(fr);

        int maxNumber = scanner.nextInt();
        if (maxNumber == 0) return false;

        for (int i = 1; i <= maxNumber; i++)
        {
            FileReader tsk = new FileReader(this.getClass().getResource("/task/" + i).getFile());
            scanner = new Scanner(tsk);
            ArrayList<String> text = new ArrayList<String>();
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                text.add(line);
            }
            Task task = new Task(text.toArray(new String[0]));

            FileReader ans = new FileReader(this.getClass().getResource("/answer/" + i).getFile());
            scanner = new Scanner(ans);
            ArrayList<Integer> errorLines = new ArrayList<Integer>();
            while (scanner.hasNextInt()) {
                Integer index = scanner.nextInt();
                errorLines.add(index);
            }
            task.setErrorLineIndexes(errorLines);
            this.setTask(task);
        }
        return true;
    }

    public void clearTasks() {
        tasks = new ArrayList<Task>();
    }
}
