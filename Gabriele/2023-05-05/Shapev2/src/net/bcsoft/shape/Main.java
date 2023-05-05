package net.bcsoft.shape;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Double lunghezza = 25.0;
        Double larghezza = 40.0;
        Shape rettangolo = new Rettangolo(lunghezza, larghezza);

        System.out.println(rettangolo.calculateArea());
    }
}