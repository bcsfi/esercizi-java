public class EccezionePersonalizzata extends Exception{
    EccezionePersonalizzata(String error){
        super(error);
    }

    public String getMessage(){
        return "Errore, non hai abbastanza soldi nel tuo conto.";
    }
}
