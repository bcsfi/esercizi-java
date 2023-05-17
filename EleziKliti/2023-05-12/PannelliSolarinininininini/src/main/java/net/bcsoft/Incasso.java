package net.bcsoft;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class Incasso {

    LocalDate data;
    String provincia;
    double importo;

    public Incasso(LocalDate data, String provincia, double importo){

        this.data = data;
        this.provincia = provincia;
        this.importo = importo;
    }

    public LocalDate getData(){
        return this.data;
    }


    public  String getProvincia(){

        switch (this.provincia) {
            case "MS":
            case "LU":
            case "LI":
            case "PI":
            case "PT":
            case "PO":
            case "FI":
            case "AR":
            case "SI":
            case "GR":
                return this.provincia;
        }
        return null;
    }

    public Double getImport(){
        return this.importo;
    }


}
