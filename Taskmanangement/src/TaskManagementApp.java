import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class to represent a task with name, description, deadline, and priority
class Task {
    private String name;
    private String description;
    private String deadline;
    private int priority;

    // Constructor to initialize a task with its properties
    public Task(String name, String description, String deadline, int priority) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    // Override the toString method to display task details
    @Override
    public String toString() {
        return "Task: " + name + "\nDescription: " + description + "\nDeadline: " + deadline + "\nPriority: " + priority;
    }
}

// TaskManager class to manage a list of tasks
class TaskManager {
    private List<Task> tasks;

    // Constructor to initialize an empty list of tasks
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Method to add a task to the list
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method to display all tasks in the list
    public void displayTasks() {
        for (Task task : tasks) {
            System.out.println(task);
            System.out.println("------------------------------");
        }
    }
}

// Main class for the Task Management application
public class TaskManagementApp {
    public static void main(String[] args) {
        // Create a TaskManager instance to manage tasks
        TaskManager taskManager = new TaskManager();

        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Start an infinite loop for menu-based interaction
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Exit");

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    // Add a new task
                    System.out.print("Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Deadline: ");
                    String deadline = scanner.nextLine();
                    System.out.print("Priority (1-5): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline

                    // Create a new task and add it to the TaskManager
                    Task newTask = new Task(name, description, deadline, priority);
                    taskManager.addTask(newTask);
                    break;

                case 2:
                    // Display tasks
                    taskManager.displayTasks();
                    break;

                case 3:
                    // Close the scanner and exit the program
                    scanner.close();
                    System.exit(0);

                default:
                    // Handle invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
