import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dimensioneArray;
        System.out.println("Inserisci il numero di elementi che vuoi aggiungere: ");
        dimensioneArray = input.nextInt();
        int[] arrayGlobale = new int[dimensioneArray];
        int sommaPari = 0, sommaDispari = 0;
        arrayGlobale = aggiungiElementiArray(arrayGlobale, dimensioneArray);
        for(int i = 0; i < dimensioneArray; i += 2){
            sommaPari += arrayGlobale[i];
        }
        for(int i = 1; i < dimensioneArray; i += 2){
            sommaDispari += arrayGlobale[i];
        }
        if(sommaPari == sommaDispari){
            System.out.println("Pari e dispari uguali");
        }
        else{
            System.out.println("Pari e dispari diversi");
        }
    }
    private static int[] aggiungiElementiArray(int[] array, int dimensione){
        for(int i = 0; i < dimensione; i++){
            Scanner input = new Scanner(System.in);
            System.out.println("Inserisci numeri nell'array: ");
            array[i] = input.nextInt();
        }
        return array;
    }
}