package net.bcsoft.shape;

public class Cerchio extends Shape{
    private Double raggio;

    public Cerchio(Double raggio){
        setRaggio(raggio);
    }

    public void setRaggio(Double raggio){
        this.raggio = raggio;
    }


    public Double calculateArea() {
        return (raggio * raggio) * Math.PI;
    }

    public Double calculatePerimeter() {
        return 2 * raggio * Math.PI;
    }
}
