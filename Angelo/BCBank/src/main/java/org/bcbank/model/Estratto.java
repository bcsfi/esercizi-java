package org.bcbank.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estratto  {
    private int idCcMensile;
    private int annoEcMensile;
    private int meseEcMensilee;
    private double giacenza;
    private int idCc;

    public Estratto(int idCcMensile, int annoEcMensile, int meseEcMensilee, double giacenza, int idCc) {
        this.idCcMensile=idCcMensile;
        this.annoEcMensile=annoEcMensile;
        this.meseEcMensilee=meseEcMensilee;
        this.giacenza=giacenza;
        this.idCc=idCc;
    }

    public int getIdCcMensile () {
        return this.idCcMensile;
    }
    public int getAnnoEcMensile() {
        return this.annoEcMensile;
    }
    public int getMeseEcMensilee() {
        return this.meseEcMensilee;
    }
    public double getGiacenza() {
        return this.giacenza;
    }
    public int getIdCc() {return this.idCc;}

    public static List<Estratto> creaElenecoEstratti(ResultSet resultQuery) throws SQLException
    {
        List<Estratto> elencoEstratti = new ArrayList<>();
        while(resultQuery.next())
        {
            Estratto estratto = new Estratto(resultQuery.getInt(1), resultQuery.getInt(2), resultQuery.getInt(3),
                                             resultQuery.getDouble(4), resultQuery.getInt(5));
            elencoEstratti.add(estratto);
        }
        return elencoEstratti;
    }

}
