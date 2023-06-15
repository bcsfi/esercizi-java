package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ordine;
import util.GestoreConnessione;
import util.Repository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "ReportOrdini", urlPatterns = "/ordini")
public class ServletOrdini extends HttpServlet
{
    public ServletOrdini() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        List<Ordine> ordini = null;
        try
        {
            Connection connessione = GestoreConnessione.creaConnessione();
            ordini = Repository.eseguiQueryOrdini(connessione);
        }
        catch (SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        String text = "";

        if (ordini.isEmpty())
        {
            text += "Non ci sono risultati da mostrare";
        }
        else
        {
            text +=
                    "<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "    <title>Servlet Ordini</title>\n" +
                            "    <style>\n" +
                            "        body {\n" +
                            "            font-family: Arial, sans-serif;\n" +
                            "            background-color: #333;\n" +
                            "            color: #FFF;\n" +
                            "            margin: 0;\n" +
                            "            padding: 20px;\n" +
                            "            text-align: center;\n" +
                            "        }\n" +
                            "\n" +
                            "        h1 {\n" +
                            "            font-size: 28px;\n" +
                            "            margin-bottom: 30px;\n" +
                            "        }\n" +
                            "\n" +
                            "        table {\n" +
                            "            width: 100%;\n" +
                            "            max-width: 800px;\n" +
                            "            margin: 20px auto;\n" +
                            "            border-collapse: collapse;\n" +
                            "            border-radius: 10px;\n" +
                            "            overflow: hidden;\n" +
                            "            background-color: #444;\n" +
                            "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);\n" +
                            "        }\n" +
                            "\n" +
                            "        th, td {\n" +
                            "            padding: 15px;\n" +
                            "            text-align: center;\n" +
                            "        }\n" +
                            "\n" +
                            "        th {\n" +
                            "            background-color: #000;\n" +
                            "            color: #2ecc71;\n" +
                            "        }\n" +
                            "\n" +
                            "        td {\n" +
                            "            color: #FFF;\n" +
                            "        }\n" +
                            "\n" +
                            "        .passa-ordini {\n" +
                            "            margin-top: 40px;\n" +
                            "            font-size: 18px;\n" +
                            "            color: #FFF;\n" +
                            "        }\n" +
                            "\n" +
                            "        .passa-ordini a {\n" +
                            "            display: inline-block;\n" +
                            "            margin-top: 10px;\n" +
                            "            padding: 12px 24px;\n" +
                            "            background-color: #2ecc71;\n" +
                            "            color: #FFF;\n" +
                            "            text-decoration: none;\n" +
                            "            border-radius: 30px;\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <h1>Ordini</h1>\n" +
                            "    <table>\n" +
                            "        <thead>\n" +
                            "            <tr>\n" +
                            "                <th>ID</th>\n" +
                            "                <th>Data</th>\n" +
                            "                <th>Importo</th>\n" +
                            "            </tr>\n" +
                            "        </thead>\n" +
                            "        <tbody>";

            for (Ordine ordine : ordini)
            {
                text +=
                            "           <tr>\n" +
                            "                <td>" + ordine.getIdOrdine() + "</td>\n" +
                            "                <td>" + ordine.getData().getMonth() + " / " + ordine.getData().getDay() + "</td>\n" +
                            "                <td>" + ordine.getImportoTotale() + "</td>\n" +
                            "           </tr>";
            }

            text +=
                    "       </tbody>\n" +
                            "    </table>\n" +
                            "    <div class=\"passa-ordini\">\n" +
                            "        <a href=http://localhost:8080/bcvinaino/incassi>Passa a Incassi</a>\n" +
                            "    </div>\n" +
                            "</body>\n" +
                            "</html>";
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(text);
    }
}
