package net.bcsoft.panelreport;

import net.bcsoft.panelreport.Enum.ProvinciaEnum;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Incasso {
    private LocalDate data = null;
    private ProvinciaEnum provincia;
    private Float importo;
    private String pathFinale;

    public Incasso(LocalDate data, ProvinciaEnum provincia, Float importo) {
        this.data = data;
        this.provincia = provincia;
        this.importo = importo;
    }

    public Incasso(String rigaFile) throws IOException {
        String[] colonna = rigaFile.trim().split(";");
        try {
            this.data = LocalDate.parse(colonna[0]);
            this.provincia = ProvinciaEnum.valueOf(colonna[1].toUpperCase().trim());
            this.importo = Float.parseFloat(colonna[2]);
        } catch (DateTimeParseException | IllegalArgumentException e) {
            throw new IOException(e);
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

    public void setPathFinale(String pathFinale) {
        this.pathFinale = pathFinale;
    }
}
