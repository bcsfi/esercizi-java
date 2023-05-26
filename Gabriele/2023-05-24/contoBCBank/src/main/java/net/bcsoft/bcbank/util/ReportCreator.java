package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReportCreator {
    private String pathFinale;

    private Map <Integer, Double> giacenzaFinaleMap = new HashMap<>();
    private Map <Integer, Integer> aggregaTransazioniMap = new HashMap<>();
    public ReportCreator(String pathFinale){
        this.pathFinale = pathFinale;
    }


    public void caricaDati(ArrayList <Transazione> transazioneList, ArrayList <EstrattoContoMensile> estrattoContoMensileList) throws SQLException, ClassNotFoundException {
        Connection connessione = ConnessioneDatabase.createConnection();
        transazioneList = Query.loadTransazioneList(transazioneList, connessione);
        estrattoContoMensileList = Query.loadEstrattoContoMensileList(estrattoContoMensileList, connessione);
        List <ContoCorrente> contoCorrenteList = Query.loadContoCorrenteList(connessione);
        connessione.close();
    }

    public Map <Integer, Double> aggregaGiacenze(ArrayList <EstrattoContoMensile> estrattoContoMensileList, ArrayList <Transazione> transazioneList){
        for(EstrattoContoMensile estrattoContoMensile : estrattoContoMensileList){
            giacenzaFinaleMap.put(estrattoContoMensile.getIdRiferimentoContoCorrente(), estrattoContoMensile.getGiacenzaInizioMese());
        }

        for (Transazione transazione: transazioneList) {
            if (giacenzaFinaleMap.containsKey(transazione.getIdRiferimentoContoCorrente())) {
                giacenzaFinaleMap.put(transazione.getIdRiferimentoContoCorrente(), giacenzaFinaleMap.get(giacenzaFinaleMap.get(transazione)) + transazione.getImporto());
            }
        }
        return giacenzaFinaleMap;
    }
    public Map <Integer, Integer> aggregaTransazioni(List <Transazione> transazioneList){
        Integer occorrenza = 1;
        for(Transazione transazione: transazioneList){
            if(aggregaTransazioniMap.containsKey(transazione.getIdRiferimentoContoCorrente())){
                aggregaTransazioniMap.put(transazione.getIdRiferimentoContoCorrente(), occorrenza);
            }
            else{
                aggregaTransazioniMap.put(transazione.getIdRiferimentoContoCorrente(), occorrenza + 1);
            }
        }
        return aggregaTransazioniMap;
    }
    public void stampaSuFile(Map <Integer, Double> mappaGiacenzaFinale, Map <Integer, Integer> mappaTransazioni ) throws IOException, SQLException, ClassNotFoundException {
        StringBuilder output = new StringBuilder();
        for (Integer id : mappaTransazioni.keySet()) {
            Integer conteggio = mappaTransazioni.get(id);
            output.append("IBAN: " + id + " Numero Transazioni: " + conteggio + "\n");
        }
        for (Integer id : mappaGiacenzaFinale.keySet()) {
            Double conteggio = mappaGiacenzaFinale.get(id);
            output.append("ID UTENTE: " + id + " giacenza finale: " + conteggio + "\n");
        }

        FileManager.buildFile(pathFinale, "ReportTransazioni.txt", output.toString());
    }
}
