package net.bcsoft.poke;

public class Ingrediente {
    private String nome;

    private String descrizione;

    private GruppoIngredienteEnum gruppoIngrediente;

    public Ingrediente(String nome, String descrizione, GruppoIngredienteEnum gruppoIngrediente){
        this.nome=nome;
        this.descrizione=descrizione;
        this.gruppoIngrediente=gruppoIngrediente;
    }

    public String getNome(){
        return nome;
    }
    public String getDescrizione(){
        return descrizione;
    }
    public GruppoIngredienteEnum getGruppoIngrediente(){
        return gruppoIngrediente;
    }
}


