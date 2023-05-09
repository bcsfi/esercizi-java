import java.util.Scanner;

public class Punteggiatura {
    public static void main(String[] args) {

    }

    private static String checkedInput(String Input) {
        String [] punctuation = {".", ":", "!","?"};


    }

    /**
     * Input utente
     * @return userInput;
     */
    private static String requestInput() {
        String userInput;
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Inserire stringa: ");
        userInput = scanInput.nextLine();
        return userInput;
    }
}
