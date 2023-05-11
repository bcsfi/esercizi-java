import java.util.Random;
import java.util.Scanner;

public class DivisioneCasuale {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Leggi il numero dall'utente
        System.out.print("Inserisci un numero intero: ");
        int numero = input.nextInt();

        // Genera un numero casuale compreso fra 0 e 3
        int divisore = rand.nextInt(4);

        // Esegui la divisione, intercettando l'eccezione della divisione per 0
        try {
            double risultato = numero / divisore;
            System.out.println("Il numero casuale è: "+ divisore +" \nIl risultato della divisione è: " + risultato);
        } catch (ArithmeticException e) {
            System.out.println("Impossibile dividere per 0");
        }
    }
}