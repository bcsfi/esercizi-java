package net.bcsoft.bcvinaino.dto;


import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class OrdineDTO {
    private Integer idOrdine;
    private Date dataOrdine;

    public OrdineDTO(){

    }
    public Integer getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Integer idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }
}
