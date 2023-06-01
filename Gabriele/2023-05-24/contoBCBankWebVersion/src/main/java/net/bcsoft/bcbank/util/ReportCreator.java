package net.bcsoft.bcbank.util;

import net.bcsoft.bcbank.model.ContoCorrente;
import net.bcsoft.bcbank.model.EstrattoContoMensile;
import net.bcsoft.bcbank.model.Transazione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReportCreator {
    private List<Transazione> transazioneList = new ArrayList<>();
    private List<EstrattoContoMensile> estrattoContoMensileList = new ArrayList<>();
    private List<ContoCorrente> contoCorrenteList = new ArrayList<>();

    private Map<Integer, Integer> aggregaTransazioniMap;
    private Map<Integer, Double> giacenzaFinaleMap;

    public ReportCreator(List<Transazione> transazioneList, List<EstrattoContoMensile> estrattoContoMensileList,
                         List<ContoCorrente> contoCorrenteList) {
        this.transazioneList = transazioneList;
        this.estrattoContoMensileList = estrattoContoMensileList;
        this.contoCorrenteList = contoCorrenteList;
        popolaMappe();
    }

    private void popolaMappe(){
        MapCreation mapCreation = new MapCreation();
        aggregaTransazioniMap = mapCreation.aggregaTransazioni(transazioneList);
        giacenzaFinaleMap = mapCreation.aggregaGiacenze(estrattoContoMensileList, transazioneList);
    }
    public String HtmlOutput()
            throws IOException, SQLException, ClassNotFoundException {
        String output = "";

        String header =
                "<!DOCTYPE html>" +
                "<html>\n" +
                "  <head>\n" +
                "       <title>BCBank | Report</title>\n" +
                "   </head>\n" +
                "   <body>\n" +
                "       <table>\n \n" +
                "           <tr>\n" +
                "               <th>ID</th>\n" +
                "               <th>CONTEGGIO GIACENZE</th>\n" +
                "               <th>CONTEGGIO TRANSAZIONE</th>\n" +
                "           </tr>\n \n";
        output += header;

        for (ContoCorrente contoCorrente : contoCorrenteList) {
            Integer id = contoCorrente.getId();
            Integer conteggioTransazioni = Optional.ofNullable(aggregaTransazioniMap.get(id)).orElse(0);
            Double conteggioGiacenze = Optional.ofNullable(giacenzaFinaleMap.get(id)).orElse(0.0);
            String rigaTabella =
                        "           <tr>\n" +
                        "               <td>" + id + "</td>\n" +
                        "               <td>" + conteggioGiacenze + "</td>\n" +
                        "               <td>" + conteggioTransazioni + "</td>\n" +
                        "           </tr>\n \n";
            output += rigaTabella;
        }

        String chiusuraTag =
                        "       </table>\n" +
                        "   </body>\n" +
                        "</html>";
        output += chiusuraTag;

        return output.toString();
    }
}
