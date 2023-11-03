public class TaskListTest {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        for (int i = 0; i < 10; i++) {
            String taskName = String.format("Task_%s", i);
            Task newTask = new Task(taskName);
            taskList.append(newTask);
        }
        System.out.println("\nInitial task list...\n");
        taskList.printAllTasks();
        taskList.markComplete(5);
        System.out.println("\nTask list after complete item 5...\n");
        taskList.printAllTasks();


    }
}
