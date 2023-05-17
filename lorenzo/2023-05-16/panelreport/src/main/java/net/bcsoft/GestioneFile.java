package net.bcsoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class GestioneFile {
    private Map<String, Double> mappaPerProvincia = new HashMap<>();

    public GestioneFile(Map<String, Double>mappaPerProvincia){
        this.mappaPerProvincia = mappaPerProvincia;
    }
    public void leggi(String pathFile) throws IOException { // COPIA E INCOLLA
        Path path = Path.of(pathFile);
        boolean exists = Files.exists(path);
        if(!exists) {
            throw new IOException("IL FILE NON ESISTE");
        }
        while(){
            String lineaFile = Files.readString(utfFile);
        }
    }
}
