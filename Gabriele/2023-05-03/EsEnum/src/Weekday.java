public enum Weekday {
    LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA;

    public int restituisceNumero(Weekday giorno){
        return switch (giorno) {
            case LUNEDI -> 1;
            case MARTEDI -> 2;
            case MERCOLEDI -> 3;
            case GIOVEDI -> 4;
            case VENERDI -> 5;
            case SABATO -> 6;
            case DOMENICA -> 7;
        };
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
