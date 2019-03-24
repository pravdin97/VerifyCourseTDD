import java.util.ArrayList;

public class Task {
    private String[] text;
    private ArrayList<Integer> errorLineIndexes;

    public Task() {
        text = new String[]{""};
        errorLineIndexes = new ArrayList<Integer>();
    }

    public Task(String[] text) {
        this.text = text;
        errorLineIndexes = new ArrayList<Integer>();
    }
    public String[] getText() {
        return text;
    }

    public void setErrorLineIndexes(ArrayList<Integer> errorLineIndexes) {
        this.errorLineIndexes = errorLineIndexes;
    }

    public ArrayList<Integer> getErrorLineIndexes() {
        return errorLineIndexes;
    }
}
