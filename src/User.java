public class User {
    private final String userName;
    private final TaskList taskList;

    public User(String userName) {
        this.userName = userName;
        this.taskList = new TaskList();
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
}
