package net.bcsoft.shapewithinterface;

public class Main {
    public static void main(String[] args) {
        Double lunghezza = 25.0;
        Double larghezza = 40.0;
        Shape rettangolo = new Rectangle(lunghezza, larghezza, "rettangolo");
        Shape cerchio = new Round(15.0, "cerchio");

        System.out.println(rettangolo.calculateArea());
        System.out.println(rettangolo.calculatePerimeter());
        System.out.println(cerchio.calculateArea());
        System.out.println(cerchio.calculatePerimeter());
    }
}