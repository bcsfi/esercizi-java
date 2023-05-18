package net.bcsoft;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IncassoMensile{

    StringBuilder totalError = new StringBuilder();


    Path path = Paths.get("");
    String directoryCorrente = path.toAbsolutePath().toString() + "//src//main//resources//";


    ArrayList<Incasso> listaIncassi = new ArrayList<Incasso>();

    public IncassoMensile(String nomeFile) {

        try {

            FileReader filedaLeggere = new FileReader(directoryCorrente + nomeFile);
            BufferedReader resocontoLetto = new BufferedReader(filedaLeggere);

            String line;
            while((line = resocontoLetto.readLine()) != null)
            {

                String[] lineSplit = line.split(";"); // ha 3 elementi dell'incasso

                for(int i=1; i < lineSplit.length-1; i++) {

                    String[] lineSplitDate = lineSplit[0].split("/"); // ha 3 elementi della data;

                    try {

                        int anno = Integer.parseInt(lineSplitDate[2]);
                        int mese = Integer.parseInt(lineSplitDate[1]);
                        int giorno = Integer.parseInt(lineSplitDate[0]);

                        try {
                            LocalDate data = LocalDate.of(anno, mese, giorno);

                            try {
                                provinciaEnum provincia = provinciaEnum.valueOf(lineSplit[i]);

                                try {

                                    int importo = Integer.parseInt(lineSplit[i + 1]);
                                    Incasso lineUno = new Incasso(data, provincia, importo);
                                    listaIncassi.add(lineUno);

                                } catch (IllegalArgumentException x){
                                    totalError.append("Errore, data non attendibile. Controlla se il formato dell'importa sia sempre corretto.\n");
                                }

                            } catch (IllegalArgumentException x){
                                totalError.append("Errore, data non attendibile. Controlla se il formato dalla PROVINCIA sia sempre corretto.\n");
                            }

                        } catch (DateTimeException x){
                            totalError.append("Errore, data non attendibile. Controlla se il formato delle date sia sempre corretto.\n");
                        }




                        // System.out.print("PRVINCIA: " + lineSplit[i + 1] + "\n");

                        // System.out.print("IMPORTO: " + lineSplit[i + 2] + "\n");

                        // System.out.print("Oggetto;" + data + provincia + importo + "\n");


                    } catch (IllegalArgumentException c){
                        totalError.append("Conversione INT non riuscita, controllare il valore della data sia corretto.\n");
                    }

                }
            }

            resocontoLetto.close();

        } catch (IOException d){
            System.out.print(d.getMessage());

        }
        // System.out.print("Tutti gli oggetti sono stati istanziati.");
    }

    public ArrayList<Incasso> getLista(){
        return this.listaIncassi;
    }

    public StringBuilder getStringError(){
        return this.totalError;
    }

}
