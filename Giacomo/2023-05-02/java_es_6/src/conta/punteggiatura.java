import java.util.Scanner;

public class punteggiatura {
    public static void main (String[]args) {
        Scanner input = new Scanner(System.in);
        String stringa = "";
        String stringAttuale;
        System.out.println("inserisci una stringa , inserisci una stringa vuota per interrompere la sequenza");
        while (true){
            stringAttuale = input.nextLine();
            if (stringAttuale.isEmpty()) {
            break;
            }
            stringa += stringAttuale + " ";
        }
        int contaPunteggiatura = 0;
        for(int i=0; i< stringa.length(); i++){
            char c = stringa.charAt(i);
            if (c == '.' || c == ';' || c == ':' || c == '!' || c == '?'){
                contaPunteggiatura++;
            }
        }
        System.out.println("il numero dei caratteri di punteggiatura è:" +contaPunteggiatura);
    }




}
