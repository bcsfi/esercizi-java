package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

//TODO: Rendere Giacenze e Transazioni private, creare costruttore che accetta liste
public class ReportCreator {
    private String pathFinale;

    private List<Transazione> transazioneList = new ArrayList<>();
    private List<EstrattoContoMensile> estrattoContoMensileList = new ArrayList<>();
    private List<ContoCorrente> contoCorrenteList = new ArrayList<>();

    public ReportCreator(String pathFinale, List<Transazione> transazioneList, List<EstrattoContoMensile> estrattoContoMensileList,
                         List<ContoCorrente> contoCorrenteList) {
        this.pathFinale = pathFinale;
        this.transazioneList = transazioneList;
        this.estrattoContoMensileList = estrattoContoMensileList;
        this.contoCorrenteList = contoCorrenteList;

    }


    public void stampaSuFile()
            throws IOException, SQLException, ClassNotFoundException {
        StringBuilder output = new StringBuilder();
        MapCreation mapCreation = new MapCreation();
        Map<Integer, Integer> aggregaTransazioniMap = mapCreation.aggregaTransazioni(transazioneList);
        Map<Integer, Double> giacenzaFinaleMap = mapCreation.aggregaGiacenze(estrattoContoMensileList, transazioneList);

        for (ContoCorrente contoCorrente : contoCorrenteList) {
            Integer id = contoCorrente.getId();
            Integer conteggioTransazioni = Optional.ofNullable(aggregaTransazioniMap.get(id)).orElse(0);
            Double conteggioGiacenze = Optional.ofNullable(giacenzaFinaleMap.get(id)).orElse(0.0);
            output.append("ID UTENTE: " + id + " | " +
                          "NUMERO TRANSAZIONI NEL MESE: " + conteggioTransazioni + " | " +
                          "GIACENZA FINALE " + conteggioGiacenze + "\n");
        }

        FileManager.buildFile(pathFinale, "ReportTransazioni.txt", output.toString());
    }
}
