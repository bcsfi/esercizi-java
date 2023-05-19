package net.bcsoft;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncassoMensile{

    private StringBuilder totalError = new StringBuilder();
    private Path path = Paths.get("");
    private String directoryCorrente = path.toAbsolutePath().toString() + "\\";
    private ArrayList<Incasso> listaIncassi = new ArrayList<Incasso>();

    public IncassoMensile(String nomeFile) throws IOException {

            Path pathIncassi = Path.of(directoryCorrente + nomeFile);
            Files.exists(pathIncassi);
            List<String> righeFile = Files.readAllLines(pathIncassi);

            for (String linea : righeFile) {
                String[] lineSplit = linea.split(";"); // ha 3 elementi dell'incasso

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
                    } catch (IllegalArgumentException c){
                        totalError.append("Conversione INT non riuscita, controllare il valore della data sia corretto.\n");
                    }
                }
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
