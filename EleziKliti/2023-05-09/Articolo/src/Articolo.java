import java.util.Objects;

public class Articolo implements InterfaceArticolo {

    String name;
    double prezzo;

    Articolo(String name, double prezzo){
        this.name = name;
        this.prezzo = prezzo;
    }

    public String getName() {
        return name;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public double getPrezzo(double prezzo) {
        return this.prezzo;
    }

    @Override
    public String toString(){
        return " \n name: " + this.name + " \n Price: " + this.prezzo;
    }

}
