package org.example.POJO;

public class Utente {

    private final String riferimento;
    private int anno;
    private int mese;

    public Utente(String riferimento, int anno, int mese) {
        this.riferimento = riferimento;
        this.anno = anno;
        this.mese = mese;
    }

    public String getRiferimento(){
        return this.riferimento;
    }

    public int getanno(){
        return this.anno;
    }

    public int getmese(){
        return this.mese;
    }


}
