import java.util.List;
import java.util.ArrayList;
public class Catalogo <E extends Articolo>{
    private List<E> articoli = new ArrayList<E>();
    public void aggiungiArticolo(E art){
        articoli.add(art);
    }
    public List<E> getArticoliSottoPrezzo(double prezzo){
        List<E> articoliSottoPrezzo = new ArrayList<E>();
        for (E art : articoli){
            if (art.getPrezzo() < prezzo){
                articoliSottoPrezzo.add(art);
            }
        }
        return articoliSottoPrezzo;
    }
    public String toString(){
        StringBuilder fullCat = new StringBuilder();
        for (E art: articoli){
            fullCat.append(art.toString()).append(" ");
        }
        return fullCat.toString();
    }
}
