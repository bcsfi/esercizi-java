package net.bcsoft.gamestore;

public abstract class VideoGame {

    // variabili
    String titolo;
    double prezzo;
    int annoRilascio;

    // metodi get
    public String getTitolo(){
        return titolo;
    }
    public double getPrezzo(){
        return prezzo;
    }
    public int getAnnoRilascio(){
        return annoRilascio;
    }

    // metodi set
    public void setTitolo(){
        this.titolo = titolo;
    }
    public void setPrezzo(){
        this.prezzo = prezzo;
    }
    public void setAnnoRilascio(){
        this.annoRilascio = annoRilascio;
    }

}
