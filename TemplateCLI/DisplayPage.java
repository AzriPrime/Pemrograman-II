import java.util.List;
import java.util.Scanner;

public class DisplayPage extends BasePage {
    private final List<StudentBio> studentList;

    public DisplayPage(Scanner scanner, List<StudentBio> studentList) {
        super(scanner);
        this.studentList = studentList;
    }

    @Override
    public String getName() {
        return "Display Student Data";
    }

    @Override
    public void display() { // Method Name
        displayTitle(); // Method Name (inherited)

        if (studentList.isEmpty()) {
            System.out.println("--- NO STUDENT DATA SAVED ---");
        } else {
            for (StudentBio student : studentList) {
                System.out.println(student.toString());
            }
        }

        System.out.print("\nPress ENTER to return...");
        scanner.nextLine();
    }
}
