package net.bcsoft.controllolista;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInput {
    public static int getNumber4List(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Quanti numeri vuoi per lista?: ");
        return inputScanner.nextInt();
    }
    public static ArrayList<Integer> createList(int numberIteration, int numberList){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        Scanner inputScanner = new Scanner(System.in);

        for(int i=0; i<numberIteration; i++){
            System.out.print("Inserisci " + (i+1) + "° numero della 'lista " + numberList + "': ");
            int userInput = inputScanner.nextInt();
            returnList.add(userInput);
        }
        return returnList;
    }
}
