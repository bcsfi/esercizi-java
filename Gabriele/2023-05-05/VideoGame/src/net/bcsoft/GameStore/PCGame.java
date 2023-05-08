package net.bcsoft.GameStore;

public class PCGame extends VideoGame{
    private String specificheSistema;
    public  PCGame(String titolo, Double prezzo, int annoRilascio, String specificheSistema ){
        super(titolo, prezzo, annoRilascio);
        setSpecificheSistema(specificheSistema);
    }

    public String getSpecificheSistema(){
        return specificheSistema;
    }

    public void setSpecificheSistema(String specificheSistema) {
        this.specificheSistema = specificheSistema;
    }
}
