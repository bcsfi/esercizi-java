package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Incasso
{
    private LocalDateTime data;
    private int quantita;
    private double somma;

    public Incasso(LocalDateTime data, int quantita, double somma)
    {
        this.data = data;
        this.quantita = quantita;
        this.somma = somma;
    }

    public LocalDateTime getData()
    {
        return data;
    }

    public void setData(LocalDateTime data)
    {
        this.data = data;
    }

    public int getQuantita()
    {
        return quantita;
    }

    public void setQuantita(int quantita)
    {
        this.quantita = quantita;
    }

    public double getSomma()
    {
        return somma;
    }

    public void setSomma(double somma)
    {
        this.somma = somma;
    }
}
