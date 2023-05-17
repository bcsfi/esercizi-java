package net.bcsoft;

import java.time.LocalDate;

public class Incasso {
    private LocalDate data = null;
    private ProvinciaEnum provincia;
    private Float importo;

    public Incasso(LocalDate data, ProvinciaEnum provincia, Float importo) {
        this.data = data;
        this.provincia = provincia;
        this.importo = importo;
    }

    public Incasso(String rigaFile) throws ProvinciaErrataException {
        String[] colonne = rigaFile.trim().split(";");
        try {
            this.data = LocalDate.parse(colonne[0]);
            this.provincia = ProvinciaEnum.valueOf(colonne[1].toUpperCase());
            this.importo = Float.parseFloat(colonne[2]);
        }catch (IllegalArgumentException e){
            throw new ProvinciaErrataException();
        }
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ProvinciaEnum getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEnum provincia) {
        this.provincia = provincia;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }
}
