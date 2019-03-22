public class Task {
    private String[] text;

    public Task() {
        text = new String[]{""};
    }

    public Task(String[] text) {
        this.text = text;
    }
    public String[] getText() {
        return text;
    }
}
