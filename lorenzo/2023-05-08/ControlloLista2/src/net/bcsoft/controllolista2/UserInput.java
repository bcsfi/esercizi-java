package net.bcsoft.controllolista2;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInput {
    public static int Number4List(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Quanti numeri vuoi per lista?: ");
        return inputScanner.nextInt();
    }

    public static String getType4List(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Che tipo di lista deve essere? <T,S>: ");
        return inputScanner.next();
    }

    public static ArrayList<Integer> getCreateList(int numberIteration, int numberList){
        Scanner inputScanner = new Scanner(System.in);

        for(int i=0; i<numberIteration; i++) {
            System.out.print("Inserisci " + (i + 1) + "° numero della 'lista " + numberList + "': ");
            int userInput = inputScanner.nextInt();
        }
        return null;
    }
}