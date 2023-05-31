package org.bcbank.model;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conto {

    private int idCC;
    private String iban;
    private String nomeUtente;
    private String indirizzoUtente;
    private BigDecimal nTelefonoUtente;

    public Conto(int idCC, String iban, String nomeUtente, String indirizzoUtente, BigDecimal nTelefonoUtente) {
        this.idCC=idCC;
        this.iban=iban;
        this.nomeUtente=nomeUtente;
        this.indirizzoUtente=indirizzoUtente;
        this.nTelefonoUtente=nTelefonoUtente;
    }

    public int getId(){
        return this.idCC;
    }
    public String getIban() {
        return this.iban;
    }
    public String getNomeUtente() {
        return this.nomeUtente;
    }
    public String getIndirizzoUtente() {
        return this.indirizzoUtente;
    }
    public BigDecimal getnTelefonoUtente() {
        return this.nTelefonoUtente;
    }


}
