package net.bcsoft.Function;

import net.bcsoft.DataObject.Incasso;
import net.bcsoft.Enum.provinciaEnum;
import net.bcsoft.Function.RaccoltaIncassi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;


public class ReportCreator {

    private RaccoltaIncassi raccoltaIncassi = null;

    public ReportCreator(RaccoltaIncassi raccoltaIncassi) throws SQLException, ClassNotFoundException {
        this.raccoltaIncassi = raccoltaIncassi;
    }

    public void creaSommaPerPronvica(String nomeOutput) throws IOException{

        Path path = Path.of(nomeOutput);
        ArrayList<Incasso> listaIncassi = raccoltaIncassi.getLista();
        Map<provinciaEnum, Double> mappa = new HashMap<provinciaEnum, Double>();

        for(int b=0; b < listaIncassi.size(); b++){

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

        }


            StringBuilder contenuto = new StringBuilder();
            contenuto.append("DATA        |       GUADAGNO");

            mappa.forEach((provincie, somma) ->{

                contenuto.append("**  " + provincie + "     |    " + somma + "\n");
                // System.out.print(" PROVINCIE: " + provincie + " TOTALE GUADAGNATO PER PROVINCIA " + somma + "\n");
            });

            Files.createFile(path);
            Files.writeString(path, contenuto);



    }

    public void creaSommaPerData(String nomeOutput) throws IOException{

        Path path = Path.of(nomeOutput);
        ArrayList<Incasso> listaIncassi = raccoltaIncassi.getLista();
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

            StringBuilder contenuto = new StringBuilder();

            contenuto.append("DATA        |       GUADAGNO");
            mappa.forEach((data, somma) ->{

                contenuto.append("**  " + data + "     |    " + somma + "\n");
                // System.out.print(" DATA: " + data + " TOTALE GUADAGNATO PER PROVINCIA " + somma + "\n");
            });

            Files.createFile(path);
            Files.writeString(path, contenuto);


    }



}
