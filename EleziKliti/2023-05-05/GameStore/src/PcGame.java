public class PcGame extends VideoGame {

    public String minRequirements;

     public PcGame(String title, int price, int releaseDate, String minRequirements){
         // Cattura i attributi dalla classe astratta videogame
         super(title, price, releaseDate);
         this.minRequirements = minRequirements;
     }

    public String getMinRequirements(){
         return minRequirements;
    }




}
