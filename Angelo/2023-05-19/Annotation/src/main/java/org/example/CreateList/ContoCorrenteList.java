package org.example.Annotation;

import org.example.POJO.ContoCorrente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContoCorrenteList {

    ArrayList<ContoCorrente> listaUtenti = new ArrayList<ContoCorrente>();

    private int id_cc;
    private String iban;
    private String nome_utente;
    private String cognome_utente;
    private String indirizzo_utente;
    private int n_telefono_utente; // bigInt;
    private int anno_ec_mensile;
    private int mese_ec_mensile;
    private double giacenza_mensile;


    public ArrayList<ContoCorrente> CreateUserList(ResultSet resultQuery) throws SQLException {
        while (resultQuery.next()){

            ContoCorrente contoCorrente = new ContoCorrente(
              resultQuery.getInt(1), resultQuery.getString(2), resultQuery.getString(3), resultQuery.getString(4),
                    resultQuery.getString(5), resultQuery.getBigDecimal(6), resultQuery.getInt(7), resultQuery.getInt(8),
                    resultQuery.getDouble(9)
            );

            listaUtenti.add(contoCorrente);
        }
        return listaUtenti;
    }

}
