package net.bcsoft.bcvinaino.entity;

public class QuantitaFocaccia {
    private String nome;
    private Integer quantita;

    public QuantitaFocaccia(String nome, Integer quantita) {
        this.nome = nome;
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
}
