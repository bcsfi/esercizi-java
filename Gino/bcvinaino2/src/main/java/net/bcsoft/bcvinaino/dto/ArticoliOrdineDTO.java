package net.bcsoft.bcvinaino.dto;

public class ArticoliOrdineDTO {
    private Long idArticoliOrdine;
    private Long idOrdine;
    private int idMenu;
    private int qta;

    public ArticoliOrdineDTO(Long idArticoliOrdine, Long idOrdine, int idMenu, int qta) {
        this.idArticoliOrdine = idArticoliOrdine;
        this.idOrdine = idOrdine;
        this.idMenu = idMenu;
        this.qta = qta;
    }
}
