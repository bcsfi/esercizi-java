package net.bcsoft.bcvinainorefactor.entity;

public class Menu
{
    private Long idMenu;
    private String nome;
    private Double prezzo;

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long id) {
        this.idMenu = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }
}
