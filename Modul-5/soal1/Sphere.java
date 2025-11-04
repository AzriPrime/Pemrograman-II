package soal1;

public class Sphere extends Shape {
    private double radius;

    public Sphere(double r) {
        super.shapeName = "soal1.Sphere";
        this.radius = r;
    }

    public double area() {
        return 4*Math.PI * (radius * radius);
    }

    public String toString() {
        return super.toString() + " of area " + area();
    }
}
