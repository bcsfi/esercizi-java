package net.bcsoft;

import java.util.List;

public class GestoreContiCorrenti
{
    public GestoreContiCorrenti() {}
    // 1 crea qui sotto le due funzioni rosse che saranno di tipo stringa e avranno come return una stringa che corrisponde alla somma risepptivamente (quantita transazioni) e (giacenza media)
    private String numeroTransazione(List<Transazione> transazioni) {
        int numeroTransazioni = transazioni.size();
        return "Quantità transazioni: " + numeroTransazioni;
    }
    // 2 crea poi una funzione che calcaola la giacenza totale e la aggiunge alla stringa e poi crea un file in un path di defoult con la stringa generata dalla somma fatta in precedenza
    public static String giacenzaMedia(List<EstrattoContoMensile> estrattiConto) {
        double sommaGiacenze = 0.0;
        for (EstrattoContoMensile estrattoConto : estrattiConto) {
            sommaGiacenze += estrattoConto.getGiacenzaInizioMese();
        }
        double giacenzaMedia = sommaGiacenze / estrattiConto.size();
        return "Giacenza media: " + giacenzaMedia;
    }
    void creaFile()
    {
        String risultato = "";

        risultato += numeroTransazione() + giacenzaMedia();
    }
}
