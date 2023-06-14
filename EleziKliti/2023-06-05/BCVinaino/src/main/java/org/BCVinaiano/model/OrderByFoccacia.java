package org.BCVinaiano.model;



public class OrderByFoccacia {

    private String focaccia;
    private int ordinate;

    OrderByFoccacia(String focaccia, int ordinate){
        this.focaccia=focaccia;
        this.ordinate=ordinate;
    }

    public String getFocaccia() {
        return focaccia;
    }

    public void setFocaccia(String focaccia) {
        this.focaccia = focaccia;
    }

    public int getOrdinate() {
        return ordinate;
    }

    public void setOrdinate(int ordinate) {
        this.ordinate = ordinate;
    }
}
