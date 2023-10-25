public class TaskList {
    public Node head;
    public Node tail;
    public int size;

    public void append(Task newTask){
        Node node = new Node();
        node.value = newTask;

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size ++;
    }

    public void markComplete(int taskLocation) {
        if (head == null) {
            System.out.println("Task list does not exist...");
            return;
        } else if (taskLocation > size - 1) {
            System.out.println("Location does not exist");
        }
        Node tempNode = head;
        for (int i = 0; i < taskLocation; i++) {
            tempNode = tempNode.next;
        }
        tempNode.value.markComplete();
    }

    public void printAllTasks() {
        if (head == null){
            System.out.println("Task list does not exist...");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(i + ": ");
                System.out.println(tempNode.value.toString());
                tempNode = tempNode.next;
            }
        }
    }
}
