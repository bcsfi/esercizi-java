import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) {

        String url = "https://www.example.com";

        try {
            Document doc = Jsoup.connect(url).get();
            System.out.println(doc.html()); // Stampa il contenuto della pagina
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}