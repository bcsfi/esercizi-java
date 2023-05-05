public class Main {
    /**
     * Negozio di video giochi
     * Contiene in vendita due tipi di giochi.
     * //
     * VideoGame   | Classe astratta
     * ConsoleGame | Giochi Per console (Titolo, Prezzo, Anno di rialscio)
     * PcGame      | Giochi per PC (Titolo, Prezzo, Anno di rialscio, piattaforma)
     * //
     * @param args
     */

    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        ConsoleGame cod = new ConsoleGame("Call of duty", 70, 2016, "wii");
        PcGame codPc = new PcGame("Call of duty for pc", 70, 2016, "Nvidia Gtx 3090");

        System.out.print(cod.getPlatform());
        System.out.print(codPc.getMinRequirements());

    }



}