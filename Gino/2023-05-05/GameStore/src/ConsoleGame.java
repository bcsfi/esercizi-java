public class ConsoleGame extends VideoGame{
    private String piattaforma;

    public ConsoleGame(String titolo, double prezzo, int anno, String piattaforma)
    {
        super(titolo, prezzo, anno);
        setPiattaforma(piattaforma);
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    @Override
    public String toString()
    {
        String string = getTitolo() + " " + getPrezzo() + " " + getAnno() + " " + getPiattaforma();
        return string;
    }
}