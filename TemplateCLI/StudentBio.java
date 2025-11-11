public class StudentBio {
    private String name;
    private String studentId;
    private int age;
    private String major;

    public StudentBio() {}

    // Getter/Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    @Override
    public String toString() {
        if (name == null || name.isEmpty()) {
            return "--- NO STUDENT DATA SAVED ---";
        }
        return "\n--- STUDENT BIO ---\n" +
                "Name      : " + name + "\n" +
                "Student ID: " + studentId + "\n" +
                "Age       : " + age + " years\n" +
                "Major     : " + major + "\n" +
                "-------------------------";
    }
}

