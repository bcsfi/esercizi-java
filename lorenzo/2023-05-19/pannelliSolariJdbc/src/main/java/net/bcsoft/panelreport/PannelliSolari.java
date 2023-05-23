package net.bcsoft.panelreport;

import net.bcsoft.panelreport.util.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class PannelliSolari {
    public static void main(String[] args) {

        String pathFinale = args[0];

        try {
            ReportCreator report = new ReportCreator(pathFinale);
            report.creaMappaPerData();
            report.creaMappaPerProvincia();
            report.stampaSuFile();
            Logger.printLog(pathFinale);
        } catch (SQLException e) {
            System.out.println("ERRORE DATABASE | " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERRORE FILE | " + e.getMessage());
        }
    }
}
