public class PCGame extends VideoGame{
    private String requisitiMinimiDiSistema;

    public PCGame (String titolo, double prezzo, int anno, String requisitiMinimiDiSistema)
    {
        super(titolo, prezzo, anno);
        setRequisitiMinimiDiSistema(requisitiMinimiDiSistema);
    }
    public String getRequisitiMinimiDiSistema() {
        return requisitiMinimiDiSistema;
    }

    public void setRequisitiMinimiDiSistema(String requisitiMinimiDiSistema) {
        this.requisitiMinimiDiSistema = requisitiMinimiDiSistema;
    }

   /*public String toString()
    {
        String string = this.titolo + " " + this.prezzo + " " + this.anno;
        return string;
    }*/
}
