package net.bcsoft.panelreport.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static List<String> listError = new ArrayList<String>();

    public static void addException(String message) {
        listError.add(message);
    }

    public static void printLog(String cartellaFinale) throws IOException {
        FileManager.buildFile(cartellaFinale, "log.txt", normalizzaListErrorPerScrittura());
    }

    private static String normalizzaListErrorPerScrittura() {
        String stringaErrori = "";
        for (String errorLine : listError) {
            stringaErrori += errorLine + "\n";
        }
        return stringaErrori;
    }
}
