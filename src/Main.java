import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

        // Menu:
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;

        System.out.println("Welcome to the To-Do-List Manager!");
        System.out.println("==================================");
        while (isValid) {
            System.out.println("Would you like to create a new user or select from the user list? (new/list)");
            String userOption = scanner.nextLine();
            System.out.println();
            if (!userOption.equals("new") && !userOption.equals("list")) {
                System.out.println("Please enter a valid option...");
            } else {
                switch (userOption) {
                    case "new":
                        System.out.println("Please enter your name: ");
                        String userName = scanner.nextLine();
                        User newUser = new User(userName);
                        users.add(newUser);
                        System.out.println("Selected user: " + newUser.getUserName());
                        System.out.println();
                        menuOptions(newUser);
                        isValid = false;
                        break;
                    case "list":
                        boolean userFound = false;
                        User selectedUser = null;

                        for (User user : users) {
                            System.out.println(user);
                        }

                        while (userFound == false) {
                            System.out.println();
                            System.out.println("Which user would you like to select? ");
                            String userSelect = scanner.nextLine();
                            for (User user : users) {
                                if (user.getUserName().equalsIgnoreCase(userSelect)) {
                                    selectedUser = user;
                                    userFound = true;
                                    break;
                                }
                            }
                            if (userFound) {
                                System.out.println("Selected user: " + selectedUser.getUserName());
                                System.out.println();
                                menuOptions(selectedUser);
                                isValid = false;
                                break;
                            } else {
                                System.out.println("User not found. Please enter a valid username.");
                            }
                        }
                        break;
                }
            }
        }
        scanner.close();

//        Glen's Code:
//        users.add(new User("Andy Anderson"));
//        users.add(new User("Candy Clinton"));
//        users.add(new User("Darryl Dean"));
//        users.add(new User("Elizabeth Earle"));
//        users.add(new User("Fatima Fink"));
//        users.add(new User("Gerald Gaines"));
//        users.add(new User("Hunter Hayse"));
//        users.add(new User("Ian Iverson"));
//        users.add(new User("Jessica Jones"));
//        users.add(new User("Kevin King"));
//        users.add(new User("Larry Langdon"));
//
//        for (User user: users) {
//            ArrayList<Integer> selections = generateUniqueRandomNumbers();
//            for (int selection : selections) {
//                Task newTask = new Task(tasks[selection]);
//                user.addTask(newTask);
//            }
//        }
//
//        for (User user : users) {
//            System.out.println();
//            user.printAllTasks();
//        }
//
//        for (User user : users) {
//            int selection = random.nextInt(4);
//            System.out.println("\nLocation selection: " + selection);
//            user.markTaskComplete(selection);
//            user.printAllTasks();
//        }
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

    public static void menuOptions(User username) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning){
            System.out.println("==============================================");
            System.out.println("Please select from the following menu options: \n1. Add tasks to user's to-do-list. \n2. Mark tasks as completed. \n3. Print all tasks for a user. \n4. Quit the program.");
            System.out.println("==============================================");
            System.out.println("Type your selected option here: ");
            int menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                // Add tasks to user's list
                case 1:
                    System.out.println("--------------------------------");
                    System.out.println("What task would you like to add?");
                    String task = scanner.nextLine();
                    Task newTask = new Task(task);
                    username.addTask(newTask);
                    System.out.println();
                    break;
                // Mark tasks as complete
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("Tasks: \n");
                    username.printAllTasks();
                    System.out.println();
                    System.out.println("Which task would you like to mark as complete: ");
                    int selection = scanner.nextInt();
                    scanner.nextLine();
                    username.markTaskComplete(selection);
                    System.out.println("Successfully marked task complete.");
                    break;
                // Prints all tasks
                case 3:
                    System.out.println("--------------------------------");
                    username.printAllTasks();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("--------------------------------");
                    System.out.println("Exiting the program.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("--------------------------------");
                    System.out.println("Please choose one of the options listed...");
                    break;
            }
        }
    }

}