package org.bcbank.teamplates;

import org.bcbank.model.Risultati;

import java.util.ArrayList;
import java.util.List;

public class HtmlTable {

    public static String createHtmlTable(List<Risultati> elencoRisultati){

        String htmlResult =
                "<html>" +
                "<head>" +
                "<link rel='preconnect' href='https://fonts.googleapis.com'>" +
                "<link href='https://fonts.googleapis.com/css2?family=Geologica:wght@300&display=swap' rel='stylesheet'>" +
                "<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin >" +
                "</head>" +
                "<body style='color: white; background: rgb(2,0,36); background: linear-gradient(180deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 54%, rgba(3,137,164,1) 100%);'>" +
                "<h1 style='margin: 0.5em; color: white; padding: 0.5em; border-radius: 8px; '> Elenco dei risultati </h1>" +
                "<table style=' margin: 1em; padding: 1em; background-color: #1B5891; border-radius: 5px;'>" +
                "<tr style='border: 2px solid grey; font-weight: bold; font-size: 1.3em; text-align: left;'>" +
                "<th style='width: 300px;'> IBAN </th>"   +
                "<th style='width: 300px;'> NUMERO TRANSAZIONI </th>"       +
                "<th style='width: 300px;'> GIACENZA </th>" +
                "</tr>";


        for (Risultati res : elencoRisultati) {
            htmlResult += "<tr>";
                    htmlResult += "<td style=' padding: 0.5em;'>";
                    htmlResult += res.getIban();
                htmlResult += "</td>";
                    htmlResult += ("<td style=' padding: 0.5em;'>");
                    htmlResult += res.getNumero();
                htmlResult += "</td>";
                    htmlResult += "<td style='padding: 0.5em;'>";
                    htmlResult += res.getGiacenza();
                    htmlResult += "</td>";
            htmlResult+= ("</tr>");
        }

        htmlResult += ("<table>");
        htmlResult += ("</body>");
        htmlResult += ("</html>");

        return htmlResult;
    }
}
