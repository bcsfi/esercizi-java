package net.bcsoft.es1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dimensioneLista1, dimensioneLista2;
        String sceltaTipoArray;
        List <Integer> numeri1 = new ArrayList<Integer>();
        List <Integer> numeri2 = new ArrayList<Integer>();
        List <Integer> listaOccorrenze = new ArrayList<Integer>();
        Set<Integer> setOccorrenze = new HashSet<>();
        GestioneLista gestoreLista1 = new GestioneLista(numeri1);
        GestioneLista gestoreLista2 = new GestioneLista(numeri2);
        GestioneLista gestoreListaOccorrenze = new GestioneLista(listaOccorrenze);
        GestioneSet gestoreSet = new GestioneSet(setOccorrenze);

        System.out.println("Di che tipo vuoi creare gli array: \n" +
                "Per l'int premi i \n" +
                "Per il double premi d \n" +
                "Per il float premi f \n"
                );
        sceltaTipoArray = input.next();


        System.out.println("CREAZIONE PRIMA LISTA \n" );
        System.out.println("Quanti numeri vuoi inserire nella prima lista? ");
        dimensioneLista1 = input.nextInt();
        gestoreLista1.creazioneLista(numeri1, dimensioneLista1, input, sceltaTipoArray);

        System.out.println("CREAZIONE SECONDA LISTA \n");
        System.out.println("Quanti numeri vuoi inserire nella seconda lista? ");
        dimensioneLista2 = input.nextInt();
        gestoreLista2.creazioneLista(numeri1, dimensioneLista2, input, sceltaTipoArray);

        for (Integer item : numeri2) {
            if (numeri1.contains(item)) {
                listaOccorrenze.add(item);
                setOccorrenze.add(item);
            }
        }

        System.out.println(" Con lista occorrenze. Lista 1 contiene " + listaOccorrenze.size() + " elementi di lista 2: ");
        gestoreListaOccorrenze.stampaLista(listaOccorrenze);

        System.out.println(" Con set occorrenze. Lista 1 contiene " + setOccorrenze.size() + " elementi di lista 2: " );
        gestoreSet.stampaSet(setOccorrenze);

    }
}