package net.bcsoft.es1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestioneLista {
    private List<Integer> lista = new ArrayList<>();

    public GestioneLista(List<Integer> lista){
        this.lista = lista;
    }

    public void stampaLista(List<Integer> lista){
        for (Integer integer : lista) {
            System.out.println(integer);
        }
    }
    public void creazioneLista(List <Integer> lista, int dimensione, Scanner input, String scelta) {
        int aggiunta;
        for (int i = 0; i < dimensione; i++) {
            System.out.println("Inserisci il numero da aggiungere: ");
            aggiunta = input.nextInt();
            lista.add(aggiunta);

        }
    }
}
