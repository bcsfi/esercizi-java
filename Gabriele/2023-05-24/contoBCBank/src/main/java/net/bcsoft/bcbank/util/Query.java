package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.enumeration.MeseEnum;
import net.bcsoft.bcbank.enumeration.TipoTransazioneEnum;
import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Query {

    public static List <Transazione> loadTransazioneList(Connection connessione) throws SQLException {
        String query = "SELECT * FROM transazioni";
        ResultSet resultSet = ConnessioneDatabase.ottieniResultSet(connessione, query);
        List <Transazione> listaUscita = new ArrayList<>();
        try {
            while (resultSet.next()){
                Transazione transazione = new Transazione();
                transazione.setIdTransazione(resultSet.getInt(1));
                transazione.setIdRiferimentoContoCorrente(resultSet.getInt(2));
                transazione.setImporto(resultSet.getDouble(3));
                transazione.setData(resultSet.getDate(4).toLocalDate());
                transazione.setOra(resultSet.getTime(5).toLocalTime());
                transazione.setIbanDestinatario(resultSet.getString(6));
                transazione.setTipoTransazione(TipoTransazioneEnum.valueOf(resultSet.getString(7)));
                listaUscita.add(transazione);
            }
        } finally {
            resultSet.close();
        }
       return listaUscita;
    }

    public static List <EstrattoContoMensile> loadEstrattoContoMensileList(Connection connessione) throws SQLException {
        String query = "SELECT * FROM estratto_conto_mensile";
        ResultSet resultSet = ConnessioneDatabase.ottieniResultSet(connessione, query);
        List <EstrattoContoMensile> listaUscita = new ArrayList<>();
        try {
            while (resultSet.next()){
                EstrattoContoMensile estrattoContoMensile = new EstrattoContoMensile();
                estrattoContoMensile.setIdEstrattoConto(resultSet.getInt(1));
                estrattoContoMensile.setIdRiferimentoContoCorrente(resultSet.getInt(2));
                estrattoContoMensile.setAnno(Year.of(resultSet.getInt(3)));
                estrattoContoMensile.setMese(MeseEnum.valueOf(resultSet.getString(4)));
                estrattoContoMensile.setGiacenzaInizioMese(resultSet.getDouble(5));
                listaUscita.add(estrattoContoMensile);
            }
        } finally {
            resultSet.close();
        }
        return listaUscita;
    }
    public static List <ContoCorrente> loadContoCorrenteList(Connection connessione) throws SQLException {
        String query = "SELECT * FROM conto_corrente";
        ResultSet resultSet = ConnessioneDatabase.ottieniResultSet(connessione, query);
        List <ContoCorrente> listaUscita = new ArrayList<>();
        try {
            while (resultSet.next()){
                ContoCorrente contoCorrente = new ContoCorrente();
                contoCorrente.setId(resultSet.getInt(1));
                contoCorrente.setIban(resultSet.getString(2));
                contoCorrente.setNome(resultSet.getString(3));
                contoCorrente.setCognome(resultSet.getString(4));
                contoCorrente.setIndirizzo(resultSet.getString(5));
                contoCorrente.setNumeroTelefono(resultSet.getString(6));
                listaUscita.add(contoCorrente);
            }
        } finally {
            resultSet.close();
        }
        return listaUscita;
    }
}
