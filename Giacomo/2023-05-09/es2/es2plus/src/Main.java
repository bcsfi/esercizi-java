/*Scrivi un programma che istanziato un vettore di interi di
 5 posizioni chieda all'utilizzatore di inserire un numero in
 una posizione specificata; gestire l'eventualità che
 vengano violati i limiti dell'array .*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {


        // Crea una lista di 5 posizioni
        List<Number> numero = new ArrayList<>(5);
        Scanner scanner = new Scanner(System.in);


        // Chiedi all'utente di inserire dei numeri
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Inserisci un numero: ");
            String input = scanner.nextLine();
            try {
                if (input.contains(".")) {
                    double VariabileDouble = Double.parseDouble(input);
                    numero.add(VariabileDouble);
                } else {
                    long VariabileLong = Long.parseLong(input);
                    if (VariabileLong <= Integer.MAX_VALUE && VariabileLong >= Integer.MIN_VALUE) {
                        int VariabileInt = (int) VariabileLong;
                        numero.add(VariabileInt);
                    } else {
                        numero.add(VariabileLong);
                    }
                }
            }
            catch(NumberFormatException e)
            {
                i--;

                {
                    System.out.println("input non valido , riprova");
                }
            }
        }

        System.out.println("Numeri inseriti: " + numero);
    }
}
