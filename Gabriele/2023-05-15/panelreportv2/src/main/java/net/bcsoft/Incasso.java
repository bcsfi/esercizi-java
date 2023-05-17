package net.bcsoft;

import java.time.LocalDate;
import java.util.Locale;

public class Incasso {
    private LocalDate data = null;
    private String provincia;
    private Float importo;

    public Incasso(LocalDate data, String provincia, Float importo) {
        this.data = data;
        this.provincia = provincia;
        this.importo = importo;
    }

    public Incasso(String rigaFile) {
        String[] colonne = rigaFile.trim().split(";");

        setData(LocalDate.parse(colonne[0]));
        setProvincia(colonne[1].toUpperCase());
        setImporto(Float.parseFloat(colonne[2]));
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }
}
