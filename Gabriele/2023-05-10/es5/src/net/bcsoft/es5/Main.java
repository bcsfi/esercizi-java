package net.bcsoft.es5;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map <String, Double> pagellaMap = new HashMap<>();
        String nome;
        double voto;
        int scelta;
        Scanner input = new Scanner(System.in);
        boolean controlloMenu = true;
        GestioneMenu gestore = new GestioneMenu();
        do {
            System.out.println("CHE AZIONE VUOI EFFETTUARE? \n" +
                    "1) Aggiungere un voto di uno studente; \n" +
                    "2) Aggiornare il voto di uno studente; \n" +
                    "3) Vedere il voto di uno studente; \n" +
                    "4) Rimuovere il voto di uno studente; \n" +
                    "5) Uscire dal menu\n"
                    ) ;
            scelta = input.nextInt();

            switch (scelta){
                case 1:
                   System.out.println("Inserisci il nome dello studene: ");
                   nome = input.next();
                   System.out.println("Inserisci il voto: ");
                   voto = input.nextDouble();
                   gestore.addVoto(nome, voto, pagellaMap);
                   break;
                case 2:
                    System.out.println("Inserisci il nome dello studene: ");
                    nome = input.next();
                    System.out.println("Inserisci il nuovo voto: ");
                    voto = input.nextDouble();
                    try {
                        gestore.aggiornaVoto(nome, voto, pagellaMap);
                    }catch (StudentNotFoundException e){
                        System.out.println("StudentNotFoundException: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Inserisci il nome dello studene: ");
                    nome = input.next();
                    try {
                        gestore.mostraVoto(nome, pagellaMap);
                    }catch (StudentNotFoundException e){
                    System.out.println("StudentNotFoundException: " + e.getMessage());
                }
                break;
                case 4:
                    System.out.println("Inserisci il nome dello studene: ");
                    nome = input.next();
                    try {
                        gestore.rimuoviVoto(nome, pagellaMap);
                    }catch (StudentNotFoundException e){
                        System.out.println("StudentNotFoundException: " + e.getMessage());
                    }
                    break;
                case 5:
                    controlloMenu = false;
            }
        }while(controlloMenu);
    }




}