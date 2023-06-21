package net.bcsoft.bcvinaino.service;

import java.time.LocalDate;

public interface ReportService {
    String getFocacce();

    String getIncassi();

    String getOrdini(LocalDate dataInput);

    String getSogliaOrdini(Double min, Double max);
}