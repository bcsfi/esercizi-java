/*Scrivi un programma che istanziato un vettore di interi di
 5 posizioni chieda all'utilizzatore di inserire un numero in
 una posizione specificata; gestire l'eventualità che
 vengano violati i limiti dell'array .*/



import java.util.Scanner;

public class InserimentoArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Crea un vettore di interi di 5 posizioni
        int[] vettore = new int[5];

        // Chiedi all'utente di inserire il numero e la posizione
        System.out.print("Inserisci un numero: ");
        int numero = input.nextInt();
        System.out.print("Inserisci la posizione (da 1 a 5): ");
        int posizione = input.nextInt();

        // Verifica se la posizione inserita è valida
        if (posizione < 1 || posizione > 5) {
            System.out.println("La posizione inserita non è valida");
            return;
        }

        // Inserisci il numero nella posizione specificata
        vettore[posizione-1] = numero;

        // Stampa il vettore aggiornato
        System.out.print("Il vettore aggiornato è: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(vettore[i] + " ");
        }
    }
}