import java.util.List;
import java.util.Scanner;

public class InputPage extends BasePage {
    // Composition
    private final List<StudentBio> studentList;

    public InputPage(Scanner scanner, List<StudentBio> studentList) {
        super(scanner);
        this.studentList = studentList;
    }

    @Override
    public String getName() {
        return "Input Student Data";
    }

    @Override
    public void display() {
        displayTitle();
        System.out.println("Please enter student details:");

        StudentBio newStudent = new StudentBio();

        newStudent.setName(getInput("Full Name: "));
        newStudent.setStudentId(getInput("Student ID: "));

        int age = 0;
        try {
            String ageStr = getInput("Age (Number): ");
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Age Input. Saved as 0.");
        }
        newStudent.setAge(age);

        newStudent.setMajor(getInput("Major: "));

        studentList.add(newStudent);

        System.out.println("\n✅ Data saved successfully!");

        System.out.print("Press ENTER to return...");
        scanner.nextLine();
    }

    private String getInput(String p) {
        System.out.print(p);
        return scanner.nextLine();
    }
}
