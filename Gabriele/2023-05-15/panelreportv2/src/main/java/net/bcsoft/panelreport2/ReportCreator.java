package net.bcsoft.panelreport2;

import net.bcsoft.panelreport2.Exception.LetturaFileException;
import net.bcsoft.panelreport2.Exception.ProvinciaErrataException;
import net.bcsoft.panelreport2.Exception.StampaSuFileException;

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

    public ReportCreator(String pathString) throws ProvinciaErrataException, LetturaFileException {
        this.pathIniziale = pathString;
        try {
            incassoMensile = new IncassoMensile(pathString);
        } catch (LetturaFileException e) {
            throw new LetturaFileException();
        }
    }

    public void creaMappaPerProvincia() throws ProvinciaErrataException {
        try {
            incassoMensile = new IncassoMensile(pathIniziale);
            List<Incasso> incassoList = incassoMensile.getIncassoList();

            for (int i = 0; i < incassoList.size(); i++) {
                if (!mappaPerProvincia.containsKey(incassoMensile.getIncassoList().get(i).getProvincia())) {
                    mappaPerProvincia.put(incassoMensile.getIncassoList().get(i).getProvincia(),
                            incassoMensile.getIncassoList().get(i).getImporto());
                } else {
                    mappaPerProvincia.put(incassoMensile.getIncassoList().get(i).getProvincia(),
                            mappaPerProvincia.get(incassoMensile.getIncassoList().get(i).getProvincia()) +
                                    incassoMensile.getIncassoList().get(i).getImporto());
                }
            }

        } catch (IOException e) {
            System.out.println("ERRORE NELLA LETTURA DEL FILE");
        }
    }

    public void creaMappaPerData() throws ProvinciaErrataException, LetturaFileException {
        try {
            incassoMensile = new IncassoMensile(pathIniziale);
            List<Incasso> incassoList = incassoMensile.getIncassoList();

            for (int i = 0; i < incassoList.size(); i++) {
                if (!mappaPerData.containsKey(incassoMensile.getIncassoList().get(i).getData())) {
                    mappaPerData.put(incassoMensile.getIncassoList().get(i).getData(),
                            incassoMensile.getIncassoList().get(i).getImporto());
                } else {
                    mappaPerData.put(incassoMensile.getIncassoList().get(i).getData(),
                            mappaPerProvincia.get(incassoMensile.getIncassoList().get(i).getData()) +
                                    incassoMensile.getIncassoList().get(i).getImporto());
                }
            }

        } catch (IOException e) {
            throw new LetturaFileException();
        }
    }

    public void stampaSuFile() throws StampaSuFileException {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserire il path dove creare i file: ");
        String folderFinale = input.next();

        try {
            Path pathProvincia = Path.of(folderFinale + "Provincia.txt");
            Files.createFile(pathProvincia);
            StringBuilder outputProvincia = new StringBuilder();
            for (ProvinciaEnum provincia : mappaPerProvincia.keySet()) {
                Float importo = mappaPerProvincia.get(provincia);
                outputProvincia.append("Provincia: " + provincia + " Importo: " + importo + "\n");
            }
            Files.writeString(pathProvincia, outputProvincia);

            Path pathData = Path.of(folderFinale + "Data.txt");
            Files.createFile(pathData);
            StringBuilder outputData = new StringBuilder();
            for (LocalDate data : mappaPerData.keySet()) {
                Float importo = mappaPerData.get(data);
                outputData.append("Data: " + data + " Importo: " + importo + "\n");
            }
            Files.writeString(pathData, outputData);

        } catch (IOException e) {
            throw new StampaSuFileException();
        }
    }
}
