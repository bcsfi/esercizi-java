package net.bcsoft;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class Incasso {

    LocalDate data;
    provinciaEnum provincia;
    double importo;

    public Incasso(LocalDate data, provinciaEnum provincia, double importo){

        this.data = data;
        this.provincia = provincia;
        this.importo = importo;
    }

    public LocalDate getData(){
        return this.data;
    }


    public  provinciaEnum getProvincia(){
        return this.provincia;
    }

    public Double getImport(){
        return this.importo;
    }


}
