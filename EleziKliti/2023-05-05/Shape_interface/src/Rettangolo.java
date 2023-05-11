
public class Rettangolo implements Shape {


    String name;
    private double height, width;

    Rettangolo(String name, double width, double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return this.width * this.height;
    }
    public double calculatePerimeter() {
        return 2.0 * (this.width + this.height);
    }
}
