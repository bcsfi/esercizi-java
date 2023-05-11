package net.bcsoft.divisioneperzero;

import java.util.Scanner;

public class UserInput {

    public static int getNumber(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Inserisci numero> ");
        return inputScanner.nextInt();
    }
}
