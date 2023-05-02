import java.util.Scanner;
public class SpaziVocali {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("inserisci stringa: ");
        String stringa = input.nextLine();
        //input.close();
        String vocali = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i < stringa.length()-1; i++) {
            if (stringa.charAt(i) == ' ' && vocali.contains(""+ stringa.charAt(i+1))){
                count++;
            }
        }
        System.out.println("Numero di spazi seguiti da vocale: "+ count);

    }
}
