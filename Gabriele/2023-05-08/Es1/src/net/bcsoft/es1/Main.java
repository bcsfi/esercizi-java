package net.bcsoft.es1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dimensioneLista1, dimensioneLista2;
        int aggiunta;
        List <Integer> numeri1 = new ArrayList<Integer>();
        List <Integer> numeri2 = new ArrayList<Integer>();
        List <Integer> listaOccorrenze = new ArrayList<Integer>();
        Set<Integer> setOccorrenze = new HashSet<>();

        System.out.println("CREAZIONE PRIMA LISTA \n" );
        System.out.println("Quanti numeri vuoi inserire nella prima lista? ");
        dimensioneLista1 = input.nextInt();
        for (int i = 0; i < dimensioneLista1; i++){
            System.out.println("Inserisci il numero da aggiungere: ");
            aggiunta = input.nextInt();
            numeri1.add(aggiunta);
        }

        System.out.println("CREAZIONE SECONDA LISTA \n");
        System.out.println("Quanti numeri vuoi inserire nella seconda lista? ");
        dimensioneLista2 = input.nextInt();
        for (int i = 0; i < dimensioneLista2; i++){
            System.out.println("Inserisci il numero da aggiungere: ");
            aggiunta = input.nextInt();
            numeri2.add(aggiunta);
        }
        /*
        for (int i = 0; i < dimensioneLista1; i++){
            for (int j = 0; j < dimensioneLista2; j++){
                if (Objects.equals(numeri1.get(i), numeri2.get(j))){
                    occorrenze.add(numeri1.get(i));
                    contatore++;
                }
            }
        }

        for(int i = 0; i < dimensioneLista2; i++){
            if(numeri1.contains(numeri2.get(i))){
                occorrenze.add(numeri1.get(i));
                contatore++;
            }
        }
          */
        for (Integer item : numeri2) {
            if (numeri1.contains(item)) {
                listaOccorrenze.add(item);
                setOccorrenze.add(item);
            }
        }
        System.out.println(" Con lista occorrenze. Lista1 contiene " + listaOccorrenze.size() + " elementi di lista 2: ");
        for (Integer integer : listaOccorrenze) {
            System.out.println(integer + "\n");
        }
        System.out.println(" Con set occorrenze. Lista1 contiene " + setOccorrenze.size() + " elementi di lista 2: ");
        for (Integer integer : setOccorrenze) {
            System.out.println(integer + "\n");
        }
    }
}