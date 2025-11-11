import java.util.Scanner;

public abstract class BasePage implements CLIpage {
    protected final Scanner scanner;

    public BasePage(Scanner scanner) {
        this.scanner = scanner;
    }

    protected void displayTitle() {
        System.out.println("\n--- " + getName().toUpperCase() + " ---");
    }
}
