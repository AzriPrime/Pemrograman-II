import java.util.List;

public class PageFactory {
    public static CLIpage createInputPage(InputReader reader, List<StudentBio> data) {
        return new InputPage(reader, data);
    }

    public static CLIpage createDisplayPage(InputReader reader, List<StudentBio> data) {
        return new DisplayPage(reader, data, new StandardFormatter());
    }
}