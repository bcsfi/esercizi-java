package net.bcsoft.bcvinaino.entity.dettaglio;

import net.bcsoft.bcvinaino.entity.Ordine;

public class OrdineFinale extends Ordine {
    String nome;
    Double prezzo;
    Integer qta;

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

    public Integer getQta() {
        return qta;
    }

    public void setQta(Integer qta) {
        this.qta = qta;
    }
}
