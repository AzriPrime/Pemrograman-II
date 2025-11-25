import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CLImanager manager = new CLImanager(scanner);
        manager.start();
        scanner.close();
    }
}