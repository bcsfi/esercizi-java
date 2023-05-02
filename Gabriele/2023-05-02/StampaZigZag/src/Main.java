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
        for(int i= 0; i < dimensioneArray; i++){
            System.out.println("Inserisci i numeri nell'array: ");
            arrayZigZag[i] = input.nextInt();
        }
        for (int i = 0; i < (dimensioneArray / 2); i++) {
            System.out.println(arrayZigZag[i] + " " + arrayZigZag[(arrayZigZag.length - 1) - i]);
        }
    }
    private static void inserisciElementi(int[] array, int dimensione){
        Scanner input = input.nextInt();
        for(int i = 0; i < dimensione; i++){
            array[i] = input.nextInt();
        }
    }
}