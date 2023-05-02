import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        while(true){

            // Richiedi input INT all'utente
            System.out.println("Enter the number:");
            int inputNumber = Scan.nextInt();  // Cattura INT inserito dall'utente.

            System.out.println("Enter the number:");
            int numberDue = Scan.nextInt();  // Cattura INT inserito dall'utente.

            if(inputNumber > 0 && numberDue < 0 || inputNumber < 0 && numberDue > 0){
                System.out.println("Hai inserito un numero positivo e uno negativo.");
                break;
            }

            if(inputNumber == 0){
                System.out.println("Ciao caro.");
                break;
            }

        }

    }
}