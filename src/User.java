public class User {
    private final String userName;
    private final TaskList taskList;

    public User(String userName) {
        this.userName = userName;
        this.taskList = new TaskList();
    }

    public String getUserName() {
        return userName;
    }

    public void addTask(Task newTask) {
        taskList.append(newTask);
    }

    public void markTaskComplete(int location) {
        taskList.markComplete(location);
    }

    public void printAllTasks() {
        System.out.println(userName + " :");
        taskList.printAllTasks();
    }

    @Override
    public String toString() {
        return userName;
    }
}
