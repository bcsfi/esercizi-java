package net.bcsoft.es1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero;
        double numeroCasuale = 0, risultato = 0;
        System.out.println("Scrivi il numero ");
        numero = input.nextInt();

        for(int i = 0; i < 50; i++) {
            try {
                numeroCasuale = Math.random() * 3;
                risultato = numero / numeroCasuale;
            } catch (ArithmeticException e) {
                System.out.println("Impossibile dividere per 0, riprovare");
            }
            finally {
                System.out.println("il risultato della divisione tra " + numero + " e " + numeroCasuale + " e uguale a: " + risultato);
            }
        }
    }
}