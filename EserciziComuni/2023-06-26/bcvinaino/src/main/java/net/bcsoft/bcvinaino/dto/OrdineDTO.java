package net.bcsoft.bcvinaino.dto;

import jakarta.annotation.PostConstruct;
import net.bcsoft.bcvinaino.entity.Ordine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrdineDTO {
    private Integer idOrdine;
    private Date dataOrdine;

    public OrdineDTO(Ordine entity){
        this.idOrdine = entity.getIdOrdine();
        this.dataOrdine = entity.getDataOrdine();
    }
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
