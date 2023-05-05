package net.bcsoft.GameStore;

public class ConsoleGame extends VideoGame {

    private String piattaforma;

    public ConsoleGame(String titolo, Double prezzo, int annoRilascio, String piattaforma){
        setTitolo(titolo);
        setPrezzo(prezzo);
        setAnnoRilascio(annoRilascio);
        setPiattaforma(piattaforma);
    }
    public String getPiattaforma(){
        return piattaforma;
    }
    public void setPiattaforma(String piattaforma){
        this.piattaforma = piattaforma;
    }


}
