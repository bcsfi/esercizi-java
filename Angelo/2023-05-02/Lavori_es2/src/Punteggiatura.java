import java.util.Scanner;
public class Punteggiatura {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String stringa = "";
        String stringaAttuale;
        System.out.println("inserisci una stringa, insreisci stringa vuota per interrompere sequenza: ");
        while (true) {
            stringaAttuale = input.nextLine();
            if (stringaAttuale.isEmpty()) {
                break;
            }
            stringa += stringaAttuale + " ";
        }
        int contaPunteggiatura = 0;
        for (int i= 0; i < stringa.length(); i ++){
            char c = stringa.charAt(i);
            if (c == '.' || c == ',' || c == ';' || c == ':' || c == '!' || c == '?') {
                contaPunteggiatura++;
            }
        }
        System.out.println("numero di caratteri di punteggiatura: " + contaPunteggiatura);
    }
}
