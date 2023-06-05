package net.bcsoft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class GestoreEsercizio
{
    private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

    private List<ContoCorrente> contiCorrente;
    private List<EstrattoContoMensile> estrattiContoMensili;
    private List<Transazione> transazioni;

    public GestoreEsercizio() throws SQLException, ClassNotFoundException
    {
        Connection connection = GestoreConnessione.creaConnessione();

        contiCorrente = Repository.eseguiQueryContiCorrente(connection);
        estrattiContoMensili = Repository.eseguiQueryEstrattoContoMensile(connection);
        transazioni = Repository.eseguiQueryTransazioni(connection);

        connection.close();

        String risultato = quantitaTransazioniGiacenzaAttualeGiacenzaMedia(); // AKA Esercizio 1
        System.out.println(risultato);
    }

    // Tentativo di funzione generica eseguiQuesry
    /*public <T> List<T> eseguiQuery(String query)
    {
        ResultSet resultSet = LetturaScritturaDB.inviaQuery(query);
        List<T> risultati = new ArrayList<>();
        int numColonne = 0;

        try
        {
            numColonne = resultSet.getMetaData().getColumnCount();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        List<T> riga;

        while (true)
        {
            try
            {
                if (!resultSet.next()) break;
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }

            riga = new ArrayList<>();

            for (int i = 1; i <= numColonne; i++)
            {
                try
                {
                    riga.add((T) resultSet.getObject(i));
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }

            risultati.add((T) riga);
        }

        return risultati;
    }
    */

    private String quantitaTransazioniGiacenzaAttualeGiacenzaMedia()
    {
        String text = "";
        int quantitaTransazioni;
        double giacenzaAttuale = 0D;

        for (ContoCorrente contoCorrente : contiCorrente)
        {
            quantitaTransazioni = 0;

            for (EstrattoContoMensile estrattoContoMensile : estrattiContoMensili)
            {
                if (contoCorrente.getId() == estrattoContoMensile.getIdContoCorrente())
                {
                    giacenzaAttuale = estrattoContoMensile.getGiacenzaInizioMese();
                    break;
                }

            }
            System.out.println("ciao");
            for (Transazione transazione : transazioni)
            {
                if (contoCorrente.getId() == transazione.getIdContoCorrente())
                {
                    giacenzaAttuale += transazione.getImporto();
                    quantitaTransazioni++;
                }
            }
            System.out.println("ciao");
            text += contoCorrente.getIban() + " " + contoCorrente.getCognome() + " " + contoCorrente.getNome() + " | Ha effettuato: " + quantitaTransazioni + " transazioni | La giacenza attuale e' di: " + DECIMAL_FORMAT.format(giacenzaAttuale) + "\n";
        }

        return text;
    }
}