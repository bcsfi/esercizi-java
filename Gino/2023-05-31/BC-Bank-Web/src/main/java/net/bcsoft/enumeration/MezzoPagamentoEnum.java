package net.bcsoft.enumeration;

public enum MezzoPagamentoEnum
{
    APP("App"),
    BONIFICO("Bonifico"),
    CARTA("Carta"),
    GIROCONTO("Giroconto");

    private String dbName;

    MezzoPagamentoEnum(String dbName) {
        this.dbName = dbName;
    }

    public static MezzoPagamentoEnum dbValueOf(String dbName) throws IllegalArgumentException
    {
        MezzoPagamentoEnum result = null;

        for (MezzoPagamentoEnum mezzoPagamentoEnum:MezzoPagamentoEnum.values())
        {
            if (mezzoPagamentoEnum.dbName.equals(dbName)) result = mezzoPagamentoEnum;
        }

        if (result == null) throw new IllegalArgumentException("Non esiste un valore " + dbName + " per MezzoPagamentoEnum");

        return result;
    }
}