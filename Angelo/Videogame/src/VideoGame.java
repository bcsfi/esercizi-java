public class VideoGame {
    public String titolo;

    public VideoGame(String titolo){
        this.titolo = titolo;
    }

    public abstract double prezzo();

    public abstract int annoDiRilascio();
    public String getTitolo(){
        return titolo;
    }
    public String setTitolo(String titolo){
        this.titolo = titolo;
    }
    //public void printType(){
        //System.out.println()
    }
}

class ConsoleGame extends VideoGame{

    String piattaforma;

    public ConsoleGame(String titolo, String piattaforma){
        super(titolo);
        this.piattaforma = piattaforma;

    }
    @Override
    public double prezzo() {
        return 0;
    }
    @Override
    public int annoDiRilascio() {
        return 0;
    }

}
class PCGame extends VideoGame{
    String requisitiMinimiSistema;
    public PCGame(String titolo, String requisitiMinimiSistema){
        super(titolo);
        this.requisitiMinimiSistema = requisitiMinimiSistema;

    }

}



