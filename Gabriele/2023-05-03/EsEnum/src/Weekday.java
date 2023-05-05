public enum Weekday {
    LUNEDI(1),
    MARTEDI(2),
    MERCOLEDI(3),
    GIOVEDI(4),
    VENERDI(5),
    SABATO(6),
    DOMENICA(7);
    final int numberOfDay;

    Weekday (int numberOfDay){
        this.numberOfDay = numberOfDay;
    }

    public String giornoDopo(Weekday giorno){
        return switch (giorno) {
            case LUNEDI -> "Martedi";
            case MARTEDI -> "mercoledi";
            case MERCOLEDI -> "giovedi";
            case GIOVEDI -> "venerdi";
            case VENERDI -> "sabato";
            case SABATO -> "domenica";
            case DOMENICA -> "lunedi";
        };

    }
}
