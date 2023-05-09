public abstract class VideoGame {
    private String titolo;
    private Double prezzo;
    private Integer anno;

    protected VideoGame(String titolo, double prezzo, int anno)
    {
        setTitolo(titolo);
        setPrezzo(prezzo);
        setAnno(anno);
    }

    public String getTitolo() {
        return titolo;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }
}