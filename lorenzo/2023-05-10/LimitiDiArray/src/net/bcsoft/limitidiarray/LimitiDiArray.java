package net.bcsoft.limitidiarray;

import java.util.ArrayList;
import java.util.Scanner;

public class LimitiDiArray {
    public static void main(String[] args) {
        try{
            ArrayList<Integer> array = new ArrayList<Integer>(5);

            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Inserisci numero> ");
            int userInput = inputScanner.nextInt();

            int last = array.get(userInput);
        }catch (IndexOutOfBoundsException e){
            System.out.println("LIMITE ARRAY SUPERATO \n" + e);
        }
    }
}
