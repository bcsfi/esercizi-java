package net.bcsoft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReportCreator
{
    private static final DecimalFormat DF = new DecimalFormat("#.00");
    IncassoMensile incassoMensile;


    public ReportCreator(Path pathOfIncassoMensile) throws IOException, IllegalArgumentException, DateTimeParseException
    {
        this.incassoMensile = new IncassoMensile(pathOfIncassoMensile);
        gestoreFile();
    }

    private void creaReportSecondo() throws IOException
    {
        HashMap<LocalDate, Double> reports = new HashMap<>();

        String text =  "";

        for (Incasso incasso:incassoMensile.getIncassoList())
        {
            if (reports.containsKey(incasso.getProvincia()))
            {
                reports.put(incasso.getData(), incasso.getImporto() + reports.get(incasso.getProvincia()));
            }
            else
            {
                reports.put(incasso.getData(), incasso.getImporto());
            }
        }

        for (Map.Entry<LocalDate, Double> entry : reports.entrySet())
        {
            text += "Data : " + entry.getKey() + "    |    Importo : " + DF.format(entry.getValue()) + "\n";
        }

        Files.writeString(Files.createFile(incassoMensile.getDirectoryPath().resolve("reportSecondo.txt")), text);
    }

    private void creaReport() throws IOException
    {
        HashMap<ProvinciaEnum, Double> reports = new HashMap<>();

        String text =  "";

        for (Incasso incasso:incassoMensile.getIncassoList())
        {
            if (reports.containsKey(incasso.getProvincia()))
            {
                reports.put(incasso.getProvincia(), incasso.getImporto() + reports.get(incasso.getProvincia()));
            }
            else
            {
                reports.put(incasso.getProvincia(), incasso.getImporto());
            }
        }

        for (Map.Entry<ProvinciaEnum, Double> entry : reports.entrySet())
        {
            text += "Provincia : " + entry.getKey() + "    |    Importo : " + DF.format(entry.getValue()) + "\n";
        }

        Files.writeString(Files.createFile(incassoMensile.getDirectoryPath().resolve("report.txt")), text);
    }

    private void gestoreFile() throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        int scelta;

        System.out.print("\nQuali file desideri creare?\n 1- report.txt\n 2- reportSecondo.txt\n 3- Entrambi\n 0- Esci\n  - ");
        scelta = scanner.nextInt();

        switch (scelta)
        {
            case 1 :
                creaReport();
                break;

            case 2 :
                creaReportSecondo();
                break;

            case 3 :
                creaReport();
                creaReportSecondo();
                break;

            case 0 :
                System.exit(0);
                break;
        }
    }

    /*public IncassoMensile getIncassoMensile() {
        return incassoMensile;
    }*/

    /*public void setIncassoMensile(IncassoMensile incassoMensile) {
        this.incassoMensile = incassoMensile;*
    }*/
}
