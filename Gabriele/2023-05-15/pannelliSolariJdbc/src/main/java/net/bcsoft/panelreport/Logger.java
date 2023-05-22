package net.bcsoft.panelreport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static List<String> listError = new ArrayList<String>();

    public static void addException(String message) {
        listError.add(message);
    }

    public static void printLog(String folderFinale) throws IOException {
        Path pathLog = Path.of(folderFinale + "log.txt");
        Files.createFile(pathLog);
        String logString = "";
        for (String errorLine : listError) logString += errorLine + "\n";
        Files.writeString(pathLog, logString);
    }
}
