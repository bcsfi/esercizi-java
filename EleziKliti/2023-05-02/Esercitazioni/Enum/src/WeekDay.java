public enum WeekDay {

    LUNEDI(1, "Lunedi"),
    MARTEDI(2, "Martedi"),
    MERCOLEDI(3, "Mercoledi"),
    GIOVEDI(4, "Giovedi"),
    VENERDI(5, "Venerdi"),
    SABATO(6, "Sabato"),
    DOMENICA(7, "Domenica");

    private int indices;
    private String stringDay;

        WeekDay(int indices, String stringDay)
        {
            this.indices = indices;
            this.stringDay = stringDay;
        }


        public String getIdWithName(String name){
            
        }


}