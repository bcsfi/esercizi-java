package net.bcsoft.bcvinaino.entity;

public class QuantitaFocaccia {

    private String nome;
    private Integer qta;

    public  QuantitaFocaccia(String nome, Integer qta)
    {
        this.nome = nome;
        this.qta = qta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQta() {
        return qta;
    }

    public void setQta(Integer qta) {
        this.qta = qta;
    }
}
