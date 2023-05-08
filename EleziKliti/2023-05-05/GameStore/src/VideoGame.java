public class VideoGame {

    private String title;
    private int    price;
    private int    releaseDate;

    public VideoGame(String title, int price, int releaseDate){
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public String getTitle(){return title;}
    public int getPrice(){return price;}
    public int getReleaseDate(){return releaseDate;}



}
