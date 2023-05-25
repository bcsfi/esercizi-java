package net.bcsoft.panelreport.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileManager {
    private FileManager() {
    }

    public static void buildFile(String pathStr, String nomeFileEdEstensione, String contenuto)
            throws IOException, IllegalArgumentException {
        String pathCompleto = pathStr + nomeFileEdEstensione;
        Path pathObj = Path.of(pathCompleto);
        Files.deleteIfExists(pathObj);
        //scrivi solo se c'è del testo, oppure scrivi pure file vuoti, e solo quello di errore lo fai se c'è testo
        Files.createFile(pathObj);
        Files.writeString(pathObj, contenuto);
    }
}

