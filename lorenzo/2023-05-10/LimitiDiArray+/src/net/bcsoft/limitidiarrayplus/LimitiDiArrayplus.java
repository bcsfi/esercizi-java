package net.bcsoft.limitidiarrayplus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitiDiArrayplus {
    public static void main(String[] args) {
        try{
            List<Number> array = new ArrayList<Number>(5);

            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Inserisci numero> ");
            int userInput = inputScanner.nextInt();

            List<Number> last = array.get(userInput);
        }catch (IndexOutOfBoundsException e){
            System.out.println("LIMITE ARRAY SUPERATO \n" + e);
        }
    }
}
