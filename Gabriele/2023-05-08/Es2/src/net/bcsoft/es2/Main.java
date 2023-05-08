package net.bcsoft.es2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int dimensione1, dimensione2;
        int x, y;
        int conteggio = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Coppie> lista1 = new ArrayList<>();
        ArrayList<Coppie> lista2 = new ArrayList<>();
        ArrayList<Coppie> occorrenze = new ArrayList<>();

        System.out.println("CREAZIONE PRIMA LISTA DI COPPIE \n");
        System.out.println("Quante coppie vuoi inserire? ");
        dimensione1 = input.nextInt();
        for (int i = 0; i < dimensione1; i++){
            System.out.println("Inserisci il primo elemento della coppia: ");
            x = input.nextInt();
            System.out.println("Inserisci il secondo elemento della coppia: ");
            y = input.nextInt();
            Coppie coppia = new Coppie<>(x, y);
            lista1.add(coppia);
        }

        System.out.println("CREAZIONE SECONDA LISTA DI COPPIE \n");
        System.out.println("Quante coppie vuoi inserire? ");
        dimensione2 = input.nextInt();
        for (int i = 0; i < dimensione2; i++){
            System.out.println("Inserisci il primo elemento della coppia: ");
            x = input.nextInt();
            System.out.println("Inserisci il secondo elemento della coppia: ");
            y = input.nextInt();
            Coppie coppia = new Coppie<>(x, y);
            lista2.add(coppia);
        }

        for (int i = 0; i < lista1.size(); i++){
            if(lista1.get(i) == lista2.get(i)){
                occorrenze.add(lista1.get(i));
                conteggio ++;
            }
        }
        System.out.println("Le due liste hanno");

    }
}