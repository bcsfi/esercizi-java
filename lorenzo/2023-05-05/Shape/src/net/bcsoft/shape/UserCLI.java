package net.bcsoft.shape;
import java.util.Scanner;

public class UserCLI {
    public static int initialRequest() {
        Scanner selectionScanner = new Scanner(System.in);
        System.out.println("Cosa vuoi calcolare \n - Cerchio (0) \n - Rettangolo (1)");
        System.out.print("| ");
        int selection = selectionScanner.nextInt();

        if(selection>1) System.out.println("SELEZIONE ERRATA");

    return selection;
    }

    public static void UserRettangolo(){
        Scanner lunghezzaScanner = new Scanner(System.in);
        Scanner larghezzaScanner = new Scanner(System.in);

        System.out.println("Inserisci lunghezza rettangolo: ");
        int lunghezza = lunghezzaScanner.nextInt();

        System.out.println("Inserisci larghezza rettangolo: ");
        int larghezza = larghezzaScanner.nextInt();

    }
}
