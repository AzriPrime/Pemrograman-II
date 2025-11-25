import java.util.List;

public class InputPage extends BasePage {
    private final InputReader inputReader;
    private final List<StudentBio> studentList;

    public InputPage(InputReader inputReader, List<StudentBio> studentList) {
        this.inputReader = inputReader;
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

        // Menggunakan Adapter (inputReader)
        newStudent.setName(inputReader.getInput("Full Name: "));
        newStudent.setStudentId(inputReader.getInput("Student ID: "));

        int age = 0;
        try {
            String ageStr = inputReader.getInput("Age (Number): ");
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Age Input. Saved as 0.");
        }
        newStudent.setAge(age);

        newStudent.setMajor(inputReader.getInput("Major: "));

        studentList.add(newStudent);

        System.out.println("\n✅ Data saved successfully!");

        // Reuse inputReader untuk pause
        inputReader.getInput("Press ENTER to return...");
    }
}