package net.bcsoft.panelreport.main;

import net.bcsoft.panelreport.util.Logger;
import net.bcsoft.panelreport.util.ReportCreator;
import net.bcsoft.panelreport.validation.ValidatoreDiPath;

import java.io.IOException;

public class PannelliSolari {
    public static void main(String[] args) {

        String pathFinale = args[0];

        try {
            ValidatoreDiPath.validaPath(pathFinale);
            ReportCreator reportCreator = new ReportCreator(pathFinale); //forse meglio passare paathFinale al metodo creaReport
            reportCreator.creaReport();




            Logger.printLog(pathFinale);
        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE PATH INSERITO | " + e.getMessage());
        //} catch (SQLException e) {
          //  System.out.println("ERRORE DATABASE | " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERRORE FILE | " + e.getMessage());
        }
    }
}
