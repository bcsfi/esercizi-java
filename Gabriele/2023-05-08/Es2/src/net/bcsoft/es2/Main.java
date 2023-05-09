package net.bcsoft.es2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int dimensione1, dimensione2;
        String sceltaTipo;
        Object obj;
        int conteggio = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Coppie> lista1 = new ArrayList<>();
        ArrayList<Coppie> lista2 = new ArrayList<>();
        ArrayList<Coppie> occorrenze = new ArrayList<>();


        System.out.println("Di che tipo vuoi l'array 1 ? \n" +
                "Premi i se vuoi int; \n" +
                "Premi d se vuoi double; \n" +
                "Premi f se vuoi float \n");

        sceltaTipo = input.next();
        sceltaTipo.toLowerCase();
        switch (sceltaTipo) {
            case "i" -> {
                int x, y;
                System.out.println("CREAZIONE PRIMA LISTA DI COPPIE \n");
                System.out.println("Quante coppie vuoi inserire? ");
                dimensione1 = input.nextInt();
                for (int i = 0; i < dimensione1; i++) {
                    System.out.println("Inserisci il primo elemento della coppia: ");
                    x = input.nextInt();
                    System.out.println("Inserisci il secondo elemento della coppia: ");
                    y = input.nextInt();
                    Coppie coppia = new Coppie<>(x, y);
                    lista1.add(coppia);
                }
            }
            case "d" -> {
                double a, b;
                System.out.println("CREAZIONE PRIMA LISTA DI COPPIE \n");
                System.out.println("Quante coppie vuoi inserire? ");
                dimensione1 = input.nextInt();
                for (int i = 0; i < dimensione1; i++) {
                    System.out.println("Inserisci il primo elemento della coppia: ");
                    a = input.nextDouble();
                    System.out.println("Inserisci il secondo elemento della coppia: ");
                    b = input.nextDouble();
                    Coppie coppia = new Coppie<>(a, b);
                    lista1.add(coppia);
                }
            }
            case "f" -> {
                float c, d;
                System.out.println("CREAZIONE PRIMA LISTA DI COPPIE \n");
                System.out.println("Quante coppie vuoi inserire? ");
                dimensione1 = input.nextInt();
                for (int i = 0; i < dimensione1; i++) {
                    System.out.println("Inserisci il primo elemento della coppia: ");
                    c = input.nextFloat();
                    System.out.println("Inserisci il secondo elemento della coppia: ");
                    d = input.nextFloat();
                    Coppie coppia = new Coppie<>(c, d);
                    lista1.add(coppia);
                }
            }
        }

        System.out.println("Di che tipo vuoi l'array 2 ? \n" +
                "Premi i se vuoi int; \n" +
                "Premi d se vuoi double; \n" +
                "Premi f se vuoi float \n");

        sceltaTipo = input.next();
        sceltaTipo.toLowerCase();
        switch (sceltaTipo) {
            case "i" -> {
                int x, y;
                System.out.println("CREAZIONE SECONDA LISTA DI COPPIE \n");
                System.out.println("Quante coppie vuoi inserire? ");
                dimensione2 = input.nextInt();
                for (int i = 0; i < dimensione2; i++) {
                    System.out.println("Inserisci il primo elemento della coppia: ");
                    x = input.nextInt();
                    System.out.println("Inserisci il secondo elemento della coppia: ");
                    y = input.nextInt();
                    Coppie coppia = new Coppie<>(x, y);
                    lista2.add(coppia);
                }
            }
            case "d" -> {
                double a, b;
                System.out.println("CREAZIONE seconda LISTA DI COPPIE \n");
                System.out.println("Quante coppie vuoi inserire? ");
                dimensione2 = input.nextInt();
                for (int i = 0; i < dimensione2; i++) {
                    System.out.println("Inserisci il primo elemento della coppia: ");
                    a = input.nextDouble();
                    System.out.println("Inserisci il secondo elemento della coppia: ");
                    b = input.nextDouble();
                    Coppie coppia = new Coppie<>(a, b);
                    lista2.add(coppia);
                }
            }
            case "f" -> {
                float c, d;
                System.out.println("CREAZIONE SECONDA LISTA DI COPPIE \n");
                System.out.println("Quante coppie vuoi inserire? ");
                dimensione2 = input.nextInt();
                for (int i = 0; i < dimensione2; i++) {
                    System.out.println("Inserisci il primo elemento della coppia: ");
                    c = input.nextFloat();
                    System.out.println("Inserisci il secondo elemento della coppia: ");
                    d = input.nextFloat();
                    Coppie coppia = new Coppie<>(c, d);
                    lista2.add(coppia);
                }
            }
        }


        if(lista1.get(1).getClass() == lista2.get(1).getClass()){
            for (Coppie coppia : lista2) {
                if (lista1.contains(coppia)) {
                    occorrenze.add(coppia);
                    conteggio ++;
                }
            }
            System.out.println("La lista 1 ha " + conteggio + "elementi in comune con la lista 2 e sono: ");
            for (Coppie coppie : occorrenze) {
                System.out.println(coppie);
            }
        }
        else{
            System.out.println("TIPI NON COMPATIBILI");
        }

    }
}