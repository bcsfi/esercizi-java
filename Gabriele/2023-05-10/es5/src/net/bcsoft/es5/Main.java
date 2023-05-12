package net.bcsoft.es5;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static void main(String[] args) {
        Map <Studente, Double> pagellaMap = new HashMap<>();
        String nome;
        String cognome;
        Date dataDiNascita = null;
        double voto;
        int scelta;
        String dataStringa;
        Scanner input = new Scanner(System.in);
        boolean controlloMenu = true;
        GestioneMenu gestore = new GestioneMenu(pagellaMap);
        do {
            Studente studente = new Studente();
            System.out.println("CHE AZIONE VUOI EFFETTUARE? \n" +
                    "1) Aggiungere un voto di uno studente; \n" +
                    "2) Aggiornare il voto di uno studente; \n" +
                    "3) Vedere il voto di uno studente; \n" +
                    "4) Rimuovere il voto di uno studente; \n" +
                    "5) Uscire dal menu.\n"
                    ) ;
            scelta = input.nextInt();
            switch (scelta){
                case 1:
                   System.out.println("Inserisci il nome dello studene: ");
                   nome = input.next();
                   studente.setNome(nome);
                   System.out.println("Inserisci il Cognome dello studene: ");
                   cognome = input.next();
                   studente.setCognome(cognome);
                   System.out.println("Inserisci la data di nascita dello studente nel formato gg/mm/yyyy: ");
                   dataStringa = input.next();
                   try {
                       dataDiNascita = DATE_FORMAT.parse(dataStringa);
                   }catch (ParseException e){
                       System.out.println("Formato data non valido.");
                   }
                   studente.setDataDiNascita(dataDiNascita);
                   System.out.println("Inserisci il voto: ");
                   voto = input.nextDouble();
                   gestore.addVoto(studente, voto);
                   break;
                case 2:
                    System.out.println("Inserisci il nome dello studene: ");
                    nome = input.next();
                    System.out.println("Inserisci il nuovo voto: ");
                    voto = input.nextDouble();
                    try {
                        for(Studente stud : pagellaMap.keySet()) {
                            if (Objects.equals(nome, stud.getNome())) {
                                gestore.aggiornaVoto(voto, stud);
                            }
                        }
                    }catch (StudentNotFoundException e){
                        System.out.println("StudentNotFoundException: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Inserisci il nome dello studene: ");
                    nome = input.next();
                    try {
                        for(Studente stud : pagellaMap.keySet()) {
                            if (Objects.equals(nome, stud.getNome())) {
                                gestore.mostraVoto(stud);
                            }
                        }
                    }catch (StudentNotFoundException e){
                    System.out.println("StudentNotFoundException: " + e.getMessage());
                }
                break;
                case 4:
                    System.out.println("Inserisci il nome dello studene: ");
                    nome = input.next();
                    try {
                        for(Studente stud : pagellaMap.keySet()) {
                            if (Objects.equals(nome, stud.getNome())) {
                                gestore.rimuoviVoto(stud);
                            }
                        }
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