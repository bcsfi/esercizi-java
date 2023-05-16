package net.bcsoft;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String  percorsoIniziale;
        Map<String, Double> mappaPerProvincia = new HashMap<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il path del file da cui importare i dati: ");
        percorsoIniziale= input.nextLine();
        File file = new File(percorsoIniziale);
        elaboraFile(file, mappaPerProvincia);
    }

    public static void elaboraFile(File file, Map<String, Double> mappaPerProvincia) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                String riga = br.readLine();
                elaboraRiga(riga, mappa);
            }
            scriviMappaSuFile(mappa);
        } catch (IOException e) {
            System.out.println("ERRORE DI LETTURA FILE");
            e.printStackTrace();
        }
    }

    private static void elaboraRiga(String riga, Map<String, Double> mappa) {
        String[] words = new String[0];
        if (riga != null) {
            words = riga.trim().split(";");
            String provincia = words[1].toUpperCase();
            Double importo = Double.parseDouble(words[2]);
            mettiInMappa(provincia, importo, mappa);
        }
    }

    private static void mettiInMappa(String provincia, Double importo, Map<String, Double> mappa) {
        if (!mappa.containsKey(provincia)) {
            mappa.put(provincia, importo);
        } else {
            mappa.put(provincia, mappa.get(provincia) + importo);
        }
    }

    private static void scriviMappaSuFile(Map<String, Double> mappa) {
        try {
            FileWriter myWriter = new FileWriter("reportFinale.txt");
            for (String chiave : mappa.keySet()) {
                Double valore = mappa.get(chiave);
                myWriter.write("Provincia:" + chiave + " Importo: " + valore + "\n");
            }
            myWriter.close();
            System.out.println("File scritto correttamente.");
        } catch (IOException e) {
            System.out.println("ERRORE FILE NON SCRITTO.");
            e.printStackTrace();
        }
    }
}