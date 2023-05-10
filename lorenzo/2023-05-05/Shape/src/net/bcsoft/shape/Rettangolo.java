package net.bcsoft.shape;

public class Rettangolo {
    private int lunghezza, larghezza;

    public double calculateArea(int larghezza, int lunghezza) {
        double area = larghezza * lunghezza;
        return area;
    }

    public double calculatePerimeter(int larghezza, int lunghezza) {
        double perimeter = (larghezza * 2) + (lunghezza * 2);
        return perimeter;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public void setLarghezza(int larghezza) {
        this.larghezza = larghezza;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public int getLarghezza() {
        return larghezza;
    }
}
