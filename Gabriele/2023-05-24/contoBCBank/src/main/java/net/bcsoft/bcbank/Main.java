package net.bcsoft.bcbank;

import net.bcsoft.bcbank.enumeration.TipoTransazioneEnum;
import net.bcsoft.bcbank.util.ReportCreator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserire il path dove salvare i file: ");
        String pathFinale = input.next();

        try {
            ReportCreator reportCreator = new ReportCreator(pathFinale); //forse meglio passare paathFinale al metodo creaReport
            reportCreator.stampaSuFile();
        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE PATH INSERITO | " + e.getMessage());
            //} catch (SQLException e) {
            //  System.out.println("ERRORE DATABASE | " + e.getMessage());
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}