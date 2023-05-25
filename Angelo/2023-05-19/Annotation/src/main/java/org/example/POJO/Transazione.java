package org.example.POJO;

import java.time.LocalDate;

public class ContoCorrente {

    Utente persona = null;

    private final String iban;
    private final String saldoIban;
    private final LocalDate giacenza;

    public ContoCorrente(String iban, String saldoIban, LocalDate giacenza) {
        this.iban = iban;
        this.saldoIban = saldoIban;
        this.giacenza = giacenza;
    }




}
