package net.bcsoft.bcvinaino.entity;

public class ArticoliOrdini {
    private Long idArticoliOrdine;
    private Long idMenu;
    private Long idOrdine;
    private Integer qta;

    public Long getIdArticoliOrdine() {
        return idArticoliOrdine;
    }

    public void setIdArticoliOrdine(Long idArticoliOrdine) {
        this.idArticoliOrdine = idArticoliOrdine;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public Long getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Long idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Integer getQta() {
        return qta;
    }

    public void setQta(Integer qta) {
        this.qta = qta;
    }
}
