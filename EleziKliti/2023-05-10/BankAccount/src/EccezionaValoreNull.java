public class EccezionaValoreNull extends Exception{

    EccezionaValoreNull(String error){
        super(error);
    }

    public String getMessage(){
        return "Errore, Valori null non accettati nel programma.";
    }

}
