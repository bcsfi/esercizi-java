package net.bcsoft.bcvinaino.entity;

import java.time.LocalDate;

public class Incasso {
    LocalDate data;
    Double somma;

    public LocalDate getData() {
        return data;
    }

    public Double getSomma() {
        return somma;
    }
    public void setSomma(Double somma) {
        this.somma = somma;
    }
}