package ContinuaFino;
import java.util.Scanner;
public class ContinuaFino {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        while (true) {
            System.out.print("inserisci intero: ");
            int valore = input.nextInt();
            if (valore < 0 && valore % 2 == 0) {
                continue;
            } else if (valore > 0 && valore % 3 == 0) {
                sum += valore;
            } else {
                sum += valore;
            }
        }
        System.out.println("somma dei valori inseriti eccetto parametri non validi: " + );
    }
}
