package net.bcsoft.bcbank;

import net.bcsoft.bcbank.enumeration.TipoTransazioneEnum;
import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;
import net.bcsoft.bcbank.util.ConnessioneDatabase;
import net.bcsoft.bcbank.util.Query;
import net.bcsoft.bcbank.util.ReportCreator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserire il path dove salvare i file: ");
        String pathFinale = input.next();
        try {
            Connection connection = ConnessioneDatabase.createConnection();

            List<Transazione> transazioneList = Query.loadTransazioneList(connection);
            List<EstrattoContoMensile> estrattoContoMensileList = Query.loadEstrattoContoMensileList(connection);
            List<ContoCorrente> contoCorrenteList = Query.loadContoCorrenteList(connection);

            ReportCreator reportCreator = new ReportCreator(pathFinale);
            Map <Integer, Integer> transazioneMap = reportCreator.aggregaTransazioni(transazioneList);
            Map <Integer, Double> giacenzaMap = reportCreator.aggregaGiacenze(estrattoContoMensileList, transazioneList);
            reportCreator.stampaSuFile(contoCorrenteList, giacenzaMap, transazioneMap);
            connection.close();
        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE PATH INSERITO | " + e.getMessage());
            //} catch (SQLException e) {
            //  System.out.println("ERRORE DATABASE | " + e.getMessage());
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } //TODO aggiungere il finally e spostarci riga 35 (il close connection)
    }
}