package net.bcsoft.bcvinaino.entity;

public class ArticoliOrdineDto {
    private Long idArticoliOrdine;
    private Long idOrdine;
    private Long idMenu;
    private Integer qta;

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

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getQta() {
        return qta;
    }

    public void setQta(Integer qta) {
        this.qta = qta;
    }
}
