package net.bcsoft.es1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dimensioneLista1, dimensioneLista2;
        int aggiunta, contatore = 0;
        ArrayList <Integer> numeri1 = new ArrayList<Integer>();
        ArrayList <Integer> numeri2 = new ArrayList<Integer>();
        ArrayList <Integer> occorrenze = new ArrayList<Integer>();

        System.out.println("CREAZIONE PRIMA LISTA \n" );
        System.out.println("Quanti numeri vuoi inserire nella prima lista? ");
        dimensioneLista1 = input.nextInt();
        for (int i = 0; i < dimensioneLista1; i++){
            System.out.println("Inserisci il numero da aggiungere: ");
            aggiunta = input.nextInt();
            numeri1.add(aggiunta);
        }
        System.out.println("Quanti numeri vuoi inserire nella seconda lista? ");
        dimensioneLista2 = input.nextInt();
        System.out.println("CREAZIONE SECONDA LISTA \n");
        for (int i = 0; i < dimensioneLista2; i++){
            System.out.println("Inserisci il numero da aggiungere: ");
            aggiunta = input.nextInt();
            numeri2.add(aggiunta);
        }

        for (int i = 0; i < dimensioneLista1; i++){
            if (Objects.equals(numeri1.get(i), numeri2.get(i))){
                occorrenze.add(numeri1.get(i));
                contatore++;
            }
        }
        System.out.println("Lista1 contiene " + contatore + " elementi di lista 1: ");
        for (Integer integer : occorrenze) {
            System.out.println(integer + "\n");
        }
    }
}