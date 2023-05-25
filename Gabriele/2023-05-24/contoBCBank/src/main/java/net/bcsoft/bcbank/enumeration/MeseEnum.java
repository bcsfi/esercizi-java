package net.bcsoft.bcbank.enumeration;

public enum MeseEnum {
    GENNAIO(1),
    FEBBRAIO(2),
    MARZO(3),
    APRILE(4),
    MAGGIO(5),
    GIUGNO(6),
    LUGLIO(7),
    AGOSTO(8),
    SETTEMBRE(9),
    OTTOBRE(10),
    NOVEMBRE(11),
    DICEMBRE(12);
    int numeroMese;
    MeseEnum(int numeroMese){
        this.numeroMese = numeroMese;
    }
}
