package net.bcsoft.bcvinaino.service;

import java.time.LocalDate;

public interface ReportService {

    String calcolaIncassi();

    String getOrdini(LocalDate dataInput);
}
