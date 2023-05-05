import java.util.Scanner;

public class Contrario {
    public static void main(String[] args) {
        String userInput = input();
        for(int i=userInput.length(); i >0; i--){
            System.out.print(userInput.substring(i-1,i));
        }
    }
    private static String input(){
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Inserisci frase: ");
        String Input = scanInput.nextLine();
        return Input;
    }
}
