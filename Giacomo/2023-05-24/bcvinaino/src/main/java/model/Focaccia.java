package model;

public class Focaccia
{
    private String nome;
    private int quantita;

    public Focaccia(String nome, int quantita)
    {
        this.nome = nome;
        this.quantita = quantita;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getQuantita()
    {
        return quantita;
    }

    public void setQuantita(int quantita)
    {
        this.quantita = quantita;
    }
}
