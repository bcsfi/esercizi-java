package model;

import enumeration.NomeMenuEnum;

public class Menu
{
    private NomeMenuEnum nome;
    private String descrizione;
    private double prezzo;

    public Menu(NomeMenuEnum nome, String descrizione, double prezzo)
    {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public NomeMenuEnum getNome()
    {
        return nome;
    }

    public void setNome(NomeMenuEnum nome)
    {
        this.nome = nome;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public double getPrezzo()
    {
        return prezzo;
    }

    public void setPrezzo(double prezzo)
    {
        this.prezzo = prezzo;
    }
}
