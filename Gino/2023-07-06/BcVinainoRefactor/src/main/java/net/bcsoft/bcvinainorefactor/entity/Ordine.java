package net.bcsoft.bcvinainorefactor.entity;

import java.util.Date;

public class Ordine {
    private Long id;
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
