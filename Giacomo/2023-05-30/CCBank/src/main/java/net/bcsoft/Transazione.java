package net.bcsoft;

import java.time.LocalDateTime;

public class Transazione
{
    Long idTransazione, idContoCorrente;
    double importo;
    LocalDateTime dataOraTransazione;
    String identificativoMittenteDestinatario;
    MezzoPagamentoEnum mezzoPagamento;

    public Transazione(Long idTransazione, Long idContoCorrente, double importo, boolean addebitoCredito, LocalDateTime dataOraTransazione, String identificativoMittenteDestinatario, MezzoPagamentoEnum mezzoPagamento) {
        this.idTransazione = idTransazione;
        this.idContoCorrente = idContoCorrente;
        this.importo = importo;
        this.dataOraTransazione = dataOraTransazione;
        this.identificativoMittenteDestinatario = identificativoMittenteDestinatario;
        this.mezzoPagamento = mezzoPagamento;
    }

    public Long getIdTransazione() {
        return idTransazione;
    }

    public void setIdTransazione(Long idTransazione) {
        this.idTransazione = idTransazione;
    }

    public Long getIdContoCorrente() {
        return idContoCorrente;
    }

    public void setIdContoCorrente(Long idContoCorrente) {
        this.idContoCorrente = idContoCorrente;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public LocalDateTime getDataOraTransazione() {
        return dataOraTransazione;
    }

    public void setDataOraTransazione(LocalDateTime dataOraTransazione) {
        this.dataOraTransazione = dataOraTransazione;
    }

    public String getIdentificativoMittenteDestinatario() {
        return identificativoMittenteDestinatario;
    }

    public void setIdentificativoMittenteDestinatario(String identificativoMittenteDestinatario) {
        this.identificativoMittenteDestinatario = identificativoMittenteDestinatario;
    }

    public MezzoPagamentoEnum getMezzoPagamento() {
        return mezzoPagamento;
    }

    public void setMezzoPagamento(MezzoPagamentoEnum mezzoPagamento) {
        this.mezzoPagamento = mezzoPagamento;
    }
}
