package net.bcsoft.bcvinaino.entity;

public class ArticoliOrdine
{
    private Long idArticoliOrdine;
    private Long idOrdine;
    private int idMenu;
    private int qta;

    public ArticoliOrdine() {}

    public Long getIdArticoliOrdine() {
        return idArticoliOrdine;
    }

    public void setIdArticoliOrdine(Long idArticoliOrdine) {
        this.idArticoliOrdine = idArticoliOrdine;
    }

    public Long getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Long idOrdine) {
        this.idOrdine = idOrdine;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }
}
