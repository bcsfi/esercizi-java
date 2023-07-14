package net.bcsoft.bcvinaino.dto;

public class ArticoloOrdineDTO {
    private Long id;

    private String nome;

    private Double prezzo;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }
}
