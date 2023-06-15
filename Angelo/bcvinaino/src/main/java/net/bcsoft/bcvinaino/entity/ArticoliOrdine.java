package net.bcsoft.bcvinaino.entity;

public class ArticoliOrdine {
    private Long idArticoliOrdine;
    private Long idOrdine;
    private Long idMenu;
    private Integer qta;

    public Long getId_articoli_ordine() {
        return idArticoliOrdine;
    }

    public void setId_articoli_ordine(Long id_articoli_ordine) {
        this.idArticoliOrdine= id_articoli_ordine;
    }

    public Long getId_ordine() {
        return idOrdine;
    }

    public void setId_ordine(Long id_ordine) {
        this.idOrdine = id_ordine;
    }

    public Long getId_menu() {
        return idMenu;
    }

    public void setId_menu(Long id_menu) {
        this.idMenu = id_menu;
    }

    public Integer getQta() {
        return qta;
    }

    public void setQta(Integer qta) {
        this.qta = qta;
    }
}
