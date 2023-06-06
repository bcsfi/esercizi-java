package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Focaccia;
import util.GestoreConnessione;
import util.Repository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "ReportFocacce", urlPatterns = "/focacce")
public class ServletFocacce extends HttpServlet
{
    public ServletFocacce(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        List<Focaccia> focacce = null;
        try
        {
            Connection connessione = GestoreConnessione.creaConnessione();
            focacce = Repository.eseguiQueryFocacce(connessione);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        String text = "";

        if (focacce.isEmpty())
        {
            text += "Non ci sono risultati da mostrare";
        }
        else
        {
            text +=
                            "<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "    <title>Servlet Focacce</title>\n" +
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
                            "        .passa-focacce {\n" +
                            "            margin-top: 40px;\n" +
                            "            font-size: 18px;\n" +
                            "            color: #FFF;\n" +
                            "        }\n" +
                            "\n" +
                            "        .passa-focacce a {\n" +
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
                            "    <h1>Focacce</h1>\n" +
                            "    <table>\n" +
                            "        <thead>\n" +
                            "            <tr>\n" +
                            "                <th>Nome</th>\n" +
                            "                <th>Quantità</th>\n" +
                            "            </tr>\n" +
                            "        </thead>\n" +
                            "        <tbody>";

            for (Focaccia focaccia : focacce)
            {
                text +=
                            "            <tr>\n" +
                            "                <td>" + focaccia.getNome() + "</td>\n" +
                            "                <td>" + focaccia.getQuantita() + "</td>\n" +
                            "            </tr>";
            }

            text +=
                            "       </tbody>\n" +
                            "    </table>\n" +
                            "    <div class=\"passa-focacce\">\n" +
                            "        <p>Passa a Incassi</p>\n" +
                            "        <a href=http://localhost:8080/bcvinaino/incassi>Vai</a>\n" +
                            "    </div>\n" +
                            "</body>\n" +
                            "</html>";
        }

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(text);
    }
}