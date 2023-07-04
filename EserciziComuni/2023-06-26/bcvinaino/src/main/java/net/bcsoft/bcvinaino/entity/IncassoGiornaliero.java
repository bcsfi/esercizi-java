package net.bcsoft.bcvinaino.entity;


import java.util.Date;

public class IncassoGiornaliero {

    private Date data;

    private Double incasso;

    public IncassoGiornaliero(Date data, Double incasso) {
        this.data = data;
        this.incasso = incasso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getIncasso() {
        return incasso;
    }

    public void setIncasso(Double incasso) {
        this.incasso = incasso;
    }
}
