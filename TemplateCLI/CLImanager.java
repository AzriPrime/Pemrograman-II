import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLImanager {
    private final List<StudentBio> studentList;
    private final List<CLIpage> menuPages;
    private final Scanner scanner;
    private boolean isRunning = true;

    public CLImanager(Scanner scanner) {
        this.scanner = scanner;
        this.studentList = new ArrayList<>(); // Composition: Creates the data model
        this.menuPages = new ArrayList<>();

        // Composition: Creates pages and injects the shared data model
        menuPages.add(new InputPage(scanner, studentList));
        menuPages.add(new DisplayPage(scanner, studentList));
    }

    public void start() {
        while (isRunning) {
            displayMenu();
            processSelection();
        }
        System.out.println("Biodata application closed. Goodbye!");
    }

    private void displayMenu() {
        System.out.println("\n=== BIODATA MENU ===");

        for (int i = 0; i < menuPages.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + menuPages.get(i).getName());
        }
        System.out.println("[0] Exit");
        System.out.println("--------------------------------------");
    }

    private void processSelection() {
        System.out.print("Select number: ");
        try {
            int selection = Integer.parseInt(scanner.nextLine());

            if (selection == 0) {
                isRunning = false;
            } else if (selection > 0 && selection <= menuPages.size()) {
                menuPages.get(selection - 1).display(); // Polymorphism
            } else {
                System.out.println("Invalid number selected.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input must be a number.");
        }
    }
}
