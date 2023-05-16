import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main
{
    Map<String, ArrayList<Double>> m = new HashMap<>();
    void aggiungiVoto(String nome, Double voto)
    {
        if (m.containsKey(nome)) {
            m.put(nome, m.get(nome).add(voto));
        } else {
            System.out.print("Lo studente selezionato non esiste");
        }
    }

    public static void main(String[] args)
    {

    }
}