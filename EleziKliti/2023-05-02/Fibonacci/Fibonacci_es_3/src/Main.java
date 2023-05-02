import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        int sum = 0;

        while(true){
            // Richiedi input INT all'utente
            System.out.println("Enter the number:");

            int inputNumber = Scan.nextInt();  // Cattura INT inserito dall'utente.
            sum = sum + inputNumber;

            if(inputNumber < 0 && inputNumber % 2 == 0){
                System.out.println("Hai soddisfato i requisiti.");
                sum = sum - inputNumber;
                break;
            }

            if(inputNumber > 0 && inputNumber % 3 == 0){
                System.out.println("Hai soddisfato i requisiti.");
                sum = sum - inputNumber;
                break;
            }

            // Notifica
            System.out.println("Numero sommato, senza soddisfare i requisiti. Totale: " + sum);

        }
        
        System.out.println("Le totale delle somme sono: " + sum);

    }
}