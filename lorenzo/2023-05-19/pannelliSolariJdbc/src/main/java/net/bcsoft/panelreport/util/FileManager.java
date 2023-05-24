package net.bcsoft.panelreport.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FileManager {
    private FileManager() {
    }

    public static void buildFile(String pathStr, String nomeFileEdEstensione, String contenuto)
            throws IOException, IllegalArgumentException {
        String pathCompleto = pathStr + nomeFileEdEstensione;
        validaPathEFile(pathCompleto);
        Path pathObj = Path.of(pathCompleto);
        Files.deleteIfExists(pathObj);
        //scrivi solo se c'è del testo, oppure scrivi pure file vuoti, e solo quello di errore lo fai se c'è testo
        Files.createFile(pathObj);
        Files.writeString(pathObj, contenuto);
    }

    private static void validaPathEFile(String pathEFile) throws IllegalArgumentException {
        String FILE_LOCATION_PATTERN = "([a-zA-Z]:)?(\\\\[a-zA-Z0-9_.-]+)+\\\\?";

        if (pathEFile != null) {
            Pattern pattern = Pattern.compile(FILE_LOCATION_PATTERN, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(pathEFile);

            if (matcher.find()) {
                String estensione = pathEFile.substring(pathEFile.lastIndexOf("."));
                if (!estensione.equals(".txt")) {
                    String message = String.format(
                            "Estensione del file indicata nel path %s non è valida. Estensione: %s",
                            pathEFile, estensione);
                    throw new IllegalArgumentException(message);
                }

            } else {
                String message = String.format("'%s' ha percorso non valido", pathEFile);
                throw new IllegalArgumentException(message);
            }

        } else {
            String message = "Il path è null";
            throw new IllegalArgumentException(message);
        }
    }
}

