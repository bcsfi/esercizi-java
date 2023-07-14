package net.bcsoft.bcvinaino.dto;

import java.sql.Date;

public class OrdineDTO {
    private Long id;

    private Date data;

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
