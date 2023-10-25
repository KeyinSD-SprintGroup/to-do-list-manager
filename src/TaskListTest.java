public class TaskListTest {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        for (int i = 0; i < 10; i++) {
            String taskName = String.format("Task_%s", i);
            Task newTask = new Task(taskName);
            taskList.append(newTask);
        }

        taskList.printAllTasks();
        taskList.markComplete(5);
        taskList.printAllTasks();


    }
}
