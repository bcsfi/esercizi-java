
import java.awt.Component;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Acquisizione delle liste dall'utente
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una lista di numeri separati da una virgola: ");
        String[] lista1 = scanner.nextLine().split(",");
        System.out.print("Inserisci un'altra lista di numeri separati da una virgola: ");
        String[] lista2 = scanner.nextLine().split(",");

        // Variabili per contare gli elementi di lista2 contenuti in lista1
        int count = 0;
        ArrayList<String> elements = new ArrayList<>();

        // Ciclo per controllare gli elementi di lista2 contenuti in lista1
        for (int i = 0; i < lista2.length; i++) {
            if (contains(lista1, lista2[i])) {
                count++;
                elements.add(lista2[i]);
            }
        }

        // Stampa del messaggio con il numero di elementi e gli elementi stessi
        if (count > 0) {
            String message = "Lista1 contiene " + count + " elementi di Lista2: " + String.join(", ", elements);
            System.out.println(message);
        } else {
            System.out.println("Nessun elemento di Lista2 è contenuto in Lista1");
        }
    }
    public static boolean contains(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
}
