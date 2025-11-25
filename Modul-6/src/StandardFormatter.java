public class StandardFormatter implements DisplayStrategy {
    @Override
    public String format(StudentBio student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            return "--- NO STUDENT DATA SAVED ---";
        }
        return "\n--- STUDENT BIO ---\n" +
                "Name      : " + student.getName() + "\n" +
                "Student ID: " + student.getStudentId() + "\n" +
                "Age       : " + student.getAge() + " years\n" +
                "Major     : " + student.getMajor() + "\n" +
                "-------------------------";
    }
}