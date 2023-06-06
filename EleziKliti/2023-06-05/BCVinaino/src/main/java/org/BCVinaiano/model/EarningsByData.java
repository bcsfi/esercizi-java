package org.BCVinaiano.model;

import java.time.LocalDate;

public class EarningsByData {
    private LocalDate data;
    private Double price;


    public EarningsByData (LocalDate data, Double price){
        this.data = data;
        this.price = price;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
