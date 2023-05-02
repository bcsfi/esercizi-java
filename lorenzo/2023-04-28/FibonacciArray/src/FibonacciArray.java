import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int userInput = requestIteration();
        long[] sequenceFibonacci = createSequenceFibonacci(userInput);
        stampSequenceFibonacci(sequenceFibonacci);
    }

    /**
     * Crea sequenza di Fibonacci
     * @param maxIteration
     */
    private static long[] createSequenceFibonacci(int maxIteration) { /* I metodi devono iniziare con un
                                                                            verbo e l'iniziale minuscola */
        long first = 0;
        long second = 1;
        long now = first;
        long[] exitSequence = new long[maxIteration];

        for(int i=0; i<maxIteration; i++) {
            now = first + second;
            exitSequence[i] = now;
            first = second;
            second = now;
        }
        return exitSequence;
    }
    /**
     * Input utente
     * @return userInput;
     */
    private static int requestIteration() {
        Scanner scanInput = new Scanner(System.in);
        System.out.print("Inserire numeri successione: ");
        int userInput = scanInput.nextInt();
        return userInput;
    }

    private static void stampSequenceFibonacci(long[] sequence){
        for(int i=0; i < sequence.length; i++) {
            System.out.println(sequence[i]);
        }
    }
}