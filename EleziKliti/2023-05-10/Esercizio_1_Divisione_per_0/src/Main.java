import javax.crypto.ExemptionMechanism;
import java.rmi.server.ExportException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean start = true;
        while (start)
            try {
                Scanner scan = new Scanner(System.in); int a;
                System.out.print("\n Inserisci un input: ");
                a = scan.nextInt();
                start=false;
            }catch (InputMismatchException d)
            {
                System.out.print("\n Errore, dato non valido.");
            }

        System.out.print("Programma terminato senza errori..");


    }
}