package net.bcsoft;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


public class ReportCreator {

    private IncassoMensile incassoMensile = null;

    public ReportCreator(IncassoMensile incassoMensile) {
        this.incassoMensile = incassoMensile;
    }

    public void creaSommaPerPronvica(String nomeOutput){

        Path path = Path.of(nomeOutput);
        ArrayList<Incasso> listaIncassi = incassoMensile.getLista();
        Map<provinciaEnum, Double> mappa = new HashMap<provinciaEnum, Double>();

        for(int b=0; b < listaIncassi.size(); b++){
            try {

            boolean verifica = (mappa.containsKey(listaIncassi.get(b).getProvincia()));

            // lista incassi contiene tutte le instanze
                //

                if (verifica) {

                // dopo aver verificato che la pronvicia sia già presente nella mappa, sommare al vecchio valore preso da mappa il nuovo.
                // prendere il valore all'interno della mappa, sommarlo con quello del ciclo dell'istanza e continuare
                // valore della pronvica


                double nuovoValore = mappa.get(listaIncassi.get(b).getProvincia()) + listaIncassi.get(b).getImport();
                // inserisci nella lista
                mappa.put(listaIncassi.get(b).getProvincia(), nuovoValore);
                // System.out.print("Errore, keyPresente \n");
            } else {
                mappa.put(listaIncassi.get(b).getProvincia(), listaIncassi.get(b).getImport());
                // System.out.print("Somma seguita \n");

            }

            } catch (IllegalArgumentException x){
                System.out.print("Errore, ci sono alcune provincie non valide");
                incassoMensile.getStringError().append("Provincia non valida, perchè non è nella lista delle provincie attendibili. \n");
            }

        }

        try {
            StringBuilder contenuto = new StringBuilder();

            mappa.forEach((provincie, somma) ->{

                contenuto.append(" PROVINCIE: " + provincie + " TOTALE GUADAGNATO PER PROVINCIA " + somma + "\n");
                // System.out.print(" PROVINCIE: " + provincie + " TOTALE GUADAGNATO PER PROVINCIA " + somma + "\n");
            });

            Files.createFile(path);
            Files.writeString(path, contenuto);
        } catch (IOException x){
            System.out.print(x.getMessage());
            incassoMensile.getStringError().append("Errore, il file non è lebbile o scrivibile dalla directory inserita, riprovare. Controllare se i file non esistano già nella directory \n");
        }



    }

    public void creaSommaPerData(String nomeOutput){

        Path path = Path.of(nomeOutput);
        ArrayList<Incasso> listaIncassi = incassoMensile.getLista();
        Map<LocalDate, Double> mappa = new HashMap<LocalDate, Double>();

        for(int b=0; b < listaIncassi.size(); b++){

            // lista incassi contiene tutte le instanze
            if(mappa.containsKey(listaIncassi.get(b).getData())){
                // dopo aver verificato che la pronvicia sia già presente nella mappa, sommare al vecchio valore preso da mappa il nuovo.
                // prendere il valore all'interno della mappa, sommarlo con quello del ciclo dell'istanza e continuare
                // valore della pronvica                        // valore dell'instanza
                double nuovoValore = mappa.get(listaIncassi.get(b).getData()) + listaIncassi.get(b).getImport();
                // inserisci nella lista
                mappa.put(listaIncassi.get(b).getData(), nuovoValore);
                // System.out.print("Errore, keyPresente \n");

            } else {
                mappa.put(listaIncassi.get(b).getData(), listaIncassi.get(b).getImport());
                // System.out.print("Somma seguita \n");

            }

        }

        try {
            StringBuilder contenuto = new StringBuilder();

            mappa.forEach((data, somma) ->{

                contenuto.append(" DATA: " + data + " TOTALE GUADAGNATO PER PROVINCIA " + somma + "\n");
                // System.out.print(" DATA: " + data + " TOTALE GUADAGNATO PER PROVINCIA " + somma + "\n");
            });

            Files.createFile(path);
            Files.writeString(path, contenuto);
        } catch (IOException x){
            System.out.print(x.getMessage());
            incassoMensile.getStringError().append("Errore, il file non è lebbile o scrivibile dalla directory inserita, riprovare. Controllare se i file non esistano già nella directory.\n");
        }

    }

    public void createLogs(String nomeOutput){
        try {
            Path path = Path.of(nomeOutput);
            if(Files.exists(path)){
                Files.delete(path);
            }

            Files.createFile(path);
            Files.writeString(path, incassoMensile.getStringError());

            } catch (IOException x){
            incassoMensile.getStringError().append("Errore, il file non è leggibile o scrivibile.");
        }


    }


}
