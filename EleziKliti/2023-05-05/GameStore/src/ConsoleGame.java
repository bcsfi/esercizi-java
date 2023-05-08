public class ConsoleGame extends VideoGame
{

    private final String platform;

    // Costructor for ConsoleGame
    public ConsoleGame(String title, int price, int releaseDate, String platform){
        // Cattura i attributi dalla classe astratta videogame
        super(title, price, releaseDate);
        this.platform = platform;
    }


    public String getPlatform(){
        return platform;
    }



}
