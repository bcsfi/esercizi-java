package net.bcsoft.DataObject;
import net.bcsoft.Enum.provinciaEnum;

import java.time.LocalDate;


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
