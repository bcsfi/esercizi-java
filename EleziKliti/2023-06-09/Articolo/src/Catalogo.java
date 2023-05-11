import java.util.ArrayList;

public class Catalogo {


    ArrayList<Articolo> catalogo = new ArrayList<Articolo>();

    // Aggiunge i articoli al catalogo
    public void AggiungiArticolo(Articolo d){
        this.catalogo.add(d);
    }

    // Lista restituisce il catalogo con tutti i articoli
    public void getArticoliSottoPrezzo(double d){
        System.out.printf("CATALOGO \tNOME \t \t prezzo (sotto " + d + ")\n");
        for (Articolo articolo : catalogo) {
            if (articolo.getPrezzo() < d) {
                System.out.printf("\t \t    %s", articolo.getName());
                System.out.printf("\t \t    %f \n", articolo.getPrezzo());
            }
        }
    }

    // Stampa tutto il catalogo
    public String toString(){
        System.out.printf("CATALOGO \tNOME \t \t prezzo (tutti i prezzi): \n");
            for(Articolo art : this.catalogo){
                System.out.printf("\t \t    %s", art.getName());
                System.out.printf("\t \t    %f \n", art.getPrezzo());
            }
        return "\n\tCatalogo stampato.";
    }



}
