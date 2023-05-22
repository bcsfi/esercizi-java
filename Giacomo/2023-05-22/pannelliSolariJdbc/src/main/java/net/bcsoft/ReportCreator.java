package net.bcsoft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReportCreator
{
    private static final DecimalFormat DF = new DecimalFormat("#.00");
    IncassoMensile incassoMensile;
    int scelta;

    public ReportCreator(int scelta) throws IOException, SQLException, ClassNotFoundException {
        this.incassoMensile = new IncassoMensile();
        this.scelta = scelta;
        gestoreFile(scelta);
    }

    private void creaReportErrori()
    {
        try
        {
            Path path = Path.of("C:\\Users\\bcsoft\\Desktop\\es GG\\errori.txt");
            this.createFile(path,  incassoMensile.getEccezioni());
        }
        catch (IOException f)
        {
            f.printStackTrace();
        }
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

        Path path = Path.of("C:\\Users\\bcsoft\\Desktop\\es GG\\reportSecondo.txt");
        this.createFile(path, text);
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

        Path path = Path.of("C:\\Users\\bcsoft\\Desktop\\es GG\\report.txt");
        this.createFile(path, text);

    }

    private void gestoreFile(int scelta) throws IOException
    {
        //Scanner scanner = new Scanner(System.in);

        //System.out.print("\nQuali file desideri creare?\n 1- report.txt\n 2- reportSecondo.txt\n 3- Entrambi\n 0- Esci\n  - ");
        //scelta = scanner.nextInt();

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

        this.creaReportErrori();
    }

    private void createFile(Path path, String text) throws IOException {
        Files.deleteIfExists(path);
        if (text == null || text.isEmpty()) {
            return;
        }
        Files.createFile(/*incassoMensile.getDirectoryPath()*/path);
        Files.writeString(path,  text);
    }

}
