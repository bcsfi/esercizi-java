package net.bcsoft;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ReportCreator {
    private Map < String, Double> mappaPerProvincia = new HashMap<>();
    private Map <String, Double> mappaPerData = new HashMap<>();

    public ReportCreator(Map < String, Double> mappaPerProvincia, Map <String, Double> mappaPerData){
        this.mappaPerData = mappaPerData;
        this.mappaPerProvincia = mappaPerProvincia;
    }

    public void leggiFile(String pathIniziale){
        Path path = Path.of(pathIniziale);

    }

}
