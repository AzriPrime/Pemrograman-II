package soal1;

public abstract class Shape {
    protected String shapeName;

    protected abstract double area();

    public String toString() {
        return shapeName;
    };
}
