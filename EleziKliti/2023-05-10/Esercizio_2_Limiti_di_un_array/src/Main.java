import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] string) {

        boolean start = true;
        int[] d = {1,2,3,4,5};
        int valAdd, posAdd;


        try {
            while(start){

                Scanner scan = new Scanner(System.in);
                System.out.print("\n Seleziona il numero da inserire: ");
                valAdd = scan.nextInt();

                System.out.print("\n Seleziona la posizione in cui inserirla: ");
                posAdd = scan.nextInt();

                d[posAdd] = valAdd;
                System.out.print("\n Valore inserito correttamente. Posizione esistente.");
                System.out.print("\n Vuoi aggiungere altro (Y/N): ");
                String c = scan.next();

                if (c.equals("N") || c.equals("n"))
                    start = false;

            }
        } catch(InputMismatchException inp){
            System.out.print("\n Errore, Input inserito del tipo non valido. \n ");
        } catch (ArrayIndexOutOfBoundsException aid){
            System.out.print("\n Errore, Sei uscito fuori dal range dell'array \n");
        }


        System.out.print("\tLista valori:\t");
        for(int c : d){
            System.out.printf("%d", c);
        }


    }
}

