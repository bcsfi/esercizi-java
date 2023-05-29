package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ReportCreator {
    private String pathFinale;

    private Map<Integer, Double> giacenzaFinaleMap = new HashMap<>();
    private Map<Integer, Integer> aggregaTransazioniMap = new HashMap<>();

    public ReportCreator(String pathFinale) {
        this.pathFinale = pathFinale;
    }

    public Map<Integer, Double> aggregaGiacenze(
            List<EstrattoContoMensile> estrattoContoMensileList, List<Transazione> transazioneList) {

        for (EstrattoContoMensile estrattoContoMensile : estrattoContoMensileList) {
            giacenzaFinaleMap.put(estrattoContoMensile.getIdRiferimentoContoCorrente(),
                    estrattoContoMensile.getGiacenzaInizioMese());
        }

        for (Transazione transazione : transazioneList) {
            if (giacenzaFinaleMap.containsKey(transazione.getIdRiferimentoContoCorrente())) {
                giacenzaFinaleMap.put(transazione.getIdRiferimentoContoCorrente(),
                        giacenzaFinaleMap.get(transazione.getIdRiferimentoContoCorrente()) + transazione.getImporto());
            }
        }
        return giacenzaFinaleMap;
    }

    public Map<Integer, Integer> aggregaTransazioni(List<Transazione> transazioneList) {
        Integer occorrenza = 1;
        for (Transazione transazione : transazioneList) {
            if (aggregaTransazioniMap.containsKey(transazione.getIdRiferimentoContoCorrente())) {
                aggregaTransazioniMap.put(transazione.getIdRiferimentoContoCorrente(), occorrenza + 1);
            } else {
                aggregaTransazioniMap.put(transazione.getIdRiferimentoContoCorrente(), occorrenza);
            }
        }
        return aggregaTransazioniMap;
    }

    public void stampaSuFile(List<ContoCorrente> contoCorrenteList,
                             Map<Integer, Double> mappaGiacenzaFinale,
                             Map<Integer, Integer> mappaTransazioni)
            throws IOException, SQLException, ClassNotFoundException {

        StringBuilder output = new StringBuilder();

        for (ContoCorrente contoCorrente : contoCorrenteList) {
            Integer id = contoCorrente.getId();
            Integer conteggioTransazioni = Optional.ofNullable(mappaTransazioni.get(id)).orElse(0);
            Double conteggioGiacenze = Optional.ofNullable(mappaGiacenzaFinale.get(id)).orElse(0.0);
            output.append("ID UTENTE: " + id + " | " +
                          "NUMERO TRANSAZIONI NEL MESE: " + conteggioTransazioni + " | " +
                          "GIACENZA FINALE " + conteggioGiacenze + "\n");
        }

        FileManager.buildFile(pathFinale, "ReportTransazioni.txt", output.toString());
    }
}
