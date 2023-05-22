package net.bcsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main
{
    public static void main(String[] args)
    {
        String filePath = "C:\\Users\\bcsoft\\Desktop\\es GG";

        if (!Files.exists(Path.of(filePath + "\\file.txt")))
        {
            System.out.println("\nIl file con i dati dei panelli solari non esiste!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath + "\\file.txt")))
        {
            HashMap<String, Double> reports = new HashMap<String, Double>();
            String line, report = "";

            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(";");

                if (reports.containsKey(parts[1]))
                {
                    reports.put(parts[1], (reports.get(parts[1]) + Double.valueOf(parts[2])));
                }
                else
                {
                    reports.put(parts[1], Double.valueOf(parts[2]));
                }
            }

            for (Entry<String, Double> entry : reports.entrySet())
            {
                report += "Provincia : " + entry.getKey() + "    |    Importo : " + Float.parseFloat(String.valueOf(entry.getValue())) + "\n";
            }

            if (Files.exists(Path.of(filePath + "\\report.txt")))
            {
                System.out.println("\nIl file report esiste già!");
                return;
            }

            Files.writeString(Files.createFile(Path.of(filePath).resolve("report.txt")), report);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}