package org.BCVinaiano.model;
import java.util.List;

public class HtmlTable {


    public static <E> String createHtmlTable(List<E> lista){

        String htmlResult =
                "<html>" +
                        "<head>" +
                        "<link rel='preconnect' href='https://fonts.googleapis.com'>" +
                        "<link href='https://fonts.googleapis.com/css2?family=Geologica:wght@300&display=swap' rel='stylesheet'>" +
                        "<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin >" +
                        "</head>" +
                        "<body style='color: white; background: rgb(2,0,36); background: linear-gradient(180deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 54%, rgba(3,137,164,1) 100%);'>" +
                        "<h1 style='margin: 0.5em; color: white; padding: 0.5em; border-radius: 8px; display:inline-block; '> Elenco dei risultati </h1>" +
                        "<a style='padding: 1em; border-radius: 8px; color:black;font-weight:bold; background-color: white; display: inline-block;' href='http://localhost:8080/java/home.html' '> Torna alla home </a>" +
                        "<table style=' margin: 1em; padding: 1em; background-color: #1B5891; border-radius: 5px;'>" +
                        "<tr style='border: 2px solid grey; font-weight: bold; font-size: 1.3em; text-align: left;'>" +
                        "<tr style='border: 2px solid grey; font-weight: bold; font-size: 1.3em; text-align: left;'>";


        if(lista.get(1) instanceof EarningsByData){
            htmlResult += "<th style='width: 300px;'> DATA </th>";
            htmlResult += "<th style='width: 300px;'> INCASSI TOTALI </th>";
            htmlResult += "<tr>";
        }

        if(lista.get(1) instanceof OrderByFoccacia){
            htmlResult += "<th style='width: 300px;'> FOCACCIE </th>";
            htmlResult += "<th style='width: 300px;'> ORDINI TOTALI </th>";
            htmlResult += "<tr>";
        }

        for (E res : lista) {
            if(res instanceof EarningsByData){

                htmlResult += "<td style=' padding: 0.5em;'>";
                htmlResult += ((EarningsByData) res).getData();
                htmlResult += "</td>";
                htmlResult += ("<td style=' padding: 0.5em;'>");
                htmlResult += ((EarningsByData) res).getPrice();
                htmlResult+= ("</tr>");
            }
            else if(res instanceof OrderByFoccacia){
                htmlResult += "<tr>";
                htmlResult += "<td style=' padding: 0.5em;'>";
                htmlResult += ((OrderByFoccacia) res).getFocaccia();
                htmlResult += "</td>";
                htmlResult += ("<td style=' padding: 0.5em;'>");
                htmlResult += ((OrderByFoccacia) res).getOrdinate();
                htmlResult+= ("</tr>");
            }
        }

        htmlResult += ("<table>");
        htmlResult += ("</body>");
        htmlResult += ("</html>");

        return htmlResult;
    }
}
