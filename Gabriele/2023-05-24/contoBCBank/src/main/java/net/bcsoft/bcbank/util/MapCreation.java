package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapCreation {
    private Map<Integer, Integer> aggregaTransazioniMap = new HashMap<>();
    private Map<Integer, Double> giacenzaFinaleMap = new HashMap<>();

    public MapCreation(Map<Integer, Integer> aggregaTransazioniMap, Map<Integer, Double> giacenzaFinaleMap){

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
}
