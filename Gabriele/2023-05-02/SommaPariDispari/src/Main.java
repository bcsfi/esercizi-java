import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arrayGlobale = new int[10];
        int sommaPari = 0, sommaDispari = 0;
        for(int i = 0; i < 10; i++){
            System.out.println("Inserisci numeri nell'array: ");
            arrayGlobale[i] = input.nextInt();
        }
        for(int i = 0; i < 10; i += 2){
            sommaPari += arrayGlobale[i];
        }
        for(int i = 1; i < 10; i += 2){
            sommaDispari += arrayGlobale[i];
        }
        if(sommaPari == sommaDispari){
            System.out.println("Pari e dispari uguali");
        }
        else{
            System.out.println("Pari e dispari diversi");
        }
    }
}