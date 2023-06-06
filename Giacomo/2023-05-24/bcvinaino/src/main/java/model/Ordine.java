package model;

import java.util.Date;

public class Ordine
{
    private Date data;

    public Ordine(Date data)
    {
        this.data = data;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }
}
