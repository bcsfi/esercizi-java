package net.bcsoft.Function;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ErrorManager {

    private StringBuilder errorList;
    String outputPath;

    // c:\home\fabio\logs.txt
    public ErrorManager(StringBuilder errorList, String outputPath){
        this.errorList = errorList;
        this.outputPath=outputPath;
    }


    public void addError(String error){
        this.errorList.append(error + "\n");
    }

    public void writeError(){
        try {
            Path outputPath = Path.of(this.outputPath);
            if(Files.exists(outputPath)) {Files.delete(outputPath);}
            Files.createFile(outputPath);
            Files.writeString(outputPath, this.errorList.toString());
        } catch (IOException x){
            System.out.print("Impossibile creare i logs.");
        }
    }

}
