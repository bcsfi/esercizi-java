package net.bcsoft;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    /**
     * Programma gestione Report Creator
     *
     * Realizzato da Kliti & Angelo <3
     */
    public static final String REPORT_PROVINCE = "C:\\Users\\bcsoft\\outputPanelli\\reportProvince.txt";
    public static final String REPORT_DATE = "C:\\Users\\bcsoft\\outputPanelli\\reportDate.txt";

    public static void main(String[] args) {

        IncassoMensile incassoMensile = new IncassoMensile("resoconto.txt");
        ReportCreator creator = new ReportCreator(incassoMensile);

        creator.creaSommaPerPronvica(REPORT_PROVINCE);
        creator.creaSommaPerData(REPORT_DATE);

    }
}