import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dimensioneArray;
        System.out.println("Quanti elementi vuoi inserire nel tuo array?");
        dimensioneArray = input.nextInt();
        if(dimensioneArray <= 0){
            System.out.println("Dimensione array non corretta, deve essere >= 0. ");
        }
        int[] arrayZigZag = new int[dimensioneArray];
        arrayZigZag = inserisciElementi(arrayZigZag, dimensioneArray);
        stampaZigZag(arrayZigZag, dimensioneArray);
    }
    private static int[] inserisciElementi(int[] array, int dimensione){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < dimensione; i++){
            System.out.println("Inserisci l'elemento: ");
            array[i] = input.nextInt();
        }
        return array;
    }
    private static void stampaZigZag(int[] array, int dimensione){
        for (int i =0; i < dimensione / 2; i++){
            System.out.println(array[i] + " " + array[(array.length - 1) - i]);
        }
    }
}