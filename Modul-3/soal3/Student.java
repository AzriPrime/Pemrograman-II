package soal3;

public class Student {
    private String name;
    private String nim;

    Student(String Name, String NIM) {
        this.name = Name;
        this.nim = NIM;
    }

    String getName() {
        return name;
    }

    String getNim() {
        return nim;
    }
}