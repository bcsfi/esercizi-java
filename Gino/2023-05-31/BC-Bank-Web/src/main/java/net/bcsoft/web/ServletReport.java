package net.bcsoft.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bcsoft.model.ContoCorrente;
import net.bcsoft.model.EstrattoContoMensile;
import net.bcsoft.model.Transazione;
import net.bcsoft.util.GestoreConnessione;
import net.bcsoft.util.Repository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet(name = "Report", urlPatterns = "/report")
public class ServletReport extends HttpServlet
{
    private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

    private List<ContoCorrente> contiCorrente;
    private List<EstrattoContoMensile> estrattiContoMensili;
    private List<Transazione> transazioni;

    public ServletReport() throws SQLException, ClassNotFoundException {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        Connection connection = null;
        try
        {
            connection = GestoreConnessione.creaConnessione();

            contiCorrente = Repository.eseguiQueryContiCorrente(connection);
            estrattiContoMensili = Repository.eseguiQueryEstrattoContoMensile(connection);
            transazioni = Repository.eseguiQueryTransazioni(connection);

            connection.close();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(quantitaTransazioniGiacenzaAttualeGiacenzaMedia());
    }

    private String quantitaTransazioniGiacenzaAttualeGiacenzaMedia()
    {
        String text =
                "<!DOCTYPE html>\n" +
                "   <html>" +
                "       <body>" +
                "           <h2> Report </h2>" +
                "           <table style=\"width:100%\">" +
                "               <tr>" +
                "                   <th> IBAN </th>" +
                "                   <th> Utente </th>" +
                "                   <th> Quantità transioni </th>" +
                "                   <th> Giacenza attuale </th>" +
                "               </tr>";

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

            for (Transazione transazione : transazioni)
            {
                if (contoCorrente.getId() == transazione.getIdContoCorrente())
                {
                    giacenzaAttuale += transazione.getImporto();
                    quantitaTransazioni++;
                }
            }

            text +=
                    "<tr>" +
                    "       <td>" + contoCorrente.getIban() + "</td>" +
                    "       <td>" + contoCorrente.getCognome() + "</td>" +
                    "       <td>" + contoCorrente.getNome() + "</td>" +
                    "       <td>" + quantitaTransazioni + "</td>" +
                    "       <td>" + DECIMAL_FORMAT.format(giacenzaAttuale) + "</td>" +
                    "</tr>";
        }

        return text +
                "       </table> " +
                "   </body> " +
                "</html>";
    }
}
