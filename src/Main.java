import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static final ArrayList<User> users = new ArrayList<>();
    private static final Random random = new Random();
    private static final String[] tasks = {
            "Clean the house",
            "Buy groceries",
            "Walk the dog",
            "Read a book",
            "Write a report",
            "Exercise",
            "Call a friend",
            "Cook dinner",
            "Do the laundry",
            "Go for a run",
            "Attend a meeting",
            "Study for the exam",
            "Water the plants",
            "Meditate",
            "Watch a movie",
            "Plan a trip",
            "Solve a puzzle",
            "Learn a new language",
            "Paint a picture",
            "Write code",
            "Take a nap",
            "Organize the closet",
            "Visit the dentist",
            "Meet a friend for coffee",
            "Shop for new clothes",
            "Prepare a presentation",
            "Listen to music",
            "Bake cookies",
            "Go hiking",
            "Try a new recipe",
            "Read the news",
            "Do yoga",
            "Write a poem",
            "Fix a leaky faucet",
            "Plant flowers in the garden",
            "Write a thank-you note",
            "Volunteer at a local charity",
            "Spend time with family",
            "Visit a museum",
    };

    public static void main(String[] args) {
        users.add(new User("Andy Anderson"));
        users.add(new User("Candy Clinton"));
        users.add(new User("Darryl Dean"));
        users.add(new User("Elizabeth Earle"));
        users.add(new User("Fatima Fink"));
        users.add(new User("Gerald Gaines"));
        users.add(new User("Hunter Hayse"));
        users.add(new User("Ian Iverson"));
        users.add(new User("Jessica Jones"));
        users.add(new User("Kevin King"));
        users.add(new User("Larry Langdon"));

        for (User user: users) {
            ArrayList<Integer> selections = generateUniqueRandomNumbers();
            for (int selection : selections) {
                Task newTask = new Task(tasks[selection]);
                user.addTask(newTask);
            }
        }

        for (User user : users) {
            System.out.println();
            user.printAllTasks();
        }

        for (User user : users) {
            int selection = random.nextInt(4);
            System.out.println("\nLocation selection: " + selection);
            user.markTaskComplete(selection);
            user.printAllTasks();
        }
    }

    public static ArrayList<Integer> generateUniqueRandomNumbers() {
        int count = 5;

        ArrayList<Integer> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < count) {
            int randomNumber = random.nextInt(39);
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }
        return uniqueNumbers;
    }
}