
import java.util.ArrayList;
import java.util.Scanner;

public class CheckCoppie {
    public static void main(String[] args) {
        int elemento1, elemento2;
        int a, b;
        int conteggio = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Coppie> lista1 = new ArrayList<>();
        ArrayList<Coppie> lista2 = new ArrayList<>();
        ArrayList<Coppie> occorrenze = new ArrayList<>();

        System.out.println("crea la prima lista di coppie \n");
        System.out.println("Quante coppie vuoi inserire? ");
        elemento1 = input.nextInt();
        for (int i = 0; i < elemento1; i++){
            System.out.println("Inserisci il primo elemento della coppia: ");
            a = input.nextInt();
            System.out.println("Inserisci il secondo elemento della coppia: ");
            b = input.nextInt();
            Coppie coppia = new Coppie<>(a, b);
            lista1.add(coppia);
        }

        System.out.println("crea la seconda lista di coppie \n");
        System.out.println("Quante coppie vuoi inserire? ");
        elemento2 = input.nextInt();
        for (int i = 0; i < elemento2; i++){
            System.out.println("Inserisci il primo elemento della coppia: ");
            a = input.nextInt();
            System.out.println("Inserisci il secondo elemento della coppia: ");
            b = input.nextInt();
            Coppie coppia = new Coppie<>(a, b);
            lista2.add(coppia);
        }

        for (int i = 0; i < lista1.size(); i++){
            if(lista1.get(i) == lista2.get(i)){
                occorrenze.add(lista1.get(i));
                conteggio ++;
            }
        }
        System.out.println("Le due liste hanno");

    }
}