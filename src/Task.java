public class Task {
    private final String taskDescription;
    private boolean completed = false;

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void markComplete() {
        completed = true;
    }

    public String toString() {
        return String.format("\"%s\", %s", taskDescription, completed ? "Completed" : "Active");
    }
}
