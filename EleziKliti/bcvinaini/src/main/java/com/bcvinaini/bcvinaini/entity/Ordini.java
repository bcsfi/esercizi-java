package com.bcvinaini.bcvinaini.entity;
import java.time.LocalDate;
import java.util.Date;

public class Ordini {
    Integer id;
    Date data;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

}
