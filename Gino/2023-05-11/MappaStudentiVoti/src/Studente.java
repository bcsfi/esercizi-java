import java.util.ArrayList;

public class Studente
{
    private String nome;
    private ArrayList<Voto> voti;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void aggiungiVoto(Voto voto)
    {
        voti.add(voto);
    }
}
