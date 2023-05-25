package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcoloGiacenzaFinale {

    private List<Transazione> transazioneList = new ArrayList<>();
    private List <EstrattoContoMensile> estrattoContoMensileList = new ArrayList<>();
    private Map <Integer, Double> giacenzaFinaleMap = new HashMap<>();


    public Map <Integer, Double> elaboraDati(){
        for(EstrattoContoMensile estrattoContoMensile : estrattoContoMensileList){
            giacenzaFinaleMap.put(estrattoContoMensile.getIdRiferimentoContoCorrente(), estrattoContoMensile.getGiacenzaInizioMese());
        }

        for (Transazione transazione: transazioneList) {
            if (giacenzaFinaleMap.containsKey(transazione.getIdRiferimentoContoCorrente())) {
                giacenzaFinaleMap.put(transazione.getIdRiferimentoContoCorrente(), giacenzaFinaleMap.get(transazione.getImporto()) + transazione.getImporto());
            }
        }
        return giacenzaFinaleMap;
    }
}
