import java.util.Scanner;

public class Ripeti{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String stringa = input.nextLine();
        System.out.print("Inserisci un numero intero positivo: ");
        int numero = input.nextInt();
        stampaStringa(stringa, numero);
    }
    private static void stampaStringa(String stringa, int numero){
        if (numero < 0){
            System.out.println("ERRORE: numero negativo");
            return;
        }
        for (int i = 0; i < numero; i++){
            System.out.println(stringa);
        }
    }
}