package org.example.Annotation;

import org.example.POJO.ContoCorrente;
import org.example.POJO.Transazione;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransitionList {

    ArrayList<Transazione> listaTransazioni = new ArrayList<Transazione>();


    private int id_transizione;
    private double import_transazione;
    private String iban_destinatario;
    private LocalDate data_transizione;
    // chiave primaria di Utente
    private int id_cc;


    public ArrayList<Transazione> CreateTransitionList(ResultSet resultQuery) throws SQLException {
        while(resultQuery.next()){

            String data_transazione = resultQuery.getString(4);
            LocalDate dataTransazioneConvertita = LocalDate.parse(data_transazione);


            Transazione transazione = new Transazione(
                    resultQuery.getInt(1),
                    resultQuery.getDouble(2), resultQuery.getString(3),
                    dataTransazioneConvertita, resultQuery.getInt(5)
            );

            listaTransazioni.add(transazione);
        }
        return listaTransazioni;

    }

}
