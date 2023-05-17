package net.bcsoft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

public class ReportCreator {
    private IncassoMensile incassoMensile = null;
    private String pathIniziale;
    private Map<ProvinciaEnum, Float> mappaPerProvincia = new HashMap<>();
    private Map<LocalDate, Float> mappaPerData = new HashMap<>();

    public ReportCreator(String pathString) throws IOException {
        try{
            incassoMensile = new IncassoMensile(pathString);
            this.pathIniziale = pathString; //TODO ERRORE QUI FORSE PATH é NULL
        } catch (ProvinciaErrataException e){
                System.out.println("PROVINCIA SBAGLIATA!");
        }
    }

    public void creaMappaPerProvincia() {
        try {
            incassoMensile = new IncassoMensile(pathIniziale);
            List<Incasso> incassoList = incassoMensile.getIncassoList();

            for (int i = 0; i < incassoList.size(); i++) {
                if (!mappaPerProvincia.containsKey(incassoMensile.getIncassoList().get(i).getProvincia())) {
                    mappaPerProvincia.put(incassoMensile.getIncassoList().get(i).getProvincia(), incassoMensile.getIncassoList().get(i).getImporto());
                } else {
                    mappaPerProvincia.put(incassoMensile.getIncassoList().get(i).getProvincia(), mappaPerProvincia.get(incassoMensile.getIncassoList().get(i).getProvincia()) + incassoMensile.getIncassoList().get(i).getImporto());
                }
            }

        } catch (IOException e) {
            System.out.println("ERRORE NELLA LETTURA DEL FILE");
            e.getStackTrace();
        } catch (ProvinciaErrataException e) {
            throw new RuntimeException(e);
        }
    }

    public void creaMappaPerData() {
        try {
            incassoMensile = new IncassoMensile(pathIniziale);
            List<Incasso> incassoList = incassoMensile.getIncassoList();

            for (int i = 0; i < incassoList.size(); i++) {
                if (!mappaPerData.containsKey(incassoMensile.getIncassoList().get(i).getData())) {
                    mappaPerData.put(incassoMensile.getIncassoList().get(i).getData(), incassoMensile.getIncassoList().get(i).getImporto());
                } else {
                    mappaPerData.put(incassoMensile.getIncassoList().get(i).getData(), mappaPerProvincia.get(incassoMensile.getIncassoList().get(i).getData()) + incassoMensile.getIncassoList().get(i).getImporto());
                }
            }

        } catch (IOException e) {
            System.out.println("ERRORE NELLA LETTURA DEL FILE");
            e.getStackTrace();
        } catch (ProvinciaErrataException e) {
            System.out.println("UNA PROVINCIA ERRATA!");
        }
    }

    public void stampaSuFile() throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Inserire il path del file finale per provincia: ");
        String pathFinaleProvincia = input.next();

        Path pathProvincia = Path.of(pathFinaleProvincia);

        Files.createFile(pathProvincia);
        StringBuilder outputProvincia = new StringBuilder();
        for (ProvinciaEnum provincia : mappaPerProvincia.keySet()) {
            Float importo = mappaPerProvincia.get(provincia);
            outputProvincia.append( "Data: " + provincia + " Importo: " + importo + "\n");
        }
        Files.writeString(pathProvincia, outputProvincia);
        System.out.println("Inserire il path del file finale per data: ");
        String pathFinaleData = input.next();

        Path pathData = Path.of(pathFinaleData);

        Files.createFile(pathData);
        StringBuilder outputData = new StringBuilder();
        for (LocalDate data : mappaPerData.keySet()) {
            Float importo = mappaPerData.get(data);
            outputData.append( "Data: " + data + " Importo: " + importo + "\n");
        }
        Files.writeString(pathData, outputData);
    }
}
