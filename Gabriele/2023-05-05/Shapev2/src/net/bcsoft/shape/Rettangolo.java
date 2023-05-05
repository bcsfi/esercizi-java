package net.bcsoft.shape;

public class Rettangolo extends Shape{
    private Double lunghezza, larghezza;

    public Rettangolo(Double lunghezza, Double larghezza){
        setLarghezza(larghezza);
        setLunghezza(lunghezza);
    }

    public void setLunghezza(Double lunghezza){
        this.lunghezza = lunghezza;
    }

    public void setLarghezza(Double larghezza){
        this.larghezza = larghezza;
    }

    public Double calculateArea() {
        return lunghezza * larghezza;
    }

    public Double calculatePerimeter() {
        return (lunghezza + larghezza) * 2;
    }
}
