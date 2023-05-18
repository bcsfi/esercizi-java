public class Rettangolo implements Shape {
    private double lunghezza;
    private double larghezza;


    public Rettangolo(double lunghezza, double larghezza) {
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
    }

    public double calculateArea() {
        return lunghezza * larghezza;
    }

    public double calculatePerimeter() {
        return (lunghezza + larghezza) * 2;
    }
}
