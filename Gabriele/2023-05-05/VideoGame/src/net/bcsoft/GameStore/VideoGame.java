package net.bcsoft.GameStore;

public abstract class VideoGame {
    private String titolo = null;
    private Double prezzo = 0.0;
    private int annoRilascio;

    public String getTitolo(){
        return titolo;
    }
    public Double getPrezzo(){
        return prezzo;
    }
    public int getAnnoRilascio(){
        return annoRilascio;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }
    public void setPrezzo(Double prezzo){
        this.prezzo = prezzo;
    }
    public void setAnnoRilascio(int annoRilascio){
        this.annoRilascio = annoRilascio;
    }

}
