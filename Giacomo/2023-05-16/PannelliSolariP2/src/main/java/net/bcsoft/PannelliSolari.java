package net.bcsoft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;

public class PannelliSolari {
    public static void main(String[] args) {
        String errori = "";

        try {
            ReportCreator reportCreator = new ReportCreator(Path.of("C:\\Users\\bcsoft\\Desktop\\es GG"));
        } catch (IOException e) {
            errori += e;
        }
    }
}