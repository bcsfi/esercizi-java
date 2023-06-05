package org.bcbank.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transazione {

    private int idTransazione;
    private double importo;
    private String ibanDestinatario;
    private LocalDate dataTransazione;
    private String mezzoDiPagamento;
    private int idCc;

    public Transazione(int idTransazione, double importo, String ibanDestinatario, LocalDate dataTransazione, String mezzoDiPagamento, int idCc) {
        this.idTransazione=idTransazione;
        this.importo=importo;
        this.ibanDestinatario=ibanDestinatario;
        this.dataTransazione=dataTransazione;
        this.mezzoDiPagamento=mezzoDiPagamento;
        this.idCc=idCc;
    }

    public int getId() {
        return this.idTransazione;
    }
    public double getImporto() {
        return this.importo;
    }
    public String getIbanDestinatario() {
        return this.ibanDestinatario;
    }
    public LocalDate getDataTransazione() {
        return this.dataTransazione;
    }
    public String getMezzoDiPagamento() {
        return this.mezzoDiPagamento;
    }
    public int getIdCc() {return this.idCc;}


}
