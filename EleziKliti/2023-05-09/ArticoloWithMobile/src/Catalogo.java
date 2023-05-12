import java.util.ArrayList;
import java.util.Objects;

public class Catalogo {


    ArrayList<InterfaceArticolo> catalogo = new ArrayList<InterfaceArticolo>();

    // Aggiunge i articoli al catalogo
    public void aggiungiArticolo(InterfaceArticolo d){
        this.catalogo.add(d);
    }

    // Lista restituisce il catalogo con tutti i articolis
    public void getArticoliSottoPrezzo(double d){
        System.out.printf("CATALOGO \tNOME \t \t prezzo (sotto      " + d + ")\n");
        for (InterfaceArticolo articolo : catalogo) {
            if(articolo instanceof Articolo){
                if (articolo.getPrezzo() < d) {
                    System.out.printf("\t \t    %s", articolo.getName());
                    System.out.printf("\t \t    %f \n", articolo.getPrezzo());
                }
            }
        }
    }

    // Stampa tutto il catalogo
    public String toString(){
        System.out.printf("CATALOGO \tNOME \t \t prezzo (tutti i prezzi): \n");
        for (InterfaceArticolo articolo : catalogo) {
            if(articolo instanceof Articolo) {
                for (InterfaceArticolo d : catalogo) {
                    System.out.printf("\t \t    %s", d.getName());
                    System.out.printf("\t \t    %f \n", d.getPrezzo());
                }
            }

        }
        return "\n\tCatalogo stampato.";
    }


    ArrayList<Mobile> mobiliConPrezzoInferiore = new ArrayList<>();

    public ArrayList<Mobile> verificaSeMinore(int price, int width, int height, int depth){
            for(InterfaceArticolo istanzaEstratta : this.catalogo){
                if(istanzaEstratta instanceof Mobile){
                    boolean b = (istanzaEstratta.getPrezzo() > price && istanzaEstratta.getWidth() > width);
                    boolean c = (istanzaEstratta.getHeight() > height && istanzaEstratta.getDepth() > depth);

                    if(b && c){
                        this.mobiliConPrezzoInferiore.add((Mobile) istanzaEstratta);
                    }

                }
            }
            return this.mobiliConPrezzoInferiore;
        }



}
