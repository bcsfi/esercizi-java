package net.bcsoft.bcbank;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import net.bcsoft.bcbank.enumeration.TipoTransazioneEnum;
public class Transazione {
    private String identificativoPersonale;
    private Float importo;
    private LocalDate data;
    private LocalTime ora;
    private String identificativoAltroConto;
    private TipoTransazioneEnum tipoTransazione;

    private Contocorrente contocorrentePersonale = null;
    private Contocorrente contocorrenteAltroConto = null;

    public Transazione(ResultSet resultSet){
        this.identificativoPersonale = resultSet.getString();
        this.importo = resultSet.getFloat();
        this.data = resultSet.getDate().toLocalDate();
        this.ora = resultSet.getTime().toLocalTime();
        this.identificativoAltroConto = resultSet.getString();
        this.tipoTransazione = TipoTransazioneEnum.valueOf(resultSet.getString());
    }

    public void transazioneRicevuta(){
        contocorrentePersonale = new Contocorrente();
    }

    public void transazineInviata(){

    }
}
