package net.bcsoft.bcbank.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;


public class ReportCreator {
    private String pathFinale;
    private Map <String, Integer> mappaTransazioni = null;

    public ReportCreator(String pathFinale){
        this.pathFinale = pathFinale;
    }
    public void stampaSuFile() throws IOException, SQLException, ClassNotFoundException {
        Connection connessione = ConnessioneDatabase.createConnection();
        GestioneQuery gestioneQuery = new GestioneQuery(connessione);
        CalcoloGiacenzaFinale calcoloGiacenzaFinale = new CalcoloGiacenzaFinale();
        Map <Integer, Double> mappaGiacenzaFinale = calcoloGiacenzaFinale.elaboraDati();
        mappaTransazioni = gestioneQuery.contaTransazioni();
        StringBuilder output = new StringBuilder();
        for (String iban : mappaTransazioni.keySet()) {
            Integer conteggio = mappaTransazioni.get(iban);
            output.append("IBAN: " + iban + " Numero Transazioni: " + conteggio + "\n");
        }
        for (Integer id : mappaGiacenzaFinale.keySet()) {
            Double conteggio = mappaGiacenzaFinale.get(id);
            output.append("ID UTENTE: " + id + " giacenza finale: " + conteggio + "\n");
        }

        FileManager.buildFile(pathFinale, "ReportTransazioni.txt", output.toString());
    }

}
