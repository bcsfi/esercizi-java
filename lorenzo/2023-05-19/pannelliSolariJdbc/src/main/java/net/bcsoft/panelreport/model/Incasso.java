package net.bcsoft.panelreport.model;

import net.bcsoft.panelreport.enumeration.ProvinciaEnum;

import java.time.LocalDate;

public class Incasso {
    private LocalDate data;
    private ProvinciaEnum provincia;
    private Float importo;

    public Incasso(LocalDate data, ProvinciaEnum provincia, Float importo) {
        this.data = data;
        this.provincia = provincia;
        this.importo = importo;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ProvinciaEnum getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEnum provincia) {
        this.provincia = provincia;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }
}
