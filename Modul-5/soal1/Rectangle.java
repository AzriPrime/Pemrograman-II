package soal1;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double l, double w) {
        super.shapeName = "soal1.Rectangle";
        this.length = l;
        this.width = w;
    }

    public double area() {
        return length * width;
    }

    public String toString() {
        return super.toString() + " of area " + area();
    }
}
