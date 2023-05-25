package net.bcsoft.bcbank.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class FileManager {
    private FileManager() { }

    public static void buildFile(String pathStr, String nomeFileEdEstensione, String contenuto)
            throws IOException, IllegalArgumentException {
        String pathCompleto = pathStr + nomeFileEdEstensione;
        Path pathObj = Path.of(pathCompleto);
        Files.deleteIfExists(pathObj);
        Files.createFile(pathObj);
        Files.writeString(pathObj, contenuto);
    }

}
