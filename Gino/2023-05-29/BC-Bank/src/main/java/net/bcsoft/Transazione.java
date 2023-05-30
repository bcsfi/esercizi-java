package net.bcsoft;

import java.time.LocalDateTime;

public class Transazione
{
    private Long id_Transazione; // Key
    private Long id_ContoCorrente; // Foreign Key
    private Double importo;
    private LocalDateTime dataOraTransazione;
    private String identificativoAttore;
    private MezzoPagamentoEnum mezzoPagamento;

    public Transazione(Long id_Transazione, Long id_ContoCorrente, Double importo, LocalDateTime dataOraTransazione, String identificativoAttore, MezzoPagamentoEnum mezzoPagamento)
    {
        this.id_Transazione = id_Transazione;
        this.id_ContoCorrente = id_ContoCorrente;
        this.importo = importo;
        this.dataOraTransazione = dataOraTransazione;
        this.identificativoAttore = identificativoAttore;
        this.mezzoPagamento = mezzoPagamento;
    }

    public Long getId_Transazione()
    {
        return id_Transazione;
    }

    public void setId_Transazione(Long id_Transazione)
    {
        this.id_Transazione = id_Transazione;
    }

    public Long getId_ContoCorrente()
    {
        return id_ContoCorrente;
    }

    public void setId_ContoCorrente(Long id_ContoCorrente)
    {
        this.id_ContoCorrente = id_ContoCorrente;
    }

    public Double getImporto()
    {
        return importo;
    }

    public void setImporto(Double importo)
    {
        this.importo = importo;
    }

    public LocalDateTime getDataOraTransazione()
    {
        return dataOraTransazione;
    }

    public void setDataOraTransazione(LocalDateTime dataOraTransazione) {
        this.dataOraTransazione = dataOraTransazione;
    }

    public String getIdentificativoAttore()
    {
        return identificativoAttore;
    }

    public void setIdentificativoAttore(String identificativoAttore) {
        this.identificativoAttore = identificativoAttore;
    }

    public MezzoPagamentoEnum getMezzoPagamento()
    {
        return mezzoPagamento;
    }

    public void setMezzoPagamento(MezzoPagamentoEnum mezzoPagamento)
    {
        this.mezzoPagamento = mezzoPagamento;
    }
}
