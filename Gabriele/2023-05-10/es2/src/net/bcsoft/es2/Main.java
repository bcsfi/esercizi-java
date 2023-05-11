package net.bcsoft.es2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //int[] array = new int[5];
        List<Number> lista = new ArrayList<>();
        int indice;
        Number elemento = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci la posizione in cui vuoi aggiungere un elemento: ");
        indice = input.nextInt();
        System.out.println("Inserisci l'elemento da inserire: ");


        if(input.hasNextInt()){
            elemento = input.nextInt();
        }
        else if (input.hasNextDouble()) {
            elemento = input.nextDouble();
        }
        else if (input.hasNextLong()) {
            elemento = input.nextLong();
        }
        if(indice > 5){
            throw new IndexOutOfBoundsException();
        }
        else{
            lista.add(indice, elemento);
        }
        /*
        try {
             array[indice] = elemento;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Indice elemento non corretto, riprovare");
        }*/

    }
}