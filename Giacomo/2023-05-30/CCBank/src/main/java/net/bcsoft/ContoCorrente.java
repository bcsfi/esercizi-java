package net.bcsoft;

import java.util.Date;

public class ContoCorrente
{
    private Long idContoCorrente;
    private String iban, nome, cognome, luogoNascita, indirizzoResidenza, numeroTelefono, mail, codiceFiscale;
    private Date dataNasciata;
    private GenereEnum genere;

    public ContoCorrente(Long idContoCorrente, String iban, String nome, String cognome, String luogoNascita, String indirizzoResidenza, String numeroTelefono, String mail, String codiceFiscale, Date dataNasciata, GenereEnum genere) {
        this.idContoCorrente = idContoCorrente;
        this.iban = iban;
        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.indirizzoResidenza = indirizzoResidenza;
        this.numeroTelefono = numeroTelefono;
        this.mail = mail;
        this.codiceFiscale = codiceFiscale;
        this.dataNasciata = dataNasciata;
        this.genere = genere;
    }

    public Long getIdContoCorrente() {
        return idContoCorrente;
    }

    public void setIdContoCorrente(Long idContoCorrente) {
        this.idContoCorrente = idContoCorrente;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    public void setIndirizzoResidenza(String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Date getDataNasciata() {
        return dataNasciata;
    }

    public void setDataNasciata(Date dataNasciata) {
        this.dataNasciata = dataNasciata;
    }

    public GenereEnum isGenere() {
        return genere;
    }

    public void setGenere(GenereEnum genere) {
        this.genere = genere;
    }
}
