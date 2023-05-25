package net.bcsoft.bcbank.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContoCorrente {
    private String iban;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String numeroTelefono;
    private Integer id;


    public ContoCorrente(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.iban = resultSet.getString(2);
        this.nome = resultSet.getString(3);
        this.cognome = resultSet.getString(4);
        this.indirizzo = resultSet.getString(5);
        this.numeroTelefono = resultSet.getString(6);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
