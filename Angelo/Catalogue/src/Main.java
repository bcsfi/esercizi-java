import java.util.List;


public class Main {
    public static void main(String[] args) {
       Catalogo<Prodotto> catalogo = new Catalogo<Prodotto>();
       catalogo.aggiungiArticolo(new Prodotto("USB Drive", 6.99));
       catalogo.aggiungiArticolo(new Prodotto("HDMI Cable", 10.99));
       catalogo.aggiungiArticolo(new Prodotto("Monitor LED 22'", 179.99));
       catalogo.aggiungiArticolo(new Prodotto("HP 250", 699.99));
       catalogo.aggiungiArticolo(new Prodotto("Mouse", 9.99));
       catalogo.aggiungiArticolo(new Prodotto("Alimentatore", 18.99));
       System.out.println("Catalogo completo: ");
       System.out.println(catalogo);
       System.out.println("prodotti sotto i 20 euro: ");
       List<Prodotto> articoliSottoPrezzo = catalogo.getArticoliSottoPrezzo(20);
       for (Prodotto p : articoliSottoPrezzo){
           System.out.println(p);
        }
    }
}