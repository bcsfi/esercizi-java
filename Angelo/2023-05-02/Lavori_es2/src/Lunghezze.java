import java.util.Scanner;
public class Lunghezze {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String stringa = "";
        int somma = 0;
        do {
            System.out.print("inserisci una stringa, inserisci stringa vuota per interrompere sequenza: ");
            stringa = input.nextLine();
            if (!stringa.isEmpty() && Character.isUpperCase(stringa.charAt(0))){
                somma += stringa.length();
            }

        } while (!stringa.isEmpty());
        System.out.println("somma delle lunghezze delle stringhe che iniziano con lettera maiuscola: " + somma);
    }
}
