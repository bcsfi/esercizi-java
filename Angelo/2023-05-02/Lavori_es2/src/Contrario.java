import java.util.Scanner;
public class Contrario {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String str = input.nextLine();
        String strReverse = "";
        for (int i = str.length() - 1; i >= 0; i--){
            strReverse += str.charAt(i);
        }
        System.out.println(strReverse);
    }
}
