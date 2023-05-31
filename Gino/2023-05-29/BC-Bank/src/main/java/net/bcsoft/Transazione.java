package net.bcsoft;

import java.time.LocalDateTime;

public class Transazione
{
    private Long id; // Key
    private Long idContoCorrente; // Foreign Key
    private Double importo;
    private LocalDateTime dataOraTransazione;
    private String identificativoAttore;
    private MezzoPagamentoEnum mezzoPagamento;

    public Transazione(Long id_Transazione, Long id_ContoCorrente, Double importo, LocalDateTime dataOraTransazione, String identificativoAttore, MezzoPagamentoEnum mezzoPagamento)
    {
        this.id = id_Transazione;
        this.idContoCorrente = id_ContoCorrente;
        this.importo = importo;
        this.dataOraTransazione = dataOraTransazione;
        this.identificativoAttore = identificativoAttore;
        this.mezzoPagamento = mezzoPagamento;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getIdContoCorrente()
    {
        return idContoCorrente;
    }

    public void setIdContoCorrente(Long idContoCorrente)
    {
        this.idContoCorrente = idContoCorrente;
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