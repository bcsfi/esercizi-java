package net.bcsoft.bcbank;

import java.sql.ResultSet;

public class Contocorrente {
    private String identificativo;
    private String nome;
    private String indirizzo;
    private String numeroTelefono


    public Contocorrente(ResultSet resultSet){
        this.identificativo = resultSet.getString();
        this.nome = resultSet.getString();
        this.indirizzo = resultSet.getString();
        this.numeroTelefono = resultSet.getString();
    }

    public String getIdentificativo() {
        return identificativo;
    }

    public void setIdentificativo(String identificativo) {
        this.identificativo = identificativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
