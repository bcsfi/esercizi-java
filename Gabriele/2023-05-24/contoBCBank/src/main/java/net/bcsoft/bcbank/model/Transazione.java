package net.bcsoft.bcbank.model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import net.bcsoft.bcbank.enumeration.TipoTransazioneEnum;
public class Transazione {
    private Integer idRiferimentoContoCorrente;
    private Float importo;
    private LocalDate data;
    private LocalTime ora;
    private String ibanDestinatario;
    private TipoTransazioneEnum tipoTransazione;

    public Transazione(ResultSet resultSet){
        this.idRiferimentoContoCorrente = resultSet.getInt();
        this.importo = resultSet.getFloat();
        this.data = resultSet.getDate().toLocalDate();
        this.ora = resultSet.getTime().toLocalTime();
        this.ibanDestinatario = resultSet.getString();
        this.tipoTransazione = TipoTransazioneEnum.valueOf(resultSet.getString());
    }


}
