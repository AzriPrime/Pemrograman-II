import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creates and manages resource
        Scanner scanner = new Scanner(System.in);

        // Delegates control
        CLImanager manager = new CLImanager(scanner);
        manager.start();

        // Closes resource
        scanner.close();
    }
}
