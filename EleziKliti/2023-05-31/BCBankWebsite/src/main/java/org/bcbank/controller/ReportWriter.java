package org.bcbank.controller;
import org.bcbank.model.Risultati;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;


public class ReportWriter {
    public static void reportWrite(String pathToSave, List<Risultati> listOfResult) throws IOException {

        StringBuilder strRes = new StringBuilder();
        Path fsToWrite = Files.createFile(Paths.get(pathToSave));

        String strTitle = String.format("%-30s|%-30s|%-30s\n", "IBAN", "NUMERO TRANSAZIONI", "GIACENZA");
        strRes.append(strTitle);

        for (Risultati resultato : listOfResult){
            String strLine = String.format("| %-30s|%-30d|%-30f\n", resultato.getIban(), resultato.getNumero(), resultato.getGiacenza());
            strRes.append(strLine);
        }

        Files.writeString(fsToWrite, strRes);
    }

}
