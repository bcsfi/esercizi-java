import java.util.Scanner;

public class StampaZigZag {
    public static void main(String[] args) {
        int[] numeri = {6, 2, 3, 4, 5, 1, 12, 8, 9, 10};
        for (int i = 0, j = numeri.length - 1; i <= j; i++, j--){
            System.out.print(numeri[i] + " ");
            if (i != j){
                System.out.print(numeri[j] + " ");
            }
        }
    }
}