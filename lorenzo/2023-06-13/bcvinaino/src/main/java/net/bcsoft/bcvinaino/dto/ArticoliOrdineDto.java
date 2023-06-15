package net.bcsoft.bcvinaino.dto;

public class ArticoliOrdineDto {
    private Integer idArticoliOrdine;
    private Integer idOrdine;
    private Integer idMenu;
    private Integer qta;

    public Integer getIdArticoliOrdine() {
        return idArticoliOrdine;
    }

    public void setIdArticoliOrdine(Integer idArticoliOrdine) {
        this.idArticoliOrdine = idArticoliOrdine;
    }

    public Integer getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Integer idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getQta() {
        return qta;
    }

    public void setQta(Integer qta) {
        this.qta = qta;
    }
}
