package net.bcsoft.es5;

import java.util.Date;

public class Studente {
    private String nome;
    private String cognome;
    private Date dataDiNascita;


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

}
