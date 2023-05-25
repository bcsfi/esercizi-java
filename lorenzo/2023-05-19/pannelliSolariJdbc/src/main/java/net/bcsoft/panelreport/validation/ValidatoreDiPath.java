package net.bcsoft.panelreport.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatoreDiPath {
    public static void validaPath(String path) throws IllegalArgumentException {
        String FILE_LOCATION_PATTERN = "([a-zA-Z]:)?(\\\\[a-zA-Z0-9_.-]+)+\\\\?";

        if (path == null) {
            String message = "Il path è null";
            throw new IllegalArgumentException(message);
        }

        Pattern pattern = Pattern.compile(FILE_LOCATION_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(path);

        if (!matcher.find()) {
            String message = String.format("'%s' ha percorso non valido", path);
            throw new IllegalArgumentException(message);
        }
    }
}
