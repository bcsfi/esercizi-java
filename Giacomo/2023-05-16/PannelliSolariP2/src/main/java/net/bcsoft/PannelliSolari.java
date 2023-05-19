package net.bcsoft;

import java.io.IOException;
import java.nio.file.Path;

public class PannelliSolari {
    public static void main(String[] args) {
        String errori = "";

        try
        {
            ReportCreator reportCreator = new ReportCreator(Path.of(args[0]), (Integer.parseInt(args[1] != null ? args[1] : "4"))); //Path.of("C:\\Users\\bcsoft\\Desktop\\es GG")
        }
        catch (IOException e)
        {
            errori += e;
        }
    }
}