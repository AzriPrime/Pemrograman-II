import java.util.List;

public class DisplayPage extends BasePage {
    private final InputReader inputReader;
    private final List<StudentBio> studentList;
    private final DisplayStrategy formatter; // Strategy

    public DisplayPage(InputReader inputReader, List<StudentBio> studentList, DisplayStrategy formatter) {
        this.inputReader = inputReader;
        this.studentList = studentList;
        this.formatter = formatter;
    }

    @Override
    public String getName() {
        return "Display Student Data";
    }

    @Override
    public void display() {
        displayTitle();

        if (studentList.isEmpty()) {
            System.out.println("--- NO STUDENT DATA SAVED ---");
        } else {
            for (StudentBio student : studentList) {
                // Delegasi formatting ke Strategy
                System.out.println(formatter.format(student));
            }
        }

        inputReader.getInput("\nPress ENTER to return...");
    }
}